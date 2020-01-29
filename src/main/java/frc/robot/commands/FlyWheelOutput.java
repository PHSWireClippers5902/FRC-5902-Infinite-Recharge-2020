package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class FlyWheelOutput extends Command {
  public FlyWheelOutput() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.flyWheel);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean xboxB = Robot.oi.getXbox().getBButton();
    if (xboxB){  
    Robot.flyWheel.Output(0.5);
    } else {
    Robot.flyWheel.Output(0);
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
    Robot.flyWheel.Stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.flyWheel.Stop();
  }
}