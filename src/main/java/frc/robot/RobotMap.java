package frc.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Servo;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.SolenoidWrapper;


public class RobotMap {
    
    public static WPI_TalonSRX driveMainLeft = new WPI_TalonSRX(1);
    public static WPI_VictorSPX driveFollowLeft = new WPI_VictorSPX(3);
    public static WPI_TalonSRX driveMainRight = new WPI_TalonSRX(2);
    public static WPI_VictorSPX driveFollowRight = new WPI_VictorSPX(4);
    public static WPI_TalonSRX flyWheel = new WPI_TalonSRX(5);
    public static WPI_TalonSRX climb = new WPI_TalonSRX(6);

    public static Spark lightsR = new Spark(0);
    public static Spark lightsL = new Spark(3);

    public static Compressor compressor = new Compressor(0);

    public static Solenoid frontSolenoid = new SolenoidWrapper(1);
    public static Solenoid backSolenoid = new SolenoidWrapper(0);

    public static Servo coolServo = new Servo(1);

    public static DifferentialDrive diffDrive = new DifferentialDrive(driveMainLeft, driveMainRight);

    public static void init() {
        diffDrive.setSafetyEnabled(true);
        diffDrive.setExpiration(0.1);
        diffDrive.setMaxOutput(1.0);
        diffDrive.setDeadband(0.2);
        driveMainLeft.configOpenloopRamp(1);
        driveMainRight.configOpenloopRamp(1);
        driveFollowLeft.configOpenloopRamp(1);
        driveFollowRight.configOpenloopRamp(1);
        flyWheel.configOpenloopRamp(1);
        flyWheel.setSafetyEnabled(true);
        climb.configOpenloopRamp(1);
        climb.setSafetyEnabled(true);
        frontSolenoid.set(false);
        backSolenoid.set(false);
        }
    }