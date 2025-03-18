package frc.robot.sensors;

public abstract class CameraSensor extends Sensor {
    
    public CameraSensor(String name) {
        super(name);
    }
    
    public abstract void initialize();
    public abstract void update();
    
    // Possible common camera-specific methods
    public abstract boolean hasValidData();
}
