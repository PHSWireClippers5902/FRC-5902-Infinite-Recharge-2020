package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class FlyWheelSystem extends Subsystem {

public double flyWheelSpeed;
  
//check if flyWheel needs to be capital
public final WPI_TalonSRX flyWheel = RobotMap.flyWheel;

  @Override
  public void initDefaultCommand() {
  }

  public void eject (double speed){
   flyWheel.set(-speed);
   flyWheelSpeed = -speed;
  }

  public void intake (double speed){
    flyWheel.set(speed);
    flyWheelSpeed = speed;
   }

  public void stop(){
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
}