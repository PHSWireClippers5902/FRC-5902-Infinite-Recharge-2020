/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.AllPistonsOff;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.BackPistonToggle;
import frc.robot.commands.Climb;
import frc.robot.commands.FlyWheel;
import frc.robot.commands.FrontPistonToggle;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {
  /**
   * Enables control through either an Xbox Controller or a Joystick
   */
  public static OI s_oi = new OI();

  // Xbox
  public static XboxController xbox;
  private JoystickButton xboxRightBumber;
  private JoystickButton xboxLeftBumber;
  private JoystickButton xboxAButton;
  private JoystickButton xboxBButton;
  private JoystickButton xboxXButton;
  private JoystickButton xboxYButton;
  private JoystickButton xboxRightStickButton;
  /*
   * private JoystickButton xboxDPadDown; private JoystickButton xboxDPadUp;
   * private JoystickButton xboxDPadLeft; private JoystickButton xboxDPadRight;
   */

  // left joystick buttons
  public Joystick logitechLeft;
  private JoystickButton joystickButtonL1;
  private JoystickButton joystickButtonL2;
  // right joystick buttons
  public Joystick logitechRight;
  private JoystickButton joystickButtonR1;
  private JoystickButton joystickButtonR3;
  // arcade buttons
  public Joystick AC;
  public JoystickButton joystickButtonAC1;
  public JoystickButton joystickButtonAC2;
  public JoystickButton joystickButtonAC3;
  public JoystickButton joystickButtonAC4;
  public JoystickButton joystickButtonAC5;
  public JoystickButton joystickButtonAC6;
  public JoystickButton joystickButtonAC7;
  public JoystickButton joystickButtonAC8;
  public JoystickButton joystickButtonAC9;

  public OI() {
    System.out.println(xbox.toString());

    //Xbox assign Values
    xbox = new XboxController(0);
    xboxRightBumber = new JoystickButton(xbox, 6);
    xboxLeftBumber = new JoystickButton(xbox, 5);
    xboxAButton = new JoystickButton(xbox, 1);
    xboxBButton = new JoystickButton(xbox, 2);
    xboxXButton = new JoystickButton(xbox, 3);
    xboxYButton = new JoystickButton(xbox, 4);
    xboxRightStickButton = new JoystickButton(xbox, 10);

    /*xboxDPadDown = new JoystickButton(xbox, 1);
    xboxDPadUp = new JoystickButton(xbox, 1);
    xboxDPadRight = new JoystickButton(xbox, 1);
    xboxDPadLeft = new JoystickButton(xbox, 1);*/

    // Make those Joysticks!
    logitechLeft = new Joystick(0);
    logitechRight = new Joystick(2);
    AC = new Joystick(1);

    // Arcade Controller buttons
    joystickButtonAC1 = new JoystickButton(AC, 1);
    joystickButtonAC2 = new JoystickButton(AC, 2);
    joystickButtonAC3 = new JoystickButton(AC, 3);
    joystickButtonAC4 = new JoystickButton(AC, 4);
    joystickButtonAC5 = new JoystickButton(AC, 5);
    joystickButtonAC6 = new JoystickButton(AC, 6);
    joystickButtonAC7 = new JoystickButton(AC, 7);
    joystickButtonAC8 = new JoystickButton(AC, 8);
    joystickButtonAC9 = new JoystickButton(AC, 9);

    // left joystick buttons
    joystickButtonL1 = new JoystickButton(logitechLeft, 1);
    joystickButtonL2 = new JoystickButton(logitechLeft, 2);

    joystickButtonR1 = new JoystickButton(logitechRight, 1);
    joystickButtonR3 = new JoystickButton(logitechRight, 3);

    //Pistons
    xboxRightBumber.toggleWhenPressed(new FrontPistonToggle());
    xboxRightBumber.toggleWhenPressed(new BackPistonToggle());
    xboxBButton.whenPressed(new AllPistonsOff());

    //Climb
    xboxAButton.whenPressed(new Climb(.25));
    xboxYButton.whenPressed(new Climb(-.25));

  }

  public double[] getStickValues(Hand hand) {
    double x = xbox.getX(hand);
    double y = xbox.getY(hand);

    double[] returnArray = { x, y };
    return returnArray;
  }

  public XboxController getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return AC;
  }
}
