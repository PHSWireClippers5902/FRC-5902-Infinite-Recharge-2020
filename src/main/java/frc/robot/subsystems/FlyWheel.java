package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class FlyWheel extends Subsystem {
  
//check if flyWheel needs to be capital
public final WPI_VictorSPX flyWheel = RobotMap.flyWheel;

  @Override
  public void initDefaultCommand() {
  }

  public void Output (double speed){
    flyWheel.set(-speed);
  }

  public void Stop(){
    flyWheel.set(0);
  }

  
  

  

  

}