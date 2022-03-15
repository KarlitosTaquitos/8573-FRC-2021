// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveAmount extends CommandBase {

  DriveTrain driveTrain;
  double rotations;
  double speed;
  double curve;

  /** Creates a new DriveAmount. */
  public DriveAmount(DriveTrain dt, double s, double c, double r) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    speed = s;
    curve = c;
    rotations = r;

    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.resetEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrain.setLeft((speed - curve) * - 1);
    driveTrain.setRight(speed - curve);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
    driveTrain.resetEncoder();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return driveTrain.lPastAmount(rotations) || driveTrain.rPastAmount(rotations);
  }
}
