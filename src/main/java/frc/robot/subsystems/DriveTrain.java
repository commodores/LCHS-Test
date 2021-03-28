// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */

  private final WPI_TalonFX frontLeftMotor;
  private final WPI_TalonFX rearLeftMotor;

  private final WPI_TalonFX frontRightMotor;
  private final WPI_TalonFX rearRightMotor;

  private final AHRS navX;

  private final MecanumDrive m_robotDrive;


  public DriveTrain() {

    frontLeftMotor = new WPI_TalonFX(DriveConstants.kFrontLeft);
    rearLeftMotor = new WPI_TalonFX(DriveConstants.kRearLeft);

    frontRightMotor = new WPI_TalonFX(DriveConstants.kFrontRight);
    rearRightMotor = new WPI_TalonFX(DriveConstants.kRearRight);

    navX = new AHRS();

    frontLeftMotor.configFactoryDefault();
    rearLeftMotor.configFactoryDefault();
    frontRightMotor.configFactoryDefault();
    rearRightMotor.configFactoryDefault();

    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);

    frontLeftMotor.setInverted(true);
    rearLeftMotor.setInverted(true);

    m_robotDrive = new MecanumDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
  public void fieldOriented(double stickY, double stickX, double stickRotate){
    m_robotDrive.driveCartesian(stickY, stickX, stickRotate, navX.getAngle());
  }

  public void zeroYaw() {
    navX.zeroYaw();
  }

}
