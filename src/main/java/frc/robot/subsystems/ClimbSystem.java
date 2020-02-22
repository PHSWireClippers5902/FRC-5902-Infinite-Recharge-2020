package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Climb;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ClimbSystem extends Subsystem {

  // check if flyWheel needs to be capital
  public final WPI_TalonSRX climb = RobotMap.climb;

  @Override
  public void initDefaultCommand() {
  }

  public void up(double speed) {
    climb.set(speed);
  }

  public void down(double speed) {
    climb.set(-speed);
  }

  public void stop() {
    climb.set(0);
  }
}