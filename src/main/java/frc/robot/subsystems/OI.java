/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI extends SubsystemBase {
  /**
   * Enables control through either an Xbox Controller or a Joystick
   */
  public static XboxController xbox = new XboxController(0);
  public static Joystick joystick;
  
  public OI() {
    System.out.println(xbox.toString());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double[] getStickValues(Hand hand){
    double x = xbox.getX(hand);
    double y = xbox.getY(hand);

    double[] returnArray = {x, y};
    return returnArray;
  }

  public XboxController getXbox(){
    return xbox;
  }
}
