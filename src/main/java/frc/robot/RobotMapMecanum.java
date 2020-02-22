/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * Robot controller mapping class for Mecanum wheels
 */
public class RobotMapMecanum {
    public static WPI_TalonSRX frontLeftDrive = new WPI_TalonSRX(1);
    public static WPI_TalonSRX frontRightDrive = new WPI_TalonSRX(2);
    public static WPI_TalonSRX rearLeftDrive = new WPI_TalonSRX(3);
    public static WPI_TalonSRX rearRightDrive = new WPI_TalonSRX(4);

    public static MecanumDrive mecanumDrive = new MecanumDrive(frontLeftDrive, rearLeftDrive, frontRightDrive,
            rearRightDrive);

    public static void init() {
        mecanumDrive.setSafetyEnabled(true);
        mecanumDrive.setExpiration(0.1);
        mecanumDrive.setMaxOutput(1.0);
        mecanumDrive.setDeadband(0.2);
        frontLeftDrive.configOpenloopRamp(1);
        frontRightDrive.configOpenloopRamp(1);
        rearLeftDrive.configOpenloopRamp(1);
        rearRightDrive.configOpenloopRamp(1);
    }
}
