package edu.ntnu.robocode.jsniper.data;

import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Stores and manipulates positions of an opponent. Everything is static here to access the data across rounds.
public class PositionData {
    static List<PositionList> rounds = new ArrayList<PositionList>(); //positions for each round

    public static void add(PositionList positions) {
        rounds.add(positions);
    }

    //Stores data to file using Java built-in serialization.
    public static void save(String dirPath, String fileName) {
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(dirPath + "/" + fileName));
            out.writeObject(rounds);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Loads data from a file serialized by Java built-in serialization.
    public static void load(String path) {
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream(path));
            rounds = (List<PositionList>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Converts to MLDataSet
    public static MLDataSet toDataSet(int n) {
        MLDataSet dataSet = new BasicMLDataSet();

        for (PositionList positions : rounds)
            for (MLDataPair dataPair : positions.toDataSet(n))
                dataSet.add(dataPair);

        return dataSet;
    }
}