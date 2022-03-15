// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pulley extends SubsystemBase {

  private CANSparkMax pulley;
  private CANEncoder pullEncoder;
  private final double shootHeight = -0.25;

  /** Creates a new Pulley. */
  public Pulley() {
    pulley = new CANSparkMax(Constants.Motors.PULLEY, MotorType.kBrushless);
    pullEncoder = pulley.getEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void spin(){
    pulley.set(-0.15);
  }

  public void stop(){
    pulley.set(-0.07);
  }

  public void unspin(){
    pulley.set(0.01);
  }

  public void setBottomPosition() {
    pullEncoder.setPosition(0);
  }

  public double readPosition() {
    return pullEncoder.getPosition();
  }

  public boolean aboveShootHeight() {
    return readPosition() < shootHeight;
  }
}
