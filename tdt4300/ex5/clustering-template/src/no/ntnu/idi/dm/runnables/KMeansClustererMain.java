package no.ntnu.idi.dm.runnables;

import no.ntnu.idi.dm.clustering.KMeans;
import no.ntnu.idi.dm.clustering.VectorTools;

import java.util.ArrayList;

public class KMeansClustererMain {

    double[][] sse = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
    double[][] ssb = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
    double[][] sum = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
    double[][] silhouette = {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        KMeansClustererMain a = new KMeansClustererMain();

        // should compare with k=2...8
        for(int k = 2; k<=8; k++){
            a.doClustering(k);
        }

        a.print("sse", a.sse, 0);
        a.print("ssb", a.ssb, 0);
        a.print("sum", a.sum, 0);
        a.print("silhouette", a.silhouette, 0);

        System.out.println("---------------------------------");

        a.print("sse", a.sse, 1);
        a.print("ssb", a.ssb, 1);
        a.print("sum", a.sum, 1);
        a.print("silhouette", a.silhouette, 1);

    }

    public void print(String name, double[][] arr, int file){
        String out = name+"\n";
        for(double[] d: arr){
            out += d[file]+"\n";
        }
        System.out.println(out);
    }

    public void doClustering(int k){

        String fileNames[] = new String[] { "iris.arff",
                "segment-challenge.arff" };

        int file = 0;
        // load data set (in a way that just works)
		for (String fileName : fileNames) {

			double[][] data = VectorTools.readArffFile(fileName);
			String[] classLabels = VectorTools.getClassLabels();

            /*
			System.out.println("loaded input file: " + fileName);
			System.out.println("instances: " + data.length);
			System.out.println("attributes: " + data[0].length);
			System.out.println("first instance: " + Arrays.toString(data[0])
					+ " class label: " + classLabels[0]);
			System.out.println("last instance: "
					+ Arrays.toString(data[data.length - 1]) + " class label: "
					+ classLabels[data.length - 1]);
            */
            //System.out.println("-----");

			KMeans kmeans = new KMeans(k, data);

            //System.out.println(k);

			double sse = kmeans.getSSE();
			//System.out.println("SSE " + sse);
            this.sse[k-2][file] = sse;

            double ssb = kmeans.getSSB();
			//System.out.println("SSB " + ssb);
            this.ssb[k-2][file] = ssb;

			//System.out.println("Sum: " + (sse + ssb));
            this.sum[k-2][file] = sse+ssb;

            this.silhouette[k-2][file] = kmeans.getAverageSilhouetteValue();
			//System.out.println("Silhouette " + this.silhouette[k]);

            file ++;
		}
	}

}
