package com.spikes2212.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SubsystemComponents {
	public static class Shooter { 
		public static WPI_TalonSRX ShooterTalon1 = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_1);
		public static WPI_TalonSRX ShooterTalon2 = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_2);
		
		static {
//			ShooterTalon1.setInverted(true);
		}
	}
}
