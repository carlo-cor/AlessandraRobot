package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.MotorController; 
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drive {

private MotorControllerGroup left; 
private MotorControllerGroup right; 
private DifferentialDrive diffDrive; 

public Drive(MotorController fl, MotorController bl, MotorController fr, MotorController br){
    left = new MotorControllerGroup(fl, bl);
    right = new MotorControllerGroup(fr, br);
    diffDrive = new DifferentialDrive(left, right);
}

private double deadzone(double num){
    return Math.abs(num) > 0.1 ? num : 0;
}

public void arcade(double xSpeed, double zRotation){
    diffDrive.arcadeDrive(xSpeed, zRotation);
}

public void arcadeRun(double xSpeed, double zRotation){
    diffDrive.arcadeDrive(deadzone(xSpeed), deadzone(zRotation));
}

public void tank(double lSpeed, double rSpeed){
    diffDrive.tankDrive(lSpeed, rSpeed);
}

public void tankRun(double lSpeed, double rSpeed){
    diffDrive.tankDrive(deadzone(lSpeed), deadzone(rSpeed));
}

}