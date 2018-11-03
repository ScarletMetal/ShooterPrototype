/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.spikes2212.robot;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;

import com.spikes2212.robot.commands.ShootWithPIDOnTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static final Supplier<Double> shooterPower = ConstantHandler.addConstantDouble("shooter speed", 0.1);

	private static final Supplier<Double> SHOOTER_SETPOINT = ConstantHandler.addConstantDouble("shooter setpoint", 6);
	private static final Supplier<Double> SHOOTER_KP = ConstantHandler.addConstantDouble("shooter kp", 0.5);
	private static final Supplier<Double> SHOOTER_KI = ConstantHandler.addConstantDouble("shooter ki", 0);
	private static final Supplier<Double> SHOOTER_KD = ConstantHandler.addConstantDouble("shooter kd", 0);

	private Joystick joystick = new Joystick(0);
	public OI () {
		JoystickButton btn = new JoystickButton(joystick, 1);
		
		btn.whileHeld(new ShootWithPIDOnTalon(Robot.shooter, SubsystemComponents.Shooter.ShooterTalon1,
				SHOOTER_SETPOINT, SHOOTER_KD, SHOOTER_KI, SHOOTER_KD));
	}
}
