// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.*;

public final class Autos {
public static final Command exampleAuto(CANDriveSubsystem driveSubsystem, CANRollerSubsystem rollerSubsystem) {


  return new SequentialCommandGroup(
    //forward
    driveSubsystem.driveArcade(driveSubsystem, () -> -0.5, () -> 0.0).withTimeout(0.0),
       Commands.waitSeconds(1.0), 
    //shoot coral
       rollerSubsystem.runRoller(rollerSubsystem,() -> 0.0, () -> 0.4) .withTimeout(0.2)
//        Commands.waitSeconds(1.0),
//       //Reverse to get around reef
//        driveSubsystem.driveArcade(driveSubsystem, () -> 0.2, () -> 0.0).withTimeout(0.1),
//        Commands.waitSeconds(1.0),
//        //turn 45 degrees
//        driveSubsystem.driveArcade(driveSubsystem, () -> 0.0, () -> 1.5).withTimeout(0.2),
//        Commands.waitSeconds(1.0),
//       //Reverse to get around reef
//       driveSubsystem.driveArcade(driveSubsystem, () -> 0.2, () -> 0.0).withTimeout(0.1),
//       Commands.waitSeconds(1.0),
//        //turn 45 degrees
//        driveSubsystem.driveArcade(driveSubsystem, () -> 0.0, () -> .5).withTimeout(0.2),
//        Commands.waitSeconds(1.0),
//       //drive to receiver
// //       driveSubsystem.driveArcade(driveSubsystem, () -> 0.5, () -> 0.0).withTimeout(3.0),
//        Commands.waitSeconds(1.0)
//        //turn around 180
  //     driveSubsystem.driveArcade(driveSubsystem, () -> 0.0, () -> 0.6).withTimeout(0.35)
   
       );
  }
}





  // Backup Backup Auto - Drive forward - In container, make sure autochooser is "BACKUP" code
 //public static final Command exampleAuto(CANDriveSubsystem driveSubsystem) {
 //return driveSubsystem.driveArcade(driveSubsystem, () -> -0.5, () -> 0.0).withTimeout(0.5);}

// Left Position Auto - Drive forward - In container, make sure its exampleAutoLeft!
//  public static final Command exampleAutoLeft(CANDriveSubsystem driveSubsystem) {
//  return driveSubsystem.driveArcade(driveSubsystem, () -> -0.5, () -> 0.0).withTimeout(0.5);}

// Right Position Auto - Drive forward - In container, make sure its exampleAutoRight!
//  public static final Command exampleAutoRight(CANDriveSubsystem driveSubsystem) {
//   return driveSubsystem.driveArcade(driveSubsystem, () -> -0.5, () -> 0.0).withTimeout(0.5);}
                  
  // Central Auto - Drive straight forwards, drop coral - In container, make sure autochooser 
  // is drive AND roller!
  // Uncomment this if addOption command stuff doesnt work.

  //exampleAutoCenter. Comment this if addOption stuff doesnt work
//public static final Command exampleAutoCenter(CANDriveSubsystem driveSubsystem, CANRollerSubsystem rollerSubsystem) {
  // return new SequentialCommandGroup(
  //       driveSubsystem.driveArcade(driveSubsystem, () -> -0.5, () -> 0.0).withTimeout(0.8),
  //       Commands.waitSeconds(1.0), 
  //       rollerSubsystem.runRoller(rollerSubsystem,() -> 0.0, () -> 0.4) .withTimeout(0.4)
  // );
  
  // }
  //don't get rid of the yellow bracket!!! it will break!!!

  //don't get rid of the yellow bracket!!! it will break!!!