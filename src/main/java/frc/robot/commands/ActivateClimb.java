package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;

public class ActivateClimb extends Command {

  public double speed;

  public ActivateClimb(double speed) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.climbSystem);
    this.speed = speed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.climbSystem.up(speed);
    RobotMap.topSolenoid.set(false);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.climbSystem.stop();
    System.out.println("Activate Climb End Called");
    
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.climbSystem.stop();
  }
}