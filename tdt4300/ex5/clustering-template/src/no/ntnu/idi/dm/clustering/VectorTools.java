package no.ntnu.idi.dm.clustering;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class VectorTools {

	/**
	 * get the max indices of the numberOfIndices largest values in an array
	 * 
	 * @param array
	 *            the input array
	 * @param numberOfIndices
	 *            the desired number of indices to get in return
	 * @return indices of largest values in the array
	 */
	public static int[] getIndicesOfMaxValues(int[] array, int numberOfIndices) {
		int[] indices = new int[numberOfIndices];

		// sort first, then get indices from original array we need to
		// clone here, otherwise nothing is going to work anymore
		int[] sortedArray = array.clone();
		Arrays.sort(sortedArray);

		// get in descending order, i.e. reverse
		ArrayUtils.reverse(sortedArray);

		// we get the indices of all max values

		// we count double occurrences of values and take this
		// into account when getting the indices, we hence avoid
		// double indices in the result
		double oldValue = 0d;
		int skip = 0;
		for (int i = 0; i < numberOfIndices; i++) {
			if (sortedArray[i] == oldValue) {
				skip++;
			} else {
				skip = 0;
				oldValue = sortedArray[i];
			}

			int maxIndex = getIndexOfValue(array, sortedArray[i], skip);
			// we avoid everything being set to -1
			if (maxIndex == -1) {
				return indices;
			}
			indices[i] = maxIndex;
		}
		return indices;
	}

	/**
	 * get the index of a given value in an array and skip the given number of
	 * indices to avoid duplicate indices in the results, i.e. if the array is
	 * [12, 12, 5, 2] we will return 0 if skip = 0 and 1 if skip = 1
	 * 
	 * @param array
	 *            the input array
	 * @param d
	 *            the value to search for
	 * @return the index
	 */
	private static int getIndexOfValue(int[] array, double d, int skip) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == d && skip-- == 0) {
				return i;
			}
		}
		return -1;
	}

	public static String[] classLabels;

	/**
	 * read the given arff file into a double[][]
	 * 
	 * @param fileName
	 * @return data matrix
	 */
	public static double[][] readArffFile(String fileName) {
		DataSource source;
		try {
			source = new DataSource(fileName);
			Instances inputData = source.getDataSet();
			inputData.randomize(new Random(12));
			// setting class attribute if the data format does not provide this
			// information
			// For example, the XRFF format saves the class attribute
			// information as well
			if (inputData.classIndex() == -1) {
				inputData.setClassIndex(inputData.numAttributes() - 1);
			}

			classLabels = new String[inputData.numInstances()];
			double[][] data = new double[inputData.numInstances()][];

			Enumeration enumerateInstances = inputData.enumerateInstances();
			int l = 0;

			// System.out.println("numinstances: " + inputData.numInstances());
			while (enumerateInstances.hasMoreElements()) {
				// System.out.println("instance: " + l);
				Instance v = (Instance) enumerateInstances.nextElement();
				classLabels[l] = v.stringValue(v.numValues() - 1);
				// we skip the class attribute here
				double[] vector = new double[v.numValues() - 1];
				// System.out.println("numvalues: " + v.numValues());
				// we skip the class attribute here too
				double length = 0d;
				for (int i = 0; i < v.numValues() - 1; i++) {
					vector[i] = v.value(i);
					length += vector[i] * vector[i];
				}
				// and we normalise to unit lenght
				for (int i = 0; i < v.numValues() - 1; i++) {
					vector[i] = vector[i] / Math.sqrt(length);
				}
				data[l] = vector;
				l++;
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		// in case we can't load it, we return null
		return null;
	}

	public static String[] getClassLabels() {
		return classLabels;
	}

}
