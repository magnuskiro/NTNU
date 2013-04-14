package no.ntnu.idi.dm.clustering;

/*
 * Copyright 2004-2010 Information & Software Engineering Group (188/1)
 *                     Institute of Software Technology and Interactive Systems
 *                     Vienna University of Technology, Austria
 *                     
 *                     and myself
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.ifs.tuwien.ac.at/dm/somtoolbox/license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import no.ntnu.idi.dm.distancemetrics.EuclideanDistance;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

/**
 * Pretty much the classic K-Means clustering. Tried to keep it simple, though.
 * 
 * @author Robert Neumayer
 * @version $Id: KMeans.java 3921 2010-11-05 12:54:53Z mayer $
 */

public class KMeans {

	protected double[][] data;

	private int k;  //the number of desired clusters
	private int numberOfInstances; //the number of data points 
	private int numberOfAttributes; //the number of attributes each data point has. The number of dimensions each data point has.

	// keep min, max values and the differences between them
	private double[] minValues, maxValues, differences;

	// this one will be used for looking up cluster assignments
	// which in turn will help to terminate the training process
	// as soon as we don't experience any changes in cluster assignments
	private Hashtable<Integer, Integer> instancesInClusters;

    private int lastNumberOfUpdates = Integer.MAX_VALUE;

	protected Cluster[] clusters;

	// TODO remove this after testing
	private static long RANDOM_SEED = 1234567;

	/**
	 * Default constructor (as much defaulting as possible). Uses linear
	 * initialisation and Euclidean distance.
	 * 
	 * @param k
	 *            number of clusters
	 * @param data
	 *            guess
	 */
	public KMeans(int k, double[][] data) {
		this(k, data, new EuclideanDistance());
	}

	/**
	 * Construct a new K-Means object.
	 * 
	 * @param k
	 *            number of clusters
	 * @param data
	 *            the data set
	 * @param distanceFunction
	 *            an LnMetric of your choice
	 */
	public KMeans(int k, double[][] data, EuclideanDistance distanceFunction) {
		this.k = k;
		this.numberOfAttributes = data[0].length;
		this.numberOfInstances = data.length;
		this.instancesInClusters = new Hashtable<Integer, Integer>();
		this.clusters = new Cluster[k];
		this.data = data;

		// initialise a couple of things
		initMinAndMaxValues();

		// init with random instances
		initClustersRandomlyOnInstances(distanceFunction);

		// printClusters();
		// this one is to do a first assignment of data points to clusters
		recalculateClusters();

        assignAndUpdate();
	}

	/**
	 * Update for as long as instances move between clusters. "Not moving" means
	 * that there hasn't been a change in the last
	 * {@link # NUMBER_OF_UPDATE_RANGE} steps ({@value # NUMBER_OF_UPDATE_RANGE}).
	 */
	public void assignAndUpdate() {
		// train for as we have updates in the cluster assignments
		boolean update = true;
		while (update) {
			update = recalculateClusters();
		}
		removeEmptyClusters();
	}

    /**
     * A classic training step in the K-Means world.
     *
     * @return whether this step brought any changes or not. Note, this one also
     *         says no if there were as many changes as in the last step.
     */
    private boolean recalculateClusters() {
        boolean converged = true;

        int numUpdates = 0;

        // assign instances to clusters
        // for all instances
        for(int i = 0; i < this.data.length; i++){
            // find closes centroid for this node/instance
            int index = getIndexOfClosestCluster(this.data[i]);

            // if the cluster don't contain the current node/instance.
            if(! clusters[index].getIndices().contains(index) ){
                // add this node/instance to the closest cluster.
                clusters[index].addIndex(i);
                // set the converged value to false as long as there are changes on node/instance assignment.
                converged = false;
                numUpdates += 1;
            }
        }
        calculateNewCentroids();

        // if there are as many instance updates this turn as last time we consider the k-means as converged.
        // which is stupid, because the first iteration can have as many changes at the next one without converging.
        if (numUpdates==this.lastNumberOfUpdates){
            converged = false;
        }

        // returns true if no node/instance changed its cluster assignment.
        return converged;
    }

	/**
	 * Searches for clusters which have no instances assigned. These are then
	 * removed
	 */
	private void removeEmptyClusters() {
		Vector<Cluster> nonEmptyClusters = new Vector<Cluster>();
		for (Cluster cluster : clusters) {
			if (cluster.getNumberOfInstances() != 0) {
				nonEmptyClusters.add(cluster);
			}
		}
		Cluster[] remainingClusters = new Cluster[nonEmptyClusters.size()];
		for (int i = 0; i < nonEmptyClusters.size(); i++) {
			remainingClusters[i] = nonEmptyClusters.elementAt(i);
		}
		clusters = remainingClusters;
	}

	/**
	 * Batch calculation of all cluster centroids.
	 */
	private void calculateNewCentroids() {
        // for all clusters
		for (int clusterIndex = 0; clusterIndex < k; clusterIndex++) {
            // if no nodes(instances) assigned to given centroid
			if (clusters[clusterIndex].getNumberOfInstances() == 0) {
                // calculate new centroid for given cluster.
                double[] newCentroid = getSubstituteCentroid();
                // if there is a new centroid for the given cluster.
				if (newCentroid != null) {
                    // set new centroid for cluster.
					clusters[clusterIndex].setCentroid(newCentroid);
				}
			}
            // calculate the centroid for this cluster.
			clusters[clusterIndex].calculateCentroid(data);
		}
	}

	/**
	 * Get a new centroid for empty clusters. We therefore take the instance
	 * with the largest SSE to the cluster centroid having the largest SSE. Get
	 * the idea? Read slowly.
	 * 
	 * @return a new centroid (rather: a clone thereof :))
	 */
	private double[] getSubstituteCentroid() {
		double maxSSE = Double.NEGATIVE_INFINITY;
		int maxSSEIndex = -1;

        // for all clusters
		for (int clusterIndex = 0; clusterIndex < k; clusterIndex++) {
            // recalculate centroid for the given cluster.
            clusters[clusterIndex].calculateCentroid(data);
			double currentSSE = clusters[clusterIndex].SSE(data);
			if (currentSSE > maxSSE) {
				maxSSE = currentSSE;
				maxSSEIndex = clusterIndex;
			}
		}

		if (clusters[maxSSEIndex].getInstanceIndexWithMaxSSE(data) == -1) {
			return null;
		}
		return data[clusters[maxSSEIndex].getInstanceIndexWithMaxSSE(data)].clone();
	}

	/**
	 * Get the index of the closest cluster for the given instance index. Note
	 * that in case of equally distant clusters we assign the first found
	 * cluster. At the end of the day this means that the clusters with lower
	 * indices will have a tendency to be larger. It hopefully won't have too
	 * much impact, possibly a random assignment in case of equal weights would
	 * make sense, however, this would require a couple of steps more in here.
	 * 
	 * @param instance
	 *            the data vector to be assigned
	 * @return index of the closest cluster centre
	 */
	private int getIndexOfClosestCluster(double[] instance) {
		int indexOfClosestCluster = 0;
		double smallestDistance = Double.POSITIVE_INFINITY;
		double currentDistance = 0;
		for (int clusterIndex = 0; clusterIndex < k; clusterIndex++) {
			currentDistance = clusters[clusterIndex]
					.getDistanceToCentroid(instance);
			if (currentDistance < smallestDistance) {
				smallestDistance = currentDistance;
				indexOfClosestCluster = clusterIndex;
			}
		}
		return indexOfClosestCluster;
	}

	/** Take random points from the input data as centroids. */
	private void initClustersRandomlyOnInstances(
			EuclideanDistance distanceFunction) {
		ArrayList<double[]> usedInstances = new ArrayList<double[]>();
		RandomGenerator rg = new JDKRandomGenerator();
		rg.setSeed(RANDOM_SEED);
		// for each cluster
		for (int clusterIndex = 0; clusterIndex < k; clusterIndex++) {
			// draw a random input
			double[] centroid = data[rg.nextInt(data.length - 1)].clone();
			while (usedInstances.contains(centroid)) {
				centroid = data[rg.nextInt(data.length - 1)].clone();
			}
			usedInstances.add(centroid);
			clusters[clusterIndex] = new Cluster(centroid, distanceFunction);
		}
	}

	/**
	 * Utility method to get the min, max, and diff values of the data set. This
	 * is used for scaling the (random) values in the initialisation functions.
	 */
	private void initMinAndMaxValues() {
		minValues = new double[numberOfAttributes];
		maxValues = new double[numberOfAttributes];
		differences = new double[numberOfAttributes];
		// for each attribute
		for (int j = 0; j < numberOfAttributes; j++) {
			// in each instance (i.e. each single value now :-))
			minValues[j] = Double.MAX_VALUE;
			maxValues[j] = Double.MIN_VALUE;
			for (double[] element : data) {
				if (element[j] < minValues[j]) {
					minValues[j] = element[j];
				}
				if (element[j] > maxValues[j]) {
					maxValues[j] = element[j];
				}
			}
			differences[j] = maxValues[j] - minValues[j];
		}
	}

	/**
	 * Get the sum of the squared error for all clusters.
	 * 
	 * @return SSE.
	 */
	public double getSSE() {
		double sse=0;

        // for all clusters get sse
        for (int i = 0; i < clusters.length; i++){
            sse += clusters[i].SSE(data);
        }

		return sse;
	}

	/**
	 * 
	 * @return SSB.
	 */
	public double getSSB() {
		double ssb=0;

        // create a cluster containing all the data and calculate the centroid for all the data.
        Cluster cluster = new Cluster(data[0]);
        cluster.calculateCentroid(data);

        // sum(i) for |c(i)| ( (m-m(i))^2 )

        for (int i = 0; i < clusters.length; i++){
            // use the global centroid to calculate the SSB.
            ssb += clusters[i].SSB(cluster.getCentroid());
        }

		return ssb;
	}

	/**
	 * Get the sum of the squared error for single clusters.
	 * 
	 * @return several SSEs.
	 */
	public double[] getSSEs() {
		double[] sse = new double[k];
		for (int i = 0; i < clusters.length; i++) {
			sse[i] = clusters[i].SSE(data);
		}
		return sse;
	}

	public void printCentroids() {
		for (int i = 0; i < clusters.length; i++) {
			System.out.println(i + " / " + clusters[i].SSE(data) + " / "
					+ clusters[i].getNumberOfInstances() + " / "
					+ ArrayUtils.toString(clusters[i].getCentroid()));
		}
	}

	public void printCentroidsShort() {
		for (int i = 0; i < clusters.length; i++) {
			System.out.println("\t" + i + " / " + clusters[i].SSE(data) + " / "
					+ clusters[i].getNumberOfInstances());
		}
	}

	public double getAverageSilhouetteValue() {
		double silhouette = 0;

        // Silhouette coefficient algorithm found in "Data Mining, Concepts and Techniques, 3.edition", page 489-490

        for (int i = 0; i < clusters.length; i++){
            double a = 0;
            double b = 0;
            for(int j = 0; j < clusters[i].getIndices().size(); j++){

                // 10.31, from the book
                a += clusters[i].getAverageDistanceOfPoint(data, clusters[i].getIndices().get(j));

                // get the average distance from this point to all other points in the given cluster as long as this cluster is not in it.
                if(!clusters[i].getIndices().contains(j)){
                    // 10.32 from the book
                    double newb = clusters[i].getAverageDistanceOfPointToAllPoints(data, clusters[i].getIndices().get(j));
                    // if the new b value is smaller then the previous recorded one.
                    if(newb<b){
                        // set a new minimum b.
                        b=newb;

                    }
                }
            }
            // 10.33 from the book.
            if (a<b){
                silhouette = (b-a) / b;
            }
            else{
                silhouette = (b-a) / a;
            }

            // get the average
            silhouette = silhouette/2;
        }

		return silhouette;
	}
}
