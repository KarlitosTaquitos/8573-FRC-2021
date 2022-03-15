// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

public class Climb extends CommandBase {
  
  private Climber climber;
  private Joystick driver;

  /** Creates a new Climb. */
  public Climb(Climber c, Joystick j) {
    // Use addRequirements() here to declare subsystem dependencies.
    driver = j;
    climber = c;
    addRequirements(climber);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //climber.climb();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int pov = driver.getPOV(Constants.Controls.POV);

    if (pov == 0) // up on dpad
      climber.climb();
    else if (pov == 180) // down on dpad
      climber.down();
    else
      climber.stop();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //climber.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
