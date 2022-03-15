// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake2. */

  private CANSparkMax in_1;
  private CANSparkMax in_2;
  
  public Intake() {
    in_1 = new CANSparkMax(Constants.Motors.INTAKE_1, MotorType.kBrushless);
    in_2 = new CANSparkMax(Constants.Motors.INTAKE_2, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void frontOn() {
    in_1.set(-0.25);
  }

  public void frontRev() {
    in_1.set(0.25);
  }

  public void blueOn() {
    in_2.set(-0.25);
  }

  public void blueRev() {
    in_2.set(0.25);
  }

  public void stop() {
    in_1.set(0);
    in_2.set(0);
  }

  public void release() {
    in_1.set(1);
    in_2.set(1);
  }

  public void feed() {
    in_1.set(-0.5);
    in_2.set(-0.5);
  }
}
