package edu.ntnu.robocode.jsniper.robot;

import edu.ntnu.robocode.jsniper.Config;
import edu.ntnu.robocode.jsniper.data.Position;
import edu.ntnu.robocode.jsniper.data.PositionData;
import edu.ntnu.robocode.jsniper.data.PositionList;
import robocode.BattleEndedEvent;
import robocode.RoundEndedEvent;

import java.awt.*;
import java.awt.geom.Ellipse2D;

//Observes positions of the opponent for each round and stores them in a file at the end of battle.
public class ObserverRobot extends BaseRobot {
    public void onPaint(Graphics2D g) {
        if (positions.size() <= Config.lookback)
            return;

        g.setColor(Color.RED);
        PositionList recentPositions = positions.takeRight(Config.lookback);

        for (Position p : recentPositions)
            g.fill(new Ellipse2D.Double(p.x, p.y, 7, 7));
    }

    //At the end of each round store the positions in a static PositionData class
    public void onRoundEnded(RoundEndedEvent e) {
        PositionData.add(positions.normalized(getBattleFieldWidth(), getBattleFieldHeight()));
    }

    //Save positions to a file.
    public void onBattleEnded(BattleEndedEvent e) {
        PositionData.save(Config.path, Config.dataFile);
    }
}
