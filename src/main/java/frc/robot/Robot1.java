package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.cameras.StandardCamera;
import frc.robot.cameras.LimelightCamera;

public class Robot extends TimedRobot {
    private StandardCamera standardCamera;
    private LimelightCamera limelight;

    @Override
    public void robotInit() {
        standardCamera = new StandardCamera("FrontCam");
        limelight = new LimelightCamera("Limelight");

        standardCamera.initialize();
        limelight.initialize();
    }

    @Override
    public void robotPeriodic() {
        standardCamera.update();
        limelight.update();

        if (limelight.hasTarget()) {
            double targetX = limelight.getTargetX();
            double targetY = limelight.getTargetY();
            double area = limelight.getTargetArea();
            
            // Example: Log Limelight data
            System.out.println("Limelight Target: X=" + targetX + " Y=" + targetY + " Area=" + area);
        }
    }
}
