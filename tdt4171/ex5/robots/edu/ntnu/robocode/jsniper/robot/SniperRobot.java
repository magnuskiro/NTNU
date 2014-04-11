package edu.ntnu.robocode.jsniper.robot;

import edu.ntnu.robocode.jsniper.ANN;
import edu.ntnu.robocode.jsniper.Config;
import edu.ntnu.robocode.jsniper.data.Position;
import edu.ntnu.robocode.jsniper.data.PositionList;
import robocode.Rules;
import robocode.ScannedRobotEvent;
import robocode.StatusEvent;
import robocode.util.Utils;

import java.awt.geom.Point2D;

//Predicts positions of the opponent and uses them for aiming.
public class SniperRobot extends BaseRobot {
    static final double BULLET_SPEED = Rules.getBulletSpeed(Config.bulletPower);

    boolean isAiming = false;
    long fireTime = 0;

    ANN ann = new ANN(Config.path, Config.networkFile);

    public void onScannedRobot(ScannedRobotEvent e) {
        super.onScannedRobot(e);
        aim();
    }

    //Aiming based on the predicted positions
    void aim() {
        if (isAiming || positions.size() < Config.lookback * 2) //wait in the beginning of a round to collect positions
            return;

        PositionList recentPositions = positions.takeRight(Config.lookback);

        for (int i = 1; i <= Config.lookahead; i++) {
            Position nextPosition = ann.predict(recentPositions, getBattleFieldWidth(), getBattleFieldHeight());
            recentPositions.add(nextPosition);

            double distance = Point2D.distance(nextPosition.x, nextPosition.y, getX(), getY());
            double bearing = Math.atan2(nextPosition.x - getX(), nextPosition.y - getY());
            double gunTurn = Utils.normalRelativeAngle(bearing - getGunHeadingRadians());

            double timeLeft = i * Config.period; //time before the opponent reaches the position
            double aimTime = Math.abs(gunTurn) / Rules.GUN_TURN_RATE_RADIANS; //time it takes to turn the gun in the right direction
            double bulletTime = distance / BULLET_SPEED; //time for bullet to reach the predicted position

            if (timeLeft >= aimTime + bulletTime) {
                isAiming = true;
                fireTime = getTime() - Math.round(bulletTime); //when to shoot
                setTurnGunRightRadians(gunTurn);
                return;
            }
        }
    }

    //Shoot a bullet when time comes.
    public void onStatus(StatusEvent e) {
        if (isAiming && fireTime <= getTime()) {
            fire(Config.bulletPower);
            isAiming = false;
        }
    }
}