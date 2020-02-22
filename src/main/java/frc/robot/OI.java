/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.allPistonsOff;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.backPistonToggle;
import frc.robot.commands.Climb;
import frc.robot.commands.FlyWheel;
import frc.robot.commands.frontPistonToggle;

import edu.wpi.first.wpilibj.GenericHID.Hand;

public class OI {
  /**
   * Enables control through either an Xbox Controller or a Joystick
   */
  public static XboxController xbox = new XboxController(0);
  public static Joystick logitech = new Joystick(1);
  public static OI s_oi = new OI();

  public OI() {
    System.out.println(xbox.toString());
  }

  public double[] getStickValues(Hand hand) {
    double x = xbox.getX(hand);
    double y = xbox.getY(hand);

    double[] returnArray = { x, y };
    return returnArray;
  }

  public void buttoncheck() {
    if (s_oi.getXbox().getAButton()) {
      Robot.pneumaticSystem.onFrontPistons();
    } else if (s_oi.getXbox().getBButton()) {
      Robot.pneumaticSystem.onBackPistons();
    } else if (s_oi.getXbox().getBumper(Hand.kRight)) {
      Robot.pneumaticSystem.offAllPistons();
    }

  }

  public XboxController getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
  }
}
