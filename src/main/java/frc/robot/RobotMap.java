package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;


public class RobotMap {
    public static WPI_TalonSRX driveMainLeft = new WPI_TalonSRX(1);
    public static WPI_VictorSPX driveFollowLeft = new WPI_VictorSPX(3);
    public static WPI_TalonSRX driveMainRight = new WPI_TalonSRX(2);
    public static WPI_VictorSPX driveFollowRight = new WPI_VictorSPX(4);
    public static SpeedController lightsR;
    public static SpeedController lightsL;
  
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

        //Lights
        lightsR = new Spark(0);
        lightsL = new Spark(3);

    }
}