package com.spikes2212.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.spikes2212.robot.components.TalonSRXEncoder;

public class SubsystemComponents {
	public static class Shooter { 
		public static final WPI_TalonSRX ShooterTalon1 = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_1);
		public static final WPI_TalonSRX ShooterTalon2 = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_2);
		public static TalonSRXEncoder encoder;
		public static final int encoderKTimeoutms = 30;
		static {
			ShooterTalon1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, encoderKTimeoutms);
			ShooterTalon1.setSensorPhase(true);

			encoder = new TalonSRXEncoder();
		}
	}
}
