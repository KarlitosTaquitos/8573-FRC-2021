// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {

  private CANSparkMax elevator;
  private CANEncoder elEncoder;
  private final double maxHeight = 7;

  /** Creates a new Elevator. */
  public Elevator() {
    // elevator = new PWMSparkMax(Constants.EL);

    // EDIT THIS IF THE MOTOR IS SWITCHED TO BRUSHED =========VV
    elevator = new CANSparkMax(Constants.Motors.ELEVATOR, MotorType.kBrushless);
    elEncoder = elevator.getEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rise() {
    elevator.set(0.5);
  }

  public void stop() {
    elevator.set(0.05);
  }

  public void fall() {
    elevator.set(-0.08);
  }

  public void setMotor(double n) {
    elevator.set(n);
  }
  
  public void setBottomPosition() {
    elEncoder.setPosition(0);
  }

  public double readPosition() {
    return elEncoder.getPosition();
  }

  public boolean aboveMaxHeight() {
    return readPosition() > maxHeight;
  }
}
