package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class Climber extends SubsystemBase {
    private final CANSparkMax climberMotor;
    private final RelativeEncoder encoder;

    public Climber() {
        climberMotor = new CANSparkMax(Constants.Climber.kClimberMotorCANId, MotorType.kBrushless);
        climberMotor.restoreFactoryDefaults();

        encoder = climberMotor.getEncoder();
        resetEncoder();
        
        climberMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    public void resetEncoder() {
        encoder.setPosition(Constants.Climber.kTopPosition);
    }

    // Moves counterclockwise (downwards from 12 to 8:30)
    public void moveDown() {
        if (encoder.getPosition() > Constants.Climber.kBottomPosition) {
            climberMotor.set(-Constants.Climber.kClimberSpeed);
        } else {
            stop();
        }
    }

    // Moves clockwise (back upwards towards 12 o'clock)
    public void moveUp() {
        if (encoder.getPosition() < Constants.Climber.kTopPosition) {
            climberMotor.set(Constants.Climber.kClimberSpeed);
        } else {
            stop();
        }
    }

    public void stop() {
        climberMotor.set(0);
    }

    @Override
    public void periodic() {
        // Ensure motor stops at limits
        if (encoder.getPosition() <= Constants.Climber.kBottomPosition && climberMotor.get() < 0) {
            stop();
        } else if (encoder.getPosition() >= Constants.Climber.kTopPosition && climberMotor.get() > 0) {
            stop();
        }
    }

    public double getEncoderPosition() {
        return encoder.getPosition();
    }
}
