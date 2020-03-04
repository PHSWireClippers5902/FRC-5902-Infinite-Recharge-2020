package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ActivateFlyWheel;
import frc.robot.Robot;
import frc.robot.OI;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class FlyWheelSystem extends Subsystem {

   public double flyWheelSpeed;

   // check if flyWheel needs to capital
   public final WPI_TalonSRX flyWheel = RobotMap.flyWheel;

   @Override
   public void initDefaultCommand() {
   }

   public void eject(double speed) {
      flyWheel.set(speed);
      flyWheelSpeed = speed;
   }

   public void intake(double speed) {
      flyWheel.set(speed);
      flyWheelSpeed = speed;
   }

   public void stop() {
      flyWheel.set(0);
      flyWheelSpeed = 0;
   }

   public boolean getFlywheelStatus() {
      if (flyWheelSpeed != 0) {
         return true;
      } else {
         return false;
      }
   }

   public void flyWheelController() {

      double stickYPOS;
      stickYPOS = Robot.oi.logitech.getY(Hand.kLeft);
      if(stickYPOS >= 0.07 || stickYPOS <= -0.07 ){
         RobotMap.compressor.stop();
         flyWheel.set(-stickYPOS);
   }else if(!RobotMap.compressor.enabled()){
         RobotMap.compressor.start();
         flyWheel.set(0);
      }else{
         flyWheel.set(0);
      }

   }
}