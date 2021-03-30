// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.DriveManual;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
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

  public static final DriveTrain m_drivetrain = new DriveTrain();
  public static final Intake m_intake = new Intake();
  public static final Shooter m_shooter = new Shooter();
  public static final Hopper m_hopper = new Hopper();

  public final static Joystick joystick = new Joystick(OIConstants.kJoystickPort);
  public final static XboxController xbox = new XboxController(OIConstants.kXboxPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    this.initializeStartup();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    new JoystickButton(joystick, 1)
      .whenPressed(() -> m_drivetrain.zeroYaw());

    new JoystickButton(xbox, Button.kA.value)
      .whileHeld(() -> m_intake.runIntake(.5))
      .whenReleased(() -> m_intake.stopIntake());

    new JoystickButton(xbox, Button.kB.value)
      .whileHeld(() -> m_intake.runIntake(-.5))
      .whenReleased(() -> m_intake.stopIntake());
    
    new JoystickButton(xbox, Button.kX.value)
      .whenPressed(() -> m_hopper.runFeeder(.8))
      .whenReleased(() -> m_hopper.stopFeeder());

    new JoystickButton(xbox, Button.kY.value)
      .whenPressed(() -> m_hopper.runFeeder(-.45))
      .whenReleased(() -> m_hopper.stopFeeder());

    new JoystickButton(xbox, Button.kBack.value)
      .whenPressed(() -> m_hopper.runHopper(.5))
      .whenReleased(() -> m_hopper.stopHopper());

    new JoystickButton(xbox, Button.kStart.value)
      .whenPressed(() -> m_hopper.runHopper(-.5))
      .whenReleased(() -> m_hopper.stopHopper());

    new JoystickButton(xbox, Button.kBumperLeft.value)
      .whileHeld(() -> m_shooter.setRPM(2000))
      .whenReleased(() -> m_shooter.setRPM(-1));

    new JoystickButton(xbox, Button.kBumperRight.value)
      .whileHeld(() -> m_shooter.setRPM(3000))
      .whenReleased(() -> m_shooter.setRPM(-1));

  }

  private void initializeStartup()
  {
    m_drivetrain.setDefaultCommand(
      new DriveManual(m_drivetrain));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
