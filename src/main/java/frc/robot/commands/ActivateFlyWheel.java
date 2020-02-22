package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ActivateFlyWheel extends Command {

  public double speed;

  public ActivateFlyWheel(double speed) {
    // Use requires() here to declare subsystem dependencies
    this.speed = speed;
    requires(Robot.flyWheelSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (RobotMap.compressor.enabled() == true) {
      RobotMap.compressor.stop();
      Robot.flyWheelSystem.eject(this.speed);
    } else {
      Robot.flyWheelSystem.eject(this.speed);
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.flyWheelSystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.flyWheelSystem.stop();
  }
}