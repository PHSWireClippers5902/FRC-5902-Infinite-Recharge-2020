package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

//This code toggles on and off the two front pistons with a toggleWhenPressed button in OI
public class TopPistonToggle extends Command {
  public TopPistonToggle() {
    requires(Robot.pneumaticSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.pneumaticSystem.onTopPistons();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {  
   if (Robot.disabled) {
      if (Robot.retractOnDisabled) {
        Robot.pneumaticSystem.offTopPistons(); 
        //System.out.println("TopPiston disable" + Robot.disabled);
        //System.out.println("TopPiston retract" + Robot.retractOnDisabled);
      }
    } else {
      Robot.pneumaticSystem.offTopPistons(); 
      //System.out.println("TopPiston2 disable" + Robot.disabled);
        //System.out.println("TopPiston2 retract" + Robot.retractOnDisabled);
    }
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
    
  }
}
