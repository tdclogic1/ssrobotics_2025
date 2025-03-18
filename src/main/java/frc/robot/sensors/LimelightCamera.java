package frc.robot.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightCamera extends CameraSensor {
    private NetworkTable limelightTable;

    public LimelightCamera(String name) {
        super(name);
    }

    @Override
    public void initialize() {
        limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
        setLedMode(1); // LEDs off initially
    }

    @Override
    public void update() {
        // NetworkTables auto-update
    }

    @Override
    public boolean hasValidData() {
        return limelightTable.getEntry("tv").getDouble(0) == 1;
    }

    public void setLedMode(int mode) {
        limelightTable.getEntry("ledMode").setNumber(mode);
    }

    public double getTargetX() {
        return limelightTable.getEntry("tx").getDouble(0.0);
    }

    public double getTargetY() {
        return limelightTable.getEntry("ty").getDouble(0.0);
    }
}
