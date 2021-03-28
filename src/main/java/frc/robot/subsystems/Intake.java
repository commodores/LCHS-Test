// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  private final CANSparkMax intakeMotor;
  
  public Intake() {

    intakeMotor = new CANSparkMax(IntakeConstants.kIntakePort, MotorType.kBrushless);

    intakeMotor.restoreFactoryDefaults();
    
    intakeMotor.setIdleMode(IdleMode.kCoast);

  }

  public void runIntake(double speed){
    intakeMotor.set(speed);
  }

  public void stopIntake(){
    intakeMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
