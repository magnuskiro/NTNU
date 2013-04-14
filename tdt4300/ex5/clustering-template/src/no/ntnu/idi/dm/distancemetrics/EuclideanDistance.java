package no.ntnu.idi.dm.distancemetrics;

/**
 * Implements the L2 or Euclidean metric.
 * 
 */
public class EuclideanDistance {

	public double distance(double[] vector1, double[] vector2) {
		return Math.sqrt( Math.pow( (vector2[0] - vector1[0]), 2) + Math.pow( (vector2[1] - vector1[1]), 2) );
	}

}
