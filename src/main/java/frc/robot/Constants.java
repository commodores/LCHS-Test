// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants {
        public static final int kFrontLeft = 1;
        public static final int kRearLeft = 2;

        public static final int kFrontRight = 3;
        public static final int kRearRight = 4;
    }

    public static final class ShooterConstants {
        public static final int kRightShooterPort = 5;
        public static final int kLeftShooterPort = 6;

        public static final double kShooterVoltageRampRate = 0.2;

        public static final double kShooterP = 0.09;
        public static final double kShooterI = 0.0;
        public static final double kShooterD = 0.0;
        public static final double kShooterF = 0.0665;

        public static final int kAllowableError = 50;
        public static final int kPIDLoopRate = 10; //In ms
        public static final int kMaxIntegralAccumulator = 1000;

        public static final double klimeLightHeight = 18.5;//inches
        public static final double ktargetHeight = 89.75;//inches
        public static final double kCameraAngle = 25;
    }

    public static final class OIConstants{
        public static final int kJoystickPort = 0;
        public static final int kXboxPort = 1;
    }
    
    public static final class HopperConstants{
        public static final int kHopperPort = 7;
        public static final int kFeederPort = 8;
    }

    public static final class IntakeConstants{
        public static final int kIntakePort = 9;
    }

}
