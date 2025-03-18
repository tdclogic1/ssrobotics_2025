
package frc.robot.sensors;

import edu.wpi.first.wpilibj.ADIS16470_IMU;

public class GyroSensor extends Sensor {
    private ADIS16470_IMU gyro;

    public GyroSensor(String name) {
        super(name);
    }

    @Override
    public void initialize() {
        gyro = new ADIS16470_IMU();
        gyro.calibrate();
    }

    @Override
    public void update() {
        // Gyro auto-updates; custom logic can be added here.
    }

    public double getAngle() {
        return gyro.getAngle();
    }
}
