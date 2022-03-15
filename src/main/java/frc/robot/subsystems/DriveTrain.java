package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
    
    //private VictorSP front_left, front_right, back_left, back_right;
    private CANSparkMax front_left, front_right, back_left, back_right;
    private CANEncoder lEncoder, rEncoder;

    public DriveTrain() {
        front_left = new CANSparkMax(Constants.DriveMotors.FL, MotorType.kBrushless);
        front_right = new CANSparkMax(Constants.DriveMotors.FR, MotorType.kBrushless);
        back_left = new CANSparkMax(Constants.DriveMotors.BL, MotorType.kBrushless);
        back_right = new CANSparkMax(Constants.DriveMotors.BR, MotorType.kBrushless);

        lEncoder = front_left.getEncoder();
        rEncoder = front_right.getEncoder();
    }

    public void arcadeDrive(Joystick stick) {
        // get xaxis and yaxis values
        double xAxis, yAxis;
        xAxis = stick.getRawAxis(Constants.Axes.X);
        yAxis = stick.getRawAxis(Constants.Axes.Y);

        // create a dead zone so it's not jittery
        if (xAxis < 0.15 && xAxis > -0.15) {
            xAxis = 0;
        }
    
        if (yAxis < 0.15 && yAxis > -0.15) {
            yAxis = 0;
        }
        
        
        // calculate speed and curve
        // can be changed
        double speed = yAxis;
        double curve = xAxis;

        double leftPower = (speed - curve) * -1;
        double rightPower = speed + curve;

        if (stick.getRawButton(12)) {
            leftPower *= 0.25;
            rightPower *= 0.25;
        }
        else if(stick.getRawButton(11)){
            // leave values alone
        }
        else {
            leftPower *= 0.85;
            rightPower *= 0.85;
        }

        
            
        

        // set motors to the correct speeds       
        front_left.set(leftPower * Constants.Multipliers.POWER_MULT);
        back_left.set(leftPower * Constants.Multipliers.POWER_MULT);
        front_right.set(rightPower * Constants.Multipliers.POWER_MULT);
        back_right.set(rightPower * Constants.Multipliers.POWER_MULT);        
    }

    public void resetEncoder() {
        lEncoder.setPosition(0);
        rEncoder.setPosition(0);
    }

    public double readLeftEncoder() {
        return lEncoder.getPosition();
    }

    public double readRightEncoder() {
        return rEncoder.getPosition();
    }

    public boolean lPastAmount(double rots) {
        if (rots >= 0)
            return readLeftEncoder() > rots;
        else return readLeftEncoder() < rots;
    }

    public boolean rPastAmount(double rots) {
        if (rots >= 0)
            return readRightEncoder() > rots;
        else return readRightEncoder() < rots;
    }

    public void setLeft(double speed) {
        front_left.set(speed);
        back_left.set(speed);
    }

    public void setRight(double speed) {
        front_right.set(speed);
        back_right.set(speed);
    }

    public void stop(){
        front_left.set(0);
        back_left.set(0);
        front_right.set(0);
        back_right.set(0);
    }

    public void setBrake() {
        front_left.setIdleMode(CANSparkMax.IdleMode.kBrake);
        back_left.setIdleMode(CANSparkMax.IdleMode.kBrake);
        front_right.setIdleMode(CANSparkMax.IdleMode.kBrake);
        back_right.setIdleMode(CANSparkMax.IdleMode.kBrake);
    }

    public void setCoast() {
        front_left.setIdleMode(CANSparkMax.IdleMode.kCoast);
        back_left.setIdleMode(CANSparkMax.IdleMode.kCoast);
        front_right.setIdleMode(CANSparkMax.IdleMode.kCoast);
        back_right.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }
}
