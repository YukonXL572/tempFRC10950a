// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  // == CAN ID List ==
  
  // Swerve Pods - SPARK MAXs
  private static final int FrontLeftDrivingCanId  = 11;
  private static final int RearLeftDrivingCanId   = 13;
  private static final int FrontRightDrivingCanId = 15;
  private static final int RearRightDrivingCanId  = 17;

  private static final int FrontLeftTurningCanId  = 10;
  private static final int RearLeftTurningCanId   = 12;
  private static final int FrontRightTurningCanId = 14;
  private static final int RearRightTurningCanId  = 16;

  // Shooter & Hood
  private static final int HoodTranslateCanId   = 18; // Neo
  private static final int ShooterIntakeCanId   = 20; // Neo
  private static final int ShooterFlywheelCanId = 21; // Falcon

  // Intake System
  private static final int LeftDeployerCanId  = 23; // Neo
  private static final int RightDeployerCanId = 24; // Neo
  private static final int IntakeSpinnerCanId = 19; // Falcon


  public static final class DriveConstants {
    // Driving Parameters - Note that these are not the maximum capable speeds of
    // the robot, rather the allowed maximum speeds
    public static final double kMaxSpeedMetersPerSecond = 5.8;
    public static final double kMaxAngularSpeed = 2.2 * Math.PI; // radians per second

    // Chassis configuration
    public static final double kTrackWidth = Units.inchesToMeters(20.5);
    // Distance between centers of right and left wheels on robot
    public static final double kWheelBase = Units.inchesToMeters(26.5);
    // Distance between front and back wheels on robot
    public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
        new Translation2d(kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
        new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

    // Angular offsets of the modules relative to the chassis in radians
    public static final double kFrontLeftChassisAngularOffset = -Math.PI / 2;
    public static final double kFrontRightChassisAngularOffset = 0;
    public static final double kBackLeftChassisAngularOffset = Math.PI;
    public static final double kBackRightChassisAngularOffset = Math.PI / 2;

    // SPARK MAX CAN IDs
    public static final int kFrontLeftDrivingCanId = FrontLeftDrivingCanId;
    public static final int kRearLeftDrivingCanId = RearLeftDrivingCanId;
    public static final int kFrontRightDrivingCanId = FrontRightDrivingCanId;
    public static final int kRearRightDrivingCanId = RearRightDrivingCanId;

    public static final int kFrontLeftTurningCanId = FrontLeftTurningCanId;
    public static final int kRearLeftTurningCanId = RearLeftTurningCanId;
    public static final int kFrontRightTurningCanId = FrontRightTurningCanId;
    public static final int kRearRightTurningCanId = RearRightTurningCanId;

    public static final boolean kGyroReversed = false;
  }

  public static final class ModuleConstants {
    // The MAXSwerve module can be configured with one of three pinion gears: 12T,
    // 13T, or 14T. This changes the drive speed of the module (a pinion gear with
    // more teeth will result in a robot that drives faster).
    public static final int kDrivingMotorPinionTeeth = 14;

    // Calculations required for driving motor conversion factors and feed forward
    public static final double kDrivingMotorFreeSpeedRps = NeoMotorConstants.kFreeSpeedRpm / 60;
    public static final double kWheelDiameterMeters = 0.0762;
    public static final double kWheelCircumferenceMeters = kWheelDiameterMeters * Math.PI;
    // 45 teeth on the wheel's bevel gear, 22 teeth on the first-stage spur gear, 15
    // teeth on the bevel pinion
    public static final double kDrivingMotorReduction = (45.0 * 22) / (kDrivingMotorPinionTeeth * 15);
    public static final double kDriveWheelFreeSpeedRps = (kDrivingMotorFreeSpeedRps * kWheelCircumferenceMeters)
        / kDrivingMotorReduction;
  }

  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;
    public static final double kDriveDeadband = 0.05;
  }

  public static final class AutoConstants {
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kMaxAngularSpeedRadiansPerSecond = Math.PI;
    public static final double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;

    public static final double kPXController = 1;
    public static final double kPYController = 1;
    public static final double kPThetaController = 1;

    // Constraint for the motion profiled robot angle controller
    public static final TrapezoidProfile.Constraints kThetaControllerConstraints = new TrapezoidProfile.Constraints(
        kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
  }

  public static final class NeoMotorConstants {
    public static final double kFreeSpeedRpm = 5676;
  }

  public static final class Falcon500MotorContants {
    public static final int kFreeSpinRpm = 6380;
  }

  public static final class ShooterConstants {
    // Constraints for range of motion of the shooter hood
    // The degrees per degree is the gear ratio between the drive shaft of the motor and the hood control shaft
    public static final int kRangeOfMotionDegrees = 30;
    public static final double kDegreesMotorPerDegreesHood = 1; // 1:1

    // Spark MAX Can IDs - NEOs
    public static final int kHoodTranslateCanId = HoodTranslateCanId;
    public static final int kShooterIntakeCanId = ShooterIntakeCanId;
    // Talon FX Can ID - Falcon 500
    public static final int kShooterFlywheelCanId = ShooterFlywheelCanId;
  }
  
  public static final class IntakeConstants {
    // Constraints for range of motion of the shooter hood
    public static final int kArmRangeOfMotionDegrees = 120;

    // Spark MAX Can IDs - NEOs
    public static final int kLeftDeployerCanId = LeftDeployerCanId;
    public static final int kRightDeployerCanId = RightDeployerCanId;
    // Talon FX Can ID - Falcon 500
    public static final int kIntakeSpinnerCanId = IntakeSpinnerCanId;
  }
}
