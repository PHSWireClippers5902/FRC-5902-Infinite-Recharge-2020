/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class ArcadeDrive extends Command {
  /**
   * Creates a new arcadeDrive.
   */
  public ArcadeDrive() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      double driveSpeed = 0.5;
      double sensitivityMultiplier = 1;
      //
      double driveSensitivity = 0.85;
      double turnSensitivity = 0.55;

      double[] stickValues = Robot.oi.getStickValues(Hand.kLeft);
      double fwd = stickValues[1] * driveSensitivity * driveSpeed * sensitivityMultiplier;
      double turn = stickValues[0] * turnSensitivity * driveSpeed * sensitivityMultiplier;

      Robot.driveTrain.arcadeDrive(fwd, turn, 1);
  }

  // Called once the command ends or is interrupted.
  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
