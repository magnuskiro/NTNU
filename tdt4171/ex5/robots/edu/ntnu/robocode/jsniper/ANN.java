package edu.ntnu.robocode.jsniper;

import edu.ntnu.robocode.jsniper.data.Position;
import edu.ntnu.robocode.jsniper.data.PositionData;
import edu.ntnu.robocode.jsniper.data.PositionList;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;
import org.encog.persist.EncogDirectoryPersistence;

import java.io.File;

//Uses Encog library to implement ANN for prediction of next position based on recent ones.
public class ANN {
    //Load ANN from file
    public ANN(String dirPath, String fileName) {
    }

    //Predict next position based on lookback previous positions
    public Position predict(PositionList positions, double width, double height) {
        return positions.get(positions.size() - 1); //returns the last observed position, you will need to return the next predicted position instead
    }
}