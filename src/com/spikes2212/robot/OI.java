/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.spikes2212.robot;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystemWithPIDForSpeed;
import com.spikes2212.robot.commands.RiseToSpeed;
import com.spikes2212.robot.commands.ShootWithPIDOnTalon;
import com.spikes2212.utils.PIDSettings;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static final Supplier<Double> shooterPower = ConstantHandler.addConstantDouble("shooter speed", 0.1);
	public static final Supplier<Double> speedTimeout = ConstantHandler.addConstantDouble("speed timeout", 0.5);
	public static final Supplier<Double> speedJumps  = ConstantHandler.addConstantDouble("speed jumps", 10);

	private static final Supplier<Double> SHOOTER_SETPOINT = ConstantHandler.addConstantDouble("shooter setpoint", 6);
	private static final Supplier<Double> SHOOTER_KP = ConstantHandler.addConstantDouble("shooter kp", 0.5);
	private static final Supplier<Double> SHOOTER_KI = ConstantHandler.addConstantDouble("shooter ki", 0);
	private static final Supplier<Double> SHOOTER_KD = ConstantHandler.addConstantDouble("shooter kd", 0);

	private Joystick joystick = new Joystick(0);
	public OI () {
		
		/*btn.whileHeld(new MoveBasicSubsystemWithPIDForSpeed(Robot.shooter,
				SubsystemComponents.Shooter.encoder, () -> SHOOTER_SETPOINT.get() * 1024,
				new PIDSettings(SHOOTER_KP.get(), SHOOTER_KI.get(), SHOOTER_KD.get(), 1, 0), 0.5));*/
		
		JoystickButton btn2 = new JoystickButton(joystick, 1);
		
		btn2.whileHeld(new RiseToSpeed(Robot.shooter, shooterPower, speedTimeout, speedJumps));
		
	}
}
