package edu.ntnu.robocode.jsniper.data;

import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataPair;
import org.encog.ml.data.basic.BasicMLDataSet;

import java.util.ArrayList;
import java.util.List;

//List of Position objects with operations for manipulation and converting to Encog objects.
public class PositionList extends ArrayList<Position> {
    //Copies part of the list into a new list. Required because built-in List.sublist creates a view, not a copy!
    public PositionList slice(int from, int until) {
        PositionList l = new PositionList();

        for (int i = from; i < until; i++)
            l.add(get(i));

        return l;
    }

    //Takes first n positions into a new list.
    public PositionList take(int n) {
        return slice(0, n);
    }

    //Takes n positions from the right into a new list.
    public PositionList takeRight(int n) {
        return slice(size() - n, size());
    }

    //Creates a list of sliding windows of size n.
    public List<PositionList> sliding(int n) {
        List<PositionList> l = new ArrayList<PositionList>();

        for (int i = 0; i <= size() - n; i++)
            l.add(slice(i, i + n));

        return l;
    }

    //Divides x by width and y by height for all positions in the list.
    public PositionList normalized(double width, double height) {
        PositionList l = new PositionList();

        for (Position p : this)
            l.add(p.normalized(width, height));

        return l;
    }

    //Converts to MLData with features x1, y1, x2, y2, ...
    public MLData toData() {
        MLData data = new BasicMLData(size() * 2);

        for (int i = 0; i < size(); i++) {
            data.add(i * 2, get(i).x);
            data.add(i * 2 + 1, get(i).y);
        }

        return data;
    }

    //Converts to MLDataPair where the last position is the output and the rest is the input.
    public MLDataPair toDataPair() {
        return new BasicMLDataPair(take(size() - 1).toData(), takeRight(1).toData());
    }

    //Converts to MLDataSet where each instance is a sequence of positions of size n.
    public MLDataSet toDataSet(int n) {
        MLDataSet dataSet = new BasicMLDataSet();

        for (PositionList l : sliding(n))
            dataSet.add(l.toDataPair());

        return dataSet;
    }
}