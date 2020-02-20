package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.FlyWheelOutput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class FlyWheel extends Subsystem {
  OI m_oi = new OI();
  
//check if flyWheel needs to be capital
public final WPI_TalonSRX flyWheel = RobotMap.flyWheel;

  @Override
  public void initDefaultCommand() {
  }

  public void Output (double speed){
    flyWheel.set(speed);
  }

  public void Stop(){
    flyWheel.set(0);
  }

  public void moveWithRightJoy(){
    double xboxRightJoy = m_oi.getXbox().getY(Hand.kRight);
    Output(xboxRightJoy);
  }
  
  

  

  

}