package com.spikes2212.robot.commands;

import java.util.function.Supplier;

import com.spikes2212.genericsubsystems.BasicSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RiseToSpeed extends Command {

	private BasicSubsystem subsystem;
	private Supplier<Double> setpoint, timeout, jumps;
	
	private double currentSpeed;
	private double speedJump;
	private double timer;
    public RiseToSpeed(BasicSubsystem subsystem, Supplier<Double> setpoint,
    		Supplier<Double> timeoutSupplier,
    		Supplier<Double> speedJumps) {
    	requires(subsystem);
    	this.subsystem = subsystem;
    	this.setpoint = setpoint;
    	this.jumps = speedJumps;
    	timeout = timeoutSupplier;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = Timer.getFPGATimestamp();
    	speedJump = setpoint.get() / jumps.get();
    	currentSpeed = speedJump;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (currentSpeed != setpoint.get()) {
    		if (Timer.getFPGATimestamp() - timer > timeout.get()) {
    			currentSpeed += speedJump;
    			timer = Timer.getFPGATimestamp();
    		}
    	}
    	
    	subsystem.move(currentSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	subsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
