/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;



/**
 * Manages the movement of Lead and Following motor controllers
 */
public class ServoSystem extends Subsystem {

  OI m_oi = new OI();

  

  
  @Override
  protected void initDefaultCommand() {
    // setDefaultCommand(new ArcadeDrive());
    

  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
  }

}
