package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.FlyWheelOutput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class FlyWheel extends Subsystem {
  OI m_oi = new OI();

  public double flyWheelSpeed;
  
//check if flyWheel needs to be capital
public final WPI_TalonSRX flyWheel = RobotMap.flyWheel;

  @Override
  public void initDefaultCommand() {
  }

  public void Output (double speed){
    flyWheel.set(-speed);
    flyWheelSpeed = -speed;
  }

  public void Stop(){
    flyWheel.set(0);
    flyWheelSpeed = 0;
  }

  public boolean getFlywheelStatus () {
     if (flyWheelSpeed != 0)
     { 
        return true;
     } 
     else
     {
        return false;
     }
  }

  public void moveWithB(){
    boolean xboxB = m_oi.getXbox().getBButton();
    if (xboxB){  
    Output(0.5);

    } else {
    Output(0);
    }
  }
  
  

  

  

}