package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * A Subsystem which allows for easier control of the robot's Solenoids
 */
public class PneumaticSystem extends Subsystem {

  /* 
  * Extends front pistons
  */
  public void onFrontPistons() {
    RobotMap.frontSolenoid.set(true);
  }

  /* 
  * Extends back pistons
  */
  public void onBackPistons() {
    RobotMap.backSolenoid.set(true);
  }

  /* 
  * Allows all pistons to retract
  */
  public void offAllPistons() {
    RobotMap.frontSolenoid.set(false);
    RobotMap.backSolenoid.set(false);
  }

  /* 
  * Allows front pistons to retract
  */
  public void offFrontPistons() {
    RobotMap.frontSolenoid.set(false);
  }

  /* 
  * Allows back pistons to retract
  */
  public void offBackPistons() {
    RobotMap.backSolenoid.set(false);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new AllPistonsOff());
  }
}