// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class ShooterReverse extends CommandBase {

  Shooter reverse;
  /** Creates a new ShooterReverse. */
  public ShooterReverse(Shooter backwards) {
    // Use addRequirements() here to declare subsystem dependencies.
    reverse = backwards;
    addRequirements(reverse);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {reverse.reverse();}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {reverse.stop();}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
