package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ActivateClimb;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ClimbSystem extends Subsystem {

  public final SpeedControllerGroup climbMotors = RobotMap.climbMotors;

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new ActivateClimb(0));
  }

  public void up(double speed) {
    climbMotors.set(speed);
  }

  public void down(double speed) {
    climbMotors.set(-speed);
  }

  public void stop() {
    climbMotors.set(0);
  }

}