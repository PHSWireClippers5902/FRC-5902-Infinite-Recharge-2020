/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.RobotMap;
import frc.robot.commands.TopPistonToggle;
import frc.robot.subsystems.FlyWheelSystem;
import frc.robot.subsystems.ServoSystem;
import frc.robot.subsystems.PneumaticSystem;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI oi;
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  public static DriveTrain driveTrain;
  public static ServoSystem servoSystem;
  public static FlyWheelSystem flyWheelSystem;
  public static ClimbSystem climbSystem;
  public static LightSystem lightSystem;
  public static PneumaticSystem pneumaticSystem;
  private double startTime;
  public static boolean retractOnDisabled;
  public static boolean disabled;
  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    
    disabled = false;
    pneumaticSystem = new PneumaticSystem();
    driveTrain = new DriveTrain();
    servoSystem = new ServoSystem();
    flyWheelSystem = new FlyWheelSystem();
    climbSystem = new ClimbSystem();
    lightSystem = new LightSystem();
    oi = new OI();

    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    //SmartDashboard.putData("Auto choices", m_chooser);
    System.out.println("Robot Init - NOW");
    RobotMap.init();
    RobotMap.topSolenoid.set(false);
    RobotMap.frontSolenoid.set(false);
    RobotMap.backSolenoid.set(false);
    
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   * 
   * <p>
   * Does barely anything???
   */
  @Override
  public void robotPeriodic() {

    
    
    SmartDashboard.putBoolean("Front Pistons", RobotMap.frontSolenoid.get());
    SmartDashboard.putBoolean("Back Pistons", RobotMap.backSolenoid.get());
    SmartDashboard.putBoolean("Top Pistons", RobotMap.topSolenoid.get());
    SmartDashboard.putBoolean("PSI Switch", RobotMap.compressor.getPressureSwitchValue());
    SmartDashboard.putBoolean("Fly Wheel Status", flyWheelSystem.getFlywheelStatus()); 
    SmartDashboard.putBoolean("ballHatch", true );
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    Robot.lightSystem.getAllianceColor();
    startTime = Timer.getFPGATimestamp();
    RobotMap.compressor.start();
    Robot.lightSystem.getAllianceColor();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

    double time = Timer.getFPGATimestamp();
    if (time - startTime < 4.5){
      RobotMap.diffDrive.arcadeDrive(-0.6, 0.0, true);
    }  else if (time- startTime < 6){
      RobotMap.compressor.stop();
      RobotMap.flyWheel.set(0.5);
    } else {
      RobotMap.compressor.start();
      RobotMap.flyWheel.set(0);
    } 
   
    /*
    else if(time - startTime < 5){//shoot balls
      RobotMap.flyWheel.set(-0.5);
    }else if(time - startTime < 7){//back s
      traight out
      RobotMap.flyWheel.set(0);
      RobotMap.diffDrive.arcadeDrive(-0.7, 0, true);
    } */







    /*
    switch (m_autoSelected) {
      case kCustomAuto:
        RobotMap.diffDrive.arcadeDrive(oi.getXbox().getY(Hand.kLeft), oi.getXbox().getX(Hand.kLeft));
        break;
      case kDefaultAuto:
      default:
        if (oi.getXbox() != null) {
          RobotMap.diffDrive.arcadeDrive(oi.getXbox().getRawAxis(1), 0);
          break;
        } else {
          RobotMap.diffDrive.arcadeDrive(0.1, 0);
          break;
        }
    } */

  }

  @Override
  public void teleopInit() {
    Robot.lightSystem.getAllianceColor();
    RobotMap.compressor.start();
    //RobotMap.coolServo.setPosition(0);  // set position .5 is 90 degrees 
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run(); 
    driveTrain.driveWithXbox();
    flyWheelSystem.flyWheelController();
    
   // RobotMap.topSolenoid.set(false);
    //RobotMap.frontSolenoid.set(false);
    //RobotMap.backSolenoid.set(false);
  }
  

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {

  }

  @Override
  public void disabledInit(){
    retractOnDisabled = !RobotMap.topSolenoid.get();
    disabled = true;
    //System.out.println("disableInit retract " + retractOnDisabled);
  }
    
}
