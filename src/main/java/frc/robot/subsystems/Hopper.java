// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HopperConstants;

public class Hopper extends SubsystemBase {
  /** Creates a new Hopper. */

  private final CANSparkMax hopperMotor;
  private final TalonSRX feederMotor;

  public Hopper() {

    hopperMotor = new CANSparkMax(HopperConstants.kHopperPort, MotorType.kBrushless);

    feederMotor = new TalonSRX(HopperConstants.kFeederPort);

    hopperMotor.restoreFactoryDefaults();
    feederMotor.configFactoryDefault();
    
    hopperMotor.setIdleMode(IdleMode.kCoast);
    feederMotor.setNeutralMode(NeutralMode.Coast);

  }

  public void runHopper(double speed){
    hopperMotor.set(speed);
  }

  public void stopHopper(){
    hopperMotor.set(0.0);
  }
 
  //Commands For Feeder
  public void runFeeder(double speed){
    feederMotor.set(ControlMode.PercentOutput, speed);
  }

  public void stopFeeder(){
    feederMotor.set(ControlMode.PercentOutput, 0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
