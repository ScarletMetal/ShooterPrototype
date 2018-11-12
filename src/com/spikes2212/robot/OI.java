/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.spikes2212.robot;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;
import com.spikes2212.genericsubsystems.basicSubsystem.commands.MoveBasicSubsystem;
import com.spikes2212.genericsubsystems.commands.MoveBasicSubsystem;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private static final Supplier<Double> SHOOTER_SPEED = ConstantHandler.addConstantDouble("shooter speed", 0.1);
	private static final Supplier<Double> FEEDER_SPEED = ConstantHandler.addConstantDouble("feeder speed", 0.2);
	
	private Joystick joystick = new Joystick(0);
	public OI () {
		JoystickButton shootButton = new JoystickButton(joystick, 1);
		JoystickButton feedButton = new JoystickButton(joystick, 2);

		shootButton.whileHeld(new MoveBasicSubsystem(Robot.shooter, SHOOTER_SPEED));
		feedButton.whileHeld(new MoveBasicSubsystem(Robot.feeder, FEEDER_SPEED));
	}
}
