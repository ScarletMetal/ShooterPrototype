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
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystemWithPID;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystemWithPIDForSpeed;
import com.spikes2212.utils.PIDSettings;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static final Supplier<Double> shooterPower = ConstantHandler.addConstantDouble("shooter speed", 0.1);
	private static final Supplier<Double> SHOOTER_KP = ConstantHandler.addConstantDouble("Shooter KP", 0.5);
	private static final Supplier<Double> SHOOTER_KI = ConstantHandler.addConstantDouble("Shooter KI", 0);
	private static final Supplier<Double> SHOOTER_KD = ConstantHandler.addConstantDouble("Shooter KD", 0);
	private static final Supplier<Double> SHOOTER_TARGET_SPEED = ConstantHandler.addConstantDouble("Shooter Target", 6);
	
	private Joystick joystick = new Joystick(0);
	public OI () {
		JoystickButton btn = new JoystickButton(joystick, 1);
		JoystickButton btnPID = new JoystickButton(joystick, 2);
		
//		btn.whileHeld(new MoveBasicSubsystem(Robot.shooter, shooterPower));
		btn.whileHeld(new MoveBasicSubsystemWithPIDForSpeed(Robot.shooter, SubsystemComponents.Shooter.encoder, SHOOTER_TARGET_SPEED, new PIDSettings(SHOOTER_KP.get(), SHOOTER_KI.get(), SHOOTER_KD.get(), 1, 1), 1));
	}
}
