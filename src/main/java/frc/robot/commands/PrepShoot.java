// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Pulley;

public class PrepShoot extends CommandBase {

  Pulley pulley;

  /** Creates a new PrepShoot. */
  public PrepShoot(Pulley p) {
    // Use addRequirements() here to declare subsystem dependencies.
    pulley = p;
    addRequirements(pulley);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    pulley.setBottomPosition();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pulley.spin();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    pulley.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return pulley.aboveShootHeight();
  }
}
