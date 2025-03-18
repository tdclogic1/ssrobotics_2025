package frc.robot.sensors;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoMode.PixelFormat;

public class StandardCamera extends CameraSensor {
    private UsbCamera camera;

    public StandardCamera(String name) {
        super(name);
    }

    @Override
    public void initialize() {
        camera = CameraServer.startAutomaticCapture(name, 0);
        camera.setVideoMode(PixelFormat.kMJPEG, 320, 240, 30);
    }

    @Override
    public void update() {
        // USB camera streams automatically
    }

    @Override
    public boolean hasValidData() {
        return camera.isConnected();
    }
}
