package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

//This code turns front and back pistons off 

public class AllPistonsOff extends Command {

  public AllPistonsOff() {
    requires(Robot.pneumaticSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("All OFF Pistons Init");


  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.pneumaticSystem.offAllPistons();
    System.out.println("All OFF Pistons Execute");

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
