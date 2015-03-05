package edu.ntnu.robocode.jsniper.robot;

import edu.ntnu.robocode.jsniper.ANN;
import edu.ntnu.robocode.jsniper.Config;
import edu.ntnu.robocode.jsniper.data.Position;
import edu.ntnu.robocode.jsniper.data.PositionList;

import java.awt.*;
import java.awt.geom.Ellipse2D;

//Demonstrates predicted positions by drawing them as red circles.
public class DemoRobot extends BaseRobot {
    ANN ann = new ANN(Config.path, Config.networkFile);

    //Draw predicted positions
    public void onPaint(Graphics2D g) {
        if (positions.size() <= Config.lookback)
            return;

        g.setColor(Color.RED);
        PositionList recentPositions = positions.takeRight(Config.lookback);

        for (int i = 8; i > 3; i--) {
            Position nextPosition = ann.predict(recentPositions, getBattleFieldWidth(), getBattleFieldHeight());
            recentPositions.add(nextPosition);
            g.fill(new Ellipse2D.Double(nextPosition.x, nextPosition.y, i, i));
        }
    }
}
