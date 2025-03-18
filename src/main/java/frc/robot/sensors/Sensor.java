package frc.robot.sensors;

public abstract class Sensor {
    protected String name;

    public Sensor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void initialize();
    public abstract void update();
}
