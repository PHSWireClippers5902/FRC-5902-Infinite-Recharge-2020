/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// Why was 6 afraid of 9? (scroll to bottom for answer!!!)
//Casey Gladu 
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public static DriveTrain driveTrain;
  public static OI oi;
  //Auto variables
  private double startTime;
  private int location;
  private int exitpoint;
  private int entrypoint;
  private double currentPosition;
  private double startingPosition;
 
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    RobotMap.init();
    driveTrain = new DriveTrain();
    startingPosition = RobotMap.driveMainLeft.getSelectedSensorPosition();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   * 
   * <p>Does barely anything???
   */
  @Override
  public void robotPeriodic() {

  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    startTime = Timer.getFPGATimestamp();
    location = 1; //set start positions: Values 1, 2, 3
    exitpoint = 2; //set how to leave
    entrypoint = 2; //set how to enter
    
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp(); //get current time to compare to the time when the robot was first initiated
    System.out.println(time - startTime);  //output the difference between when the computer enabled and the time when this method is called. 
    if (location == 1){//code from postion 1
      if(exitpoint == 1){
          if (time - startTime < 1){//turn 180
            RobotMap.diffDrive.arcadeDrive(0.0, 0.62, true);
          }else if(time - startTime < 2.8){//foward 9 ish ft
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true);
          }else if(time - startTime < 5){//shoot balls
            //FlyWheel.flyWheel.set(0.5);
          }else if(time - startTime < 7){//back straight out
            RobotMap.diffDrive.arcadeDrive(-0.7, 0, true);
          }
       }else{
          if (time - startTime < 1){//turn 180
            RobotMap.diffDrive.arcadeDrive(0.0, 0.62, true);
          }else if(time - startTime < 2.8){//foward 9 ish ft
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true);
          }else if(time - startTime < 5){//shoot balls
            //FlyWheel.flyWheel.set(0.5);
          }else if(time - startTime < 5.5){//turn left
              RobotMap.diffDrive.arcadeDrive(0, -0.57, true);
          }else if(time - startTime < 6.8){//move foward 6-7 ft
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true);
          }else if(time - startTime < 7.3){//turn left 90
            RobotMap.diffDrive.arcadeDrive(0, -0.67, true);
          }else if(time - startTime < 9.3){//move foward
            RobotMap.diffDrive.arcadeDrive(0.75, 0, true);
          }
       }//end exitpoint
    
      }else if (location == 2){
        if(entrypoint == 1){
          if (time - startTime < 1){//turn 180
            RobotMap.diffDrive.arcadeDrive(0.0, 0.62, true);
          }else if(time - startTime < 2.8){//foward 9 ish ft
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true);
          }else if(time - startTime < 3.3){//turn right
            RobotMap.diffDrive.arcadeDrive(0, 0.7, true);
          }else if(time - startTime >= 5 && time - startTime <= 6.5){//wait then foward
            RobotMap.diffDrive.arcadeDrive(0.65, 0, true); 
          }else if(time - startTime >= 5 && time - startTime <= 7){//turn left
            RobotMap.diffDrive.arcadeDrive(0, -0.65, true); 
          }else if(time - startTime >= 5 && time - startTime <= 9.8){//shoot balls
            //FlyWheel.flyWheel.set(0.5);
          }else if(time - startTime >= 5 && time - startTime <= 10.3){//turn left
            RobotMap.diffDrive.arcadeDrive(0, -0.6, true); 
          }else if(time - startTime >= 5 && time - startTime <= 11.8){//foward
            RobotMap.diffDrive.arcadeDrive(0.65, 0, true); 
          }else if(time - startTime >= 5 && time - startTime <= 12.3){//turn left
            RobotMap.diffDrive.arcadeDrive(0, -0.65, true); 
          }else if(time - startTime >= 5 && time - startTime <= 14.1){//foward
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true); 
          }
        }else if (entrypoint == 2){
          if (time - startTime < 0.5){//turn left
            RobotMap.diffDrive.arcadeDrive(0.0, -0.62, true);
          }else if(time - startTime >= 5 && time - startTime <= 6.5){//wait then foward
            RobotMap.diffDrive.arcadeDrive(0.65, 0, true); 
          }else if(time - startTime >= 5 && time-startTime <= 7){//turn left
            RobotMap.diffDrive.arcadeDrive(0.0, -0.62, true);
          }else if(time - startTime >= 5 && time-startTime <= 8.8){//turn left
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true);
          }else if(time - startTime >= 5 && time - startTime <= 9.8){//shoot balls
            //FlyWheel.flyWheel.set(0.5);
          }else if(time - startTime >= 5 && time - startTime <= 10.3){//turn left
            RobotMap.diffDrive.arcadeDrive(0, -0.6, true); 
          }else if(time - startTime >= 5 && time - startTime <= 11.8){//foward
            RobotMap.diffDrive.arcadeDrive(0.65, 0, true); 
          }else if(time - startTime >= 5 && time - startTime <= 12.3){//turn left
            RobotMap.diffDrive.arcadeDrive(0, -0.65, true); 
          }else if(time - startTime >= 5 && time - startTime <= 14.1){//foward
            RobotMap.diffDrive.arcadeDrive(0.7, 0, true); 
          }
        }
      }else if(location == 3){
          if (time - startTime < 0.5){//turn left
            RobotMap.diffDrive.arcadeDrive(0.0, -0.62, true);
          }else if(time - startTime >= 5 && time - startTime <= 6.5){//wait then foward
            RobotMap.diffDrive.arcadeDrive(0.65, 0, true); 
          }


      }


  } 

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

    driveTrain.driveWithXbox();
   // System.out.println("Sensor Vel:" + RobotMap.driveMainLeft.getSelectedSensorVelocity());
    //System.out.println("Sensor Pos:" + RobotMap.driveMainLeft.getSelectedSensorPosition());
    currentPosition = RobotMap.driveMainLeft.getSelectedSensorPosition();
    //System.out.println("Rotation" + (currentPosition - startingPosition));
    double totalDistanceL = (currentPosition - startingPosition)/4096 * 18.85714285; 
    int myfeet = (int)(totalDistanceL/12);
    System.out.println("distance" + (myfeet));

  }


  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
// Because 9 8 10.