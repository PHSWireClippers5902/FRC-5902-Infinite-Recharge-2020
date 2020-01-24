/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;

//import javax.naming.directory.SearchControls;
import frc.robot.commands.ServoControl;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI extends SubsystemBase {
  /**
   * Enables control through either an Xbox Controller or a Joystick
   */
  public static XboxController xbox = new XboxController(0);
  public static Joystick joystick;
  public JoystickButton xboxAButton;
  public JoystickButton xboxBButton;
  public JoystickButton xboxXButton;
  public JoystickButton xboxYButton;
  
  public OI() {
   
    xboxAButton = new JoystickButton(xbox, 1);
    xboxBButton = new JoystickButton(xbox, 2);
    xboxXButton = new JoystickButton(xbox, 3);
    xboxYButton = new JoystickButton(xbox, 4);

    System.out.println(xbox.toString());
    xboxAButton.whenPressed(new ServoControl(0)); // 0 Angle for arm is down
    xboxBButton.whenPressed(new ServoControl(45)); // 45 is Angle for arm is part up
    xboxYButton.whenPressed(new ServoControl(90)); // 90 is Angle for arm is fully up
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
