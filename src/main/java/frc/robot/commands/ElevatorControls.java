// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

public class ElevatorControls extends CommandBase {

  Elevator elevator;
  Joystick driver;

  /** Creates a new ElevatorControls. */
  public ElevatorControls(Elevator el, Joystick d) {
    // Use addRequirements() here to declare subsystem dependencies.
    elevator = el;
    driver = d;
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = driver.getRawAxis(Constants.Controls.R_TRIGGER) * Constants.Multipliers.EL_MULT - driver.getRawAxis(Constants.Controls.L_TRIGGER);

    elevator.setMotor(speed * Constants.Multipliers.EL_MULT);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
