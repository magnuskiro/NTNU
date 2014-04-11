package edu.ntnu.robocode.jsniper.robot;

import edu.ntnu.robocode.jsniper.Config;
import edu.ntnu.robocode.jsniper.data.Position;
import edu.ntnu.robocode.jsniper.data.PositionList;
import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;
import robocode.util.Utils;

//Base robot that tracks the opponent with the radar and collects its positions.
public class BaseRobot extends AdvancedRobot{
    PositionList positions = new PositionList();
    long lastTime = 0;

    public void run() {
        setAdjustRadarForGunTurn(true); //makes radar turn independent of gun turn

        while (true)
            turnRadarRight(10);
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        observe(e);
        scan(e);
    }

    //Rotates the radar in the direction of the opponent
    public void scan(ScannedRobotEvent e) {
        turnRadarRightRadians(Utils.normalRelativeAngle(getHeadingRadians() + e.getBearingRadians() - getRadarHeadingRadians()));
    }

    //Each period store the position of the opponent
    public void observe(ScannedRobotEvent e) {
        if (getTime() - lastTime >= Config.period) {
            double bearing = getHeadingRadians() + e.getBearingRadians();
            double distance = e.getDistance();
            double x = getX() + Math.sin(bearing) * distance;
            double y = getY() + Math.cos(bearing) * distance;
            positions.add(new Position(x, y));
            lastTime = getTime();
        }
    }
}
