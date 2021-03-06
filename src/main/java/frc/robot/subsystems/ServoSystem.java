/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Robot;
/**
 * Manages the movement of Lead and Following motor controllers
 */
public class ServoSystem extends Subsystem {

  @Override
  protected void initDefaultCommand() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
  }

  // SERVO THING - just for checking servos - when b button is pressed, sets
  // angle to an int degrees and if x button is pressed sets the angle to -degrees
  public void stangle(int degrees) {
    /*
     * if (Robot.oi.getXbox().getBButtonPressed()) {
     * RobotMap.coolServo.setAngle(degrees); } else if
     * (Robot.oi.getXbox().getXButtonPressed()) { RobotMap.coolServo.setAngle(-1 *
     * degrees); }
     */}

}
