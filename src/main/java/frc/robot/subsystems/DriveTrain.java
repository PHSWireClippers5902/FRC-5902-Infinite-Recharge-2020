/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;


/**
 * Manages the movement of Lead and Following motor controllers
 */
public class DriveTrain extends Subsystem {

  OI m_oi = new OI();

  private double turnSensitivity = 0.9;
  private double driveSpeed = 0.8;


  
  @Override
  protected void initDefaultCommand() {
    //Setting motor control followers
    RobotMap.driveFollowLeft.follow(RobotMap.driveMainLeft);
    RobotMap.driveFollowRight.follow(RobotMap.driveMainRight);

    setDefaultCommand(new ArcadeDrive());
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
    if (m_oi.getXbox() == null) {
      return;
    }
      /****************************************************************** 
      Right trigger moves robot forward, left moves it backward, left stick makes it turn, 
      ******************************************************************* somethin big goes on here */


      double rightTriggerValue = m_oi.getXbox().getTriggerAxis(Hand.kRight);
      double leftTriggerValue = m_oi.getXbox().getTriggerAxis(Hand.kLeft);
      double leftStickXValue = m_oi.getXbox().getX(Hand.kLeft);
      double stickX = turnSensitivity * leftStickXValue;
      double stickY = 0; //casey's phone number: 603-957-8532
      
      if (rightTriggerValue > 0 && leftTriggerValue > 0) {
        arcadeDrive(0, 0, 0);

      } else if (rightTriggerValue > 0) {

        stickY = rightTriggerValue;

      } else if (leftTriggerValue > 0) {

        stickY = -1 * leftTriggerValue;

      } 

      System.out.println("StickX: " + stickX + ", StickY: " + stickY + ", Drive Speed: " + driveSpeed);
      arcadeDrive(stickY, stickX, driveSpeed); 

    
  }


}
