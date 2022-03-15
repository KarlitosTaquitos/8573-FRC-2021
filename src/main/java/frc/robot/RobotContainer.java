// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.hal.AllianceStationID;
import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AllianceLed;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Auto;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.BlueWheelsOn;
import frc.robot.commands.BlueWheelsRev;
import frc.robot.commands.Climb;
import frc.robot.commands.ElevatorControls;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FrontIntakeOn;
import frc.robot.commands.FrontIntakeRev;
import frc.robot.commands.Eat;
import frc.robot.commands.Vomit;
import frc.robot.commands.PrepShoot;
import frc.robot.commands.PulleyRavel;
import frc.robot.commands.PulleyUnravel;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShooterReverse;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.Pulley;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  //check alliance color
  AllianceStationID station = HAL.getAllianceStation();
  boolean redAlliance = (
    station == AllianceStationID.Red1 ||
    station == AllianceStationID.Red2 ||
    station == AllianceStationID.Red3);

  // buttons
  Joystick player_1 = new Joystick(Constants.Controls.P1);
  Joystick player_2 = new Joystick(Constants.Controls.P2);

  JoystickButton launch = new JoystickButton(player_2, Constants.Controls.A);
  JoystickButton unShoot = new JoystickButton(player_2, Constants.Controls.B);
  JoystickButton spinUp = new JoystickButton(player_2, Constants.Controls.XCONTROL);
  JoystickButton spinDown = new JoystickButton(player_2, Constants.Controls.YCONTROL);
  JoystickButton prep = new JoystickButton(player_2, Constants.Controls.L_STICK);

  JoystickButton in_In = new JoystickButton(player_1, Constants.Controls.TRIGGER_1);

  JoystickButton frontIntake = new JoystickButton(player_1, Constants.Controls.P1_3);
  JoystickButton blueWheels = new JoystickButton(player_1, Constants.Controls.P1_5);

  JoystickButton frontIntakeRev = new JoystickButton(player_1, Constants.Controls.P1_4);
  JoystickButton blueWheelsRev = new JoystickButton(player_1, Constants.Controls.P1_6);

  // subsystems
  DriveTrain driveTrain = new DriveTrain();
  Climber climber = new Climber();
  Elevator elevator = new Elevator();
  Intake intake = new Intake();
  Shooter shooter = new Shooter();
  Pulley pulley = new Pulley();
  LED leds = new LED(redAlliance);

  //commands
  ArcadeDrive arcadeDrive = new ArcadeDrive(driveTrain, player_1);
  Climb climb = new Climb(climber, player_2);

  ElevatorControls elControl = new ElevatorControls(elevator, player_2);

  AllianceLed allLeds = new AllianceLed(leds);

  Eat eat = new Eat(intake);
  Vomit vomit = new Vomit(intake);
  FrontIntakeOn frontOn = new FrontIntakeOn(intake);
  FrontIntakeRev frontRev = new FrontIntakeRev(intake);
  BlueWheelsOn blueOn = new BlueWheelsOn(intake);
  BlueWheelsRev blueRev = new BlueWheelsRev(intake);

  Shoot shoot = new Shoot(shooter, leds);
  ShooterReverse shootReverse = new ShooterReverse(shooter);

  PulleyRavel pullUp = new PulleyRavel(pulley);
  PulleyUnravel pullDown = new PulleyUnravel(pulley);
  PrepShoot prepShoot = new PrepShoot(pulley);

  //AutoShoot autoShoot = new AutoShoot(shooter, leds, intake);
  Auto auto = new Auto(shooter, leds, intake, pulley, driveTrain);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    climber.setDefaultCommand(climb);
    driveTrain.setDefaultCommand(arcadeDrive);
    elevator.setDefaultCommand(elControl);
    leds.setDefaultCommand(allLeds);

    in_In.whileHeld(eat);

    frontIntake.and(blueWheels).whileActiveContinuous(eat);
    frontIntake.whileHeld(frontOn);
    blueWheels.whileHeld(blueOn);

    frontIntakeRev.whileHeld(frontRev);
    blueWheelsRev.whileHeld(blueRev);
    frontIntakeRev.and(blueWheels).whileActiveContinuous(vomit);

    launch.whileHeld(shoot);
    unShoot.whileHeld(shootReverse);

    spinUp.whileHeld(pullUp);
    spinDown.whileHeld(pullDown);
    prep.whenPressed(prepShoot);
  }

    

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return auto;
  }
}
