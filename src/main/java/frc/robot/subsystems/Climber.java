// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Climber extends SubsystemBase {

  private CANSparkMax climber_1;
  private CANSparkMax climber_2;
  
  /** Creates a new Climber. */
  public Climber() {
    /*climber_1 = new PWMSparkMax(Constants.CL1);
    climber_2 = new PWMSparkMax(Constants.CL2);*/

    climber_1 = new CANSparkMax(Constants.Motors.CLIMB_1, MotorType.kBrushless);
    climber_2 = new CANSparkMax(Constants.Motors.CLIMB_2, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void climb() {
    climber_1.set(1);
    climber_2.set(1);
  }

  public void stop() {
    climber_1.set(0);
    climber_2.set(0);
  }

  public void down() {
    climber_1.set(-0.1);
    climber_2.set(-0.1);
  }
}
