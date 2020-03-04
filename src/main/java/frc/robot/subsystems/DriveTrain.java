/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * Manages the movement of Lead and Following motor controllers
 */
public class DriveTrain extends Subsystem {
  
  private double turnSensitivity = 0.65;
  private double driveSpeed = .9;

  @Override
  protected void initDefaultCommand() {
    // Setting motor control followers
    RobotMap.driveFollowLeft.follow(RobotMap.driveMainLeft);
    RobotMap.driveFollowRight.follow(RobotMap.driveMainRight);
    //setDefaultCommand(new ArcadeDrive());
  }

  public void arcadeDrive(double stickY_Axis, double stickX_Axis, double speed) {
    RobotMap.diffDrive.arcadeDrive(stickY_Axis * speed, stickX_Axis * speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    RobotMap.diffDrive.tankDrive(0, 0);
  }

  public void driveWithXbox() {
    if (Robot.oi.getXbox() == null) {
      return;
    }
    /******************************************************************
     * Right trigger moves robot forward, left moves it backward, left stick makes
     * it turn, somethin big goes on here
     */

    double rightTriggerValue = Robot.oi.getXbox().getTriggerAxis(Hand.kRight);
    double leftTriggerValue = Robot.oi.getXbox().getTriggerAxis(Hand.kLeft);
    double leftStickXValue = Robot.oi.getXbox().getX(Hand.kLeft);
    double leftStickYValue = Robot.oi.getXbox().getY(Hand.kLeft);

    double stickX = turnSensitivity * leftStickXValue;
    double stickY = 0;
   // System.out.println("Left Trigger:" + leftTriggerValue);
    // System.out.println("Right Trigger:" + rightTriggerValue);
     
    if (rightTriggerValue > 0 && leftTriggerValue > 0) {
      arcadeDrive(0, 0, 0);

    } else if (rightTriggerValue > 0) {

      stickY = -1 * rightTriggerValue;

    } else if (leftTriggerValue > 0) {

      stickY = leftTriggerValue;

    }

    //System.out.println("StickX: " + stickX + ", StickY: " + stickY);
    arcadeDrive(stickY, stickX, driveSpeed); 

  }

}