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
import frc.robot.commands.BackPistonToggle;
import frc.robot.commands.ActivateClimb;
import frc.robot.commands.FrontPistonToggle;
import frc.robot.commands.TopPistonToggle;
import frc.robot.commands.ServoToggle;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {
  /**
   * Enables control through either an Xbox Controller or a Joystick
   */
  public static OI s_oi = new OI();

  // Xbox
  public static XboxController xbox;
  private JoystickButton xboxLeftTrigger;
  private JoystickButton xboxRightTrigger;
  private JoystickButton xboxButtonY;
  private JoystickButton xboxButtonX;
  private JoystickButton xboxButtonA;
  private JoystickButton xboxButtonB;
  /*
   * private JoystickButton xboxDPadDown; private JoystickButton xboxDPadUp;
   * private JoystickButton xboxDPadLeft; private JoystickButton xboxDPadRight;
   */

  // Logitech Buttons
  public Joystick logitech;
  private JoystickButton logitechButtonY;
  private JoystickButton logitechButtonB;
  private JoystickButton logitechButtonA;
  private JoystickButton logitechButtonX;
  private JoystickButton logitechLeftBumper;
  private JoystickButton logitechRightBumper;
  private JoystickButton logitechLeftStickPush;
  private JoystickButton logitechRightStickPush;
  private JoystickButton logitechDPadLeft;
  private JoystickButton logitechDPadRight;

  public OI() {
    // Make those Joysticks!
    xbox = new XboxController(0);
    logitech = new Joystick(1);

    // Xbox assign Values

    xboxButtonA = new JoystickButton(xbox, 1);
    xboxButtonB = new JoystickButton(xbox, 2);
    xboxButtonX = new JoystickButton(xbox, 3);
    xboxButtonY = new JoystickButton(xbox, 4);

    /*
     * xboxDPadDown = new JoystickButton(xbox, 1); xboxDPadUp = new
     * JoystickButton(xbox, 1); xboxDPadRight = new JoystickButton(xbox, 1);
     * xboxDPadLeft = new JoystickButton(xbox, 1);
     */

    // left joystick buttons

    logitechButtonY = new JoystickButton(logitech, 4);
    logitechButtonB = new JoystickButton(logitech, 2);
    logitechButtonA = new JoystickButton(logitech, 1);
    logitechButtonX = new JoystickButton(logitech, 3);
    logitechLeftBumper = new JoystickButton(logitech, 5);
    logitechRightBumper = new JoystickButton(logitech, 6);
    logitechLeftStickPush = new JoystickButton(logitech, 9); 
    logitechRightStickPush = new JoystickButton(logitech, 10);
    // Need to figure out how to assign numbers to dpad. Currently unable to make dpads into a JoystickButton
    /*
     * logitechDPadUp = new JoystickButton(logitech, 1); logitechDPadDown = new
     * JoystickButton(logitech, 1); logitechDPadLeft = new JoystickButton(logitech,
     * 1); logitechDPadRight = new JoystickButton(logitech, 1);
     */
    

    // Pistons
    logitechRightBumper.toggleWhenPressed(new FrontPistonToggle());
    logitechLeftBumper.toggleWhenPressed(new BackPistonToggle());
    logitechButtonX.toggleWhenPressed(new TopPistonToggle());
    logitechRightStickPush.whenPressed(new AllPistonsOff());
    

    // Climb Up
    logitechButtonY.whenPressed(new ActivateClimb(-.95));
    logitechButtonY.whenReleased(new ActivateClimb(0)); // Once stop Pneumatic is fired value has to be set to zero
    logitechButtonB.whenPressed(new ActivateClimb(-.6));
    logitechButtonB.whenReleased(new ActivateClimb(0));

    // Climb Down
    logitechButtonA.whenPressed(new ActivateClimb(0.8));
    logitechButtonA.whenReleased(new ActivateClimb(0)); // Once stop Pneumatic is fired value has to be set to zero

    // Servos
    xboxButtonA.whenPressed(new ServoToggle(180));//down
    xboxButtonY.whenPressed(new ServoToggle(18));//up


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
    return logitech;
  }
}
