package com.spikes2212.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SubsystemComponents {
	public static class Shooter { 
		public static WPI_TalonSRX SHOOTER_TALON_1 = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_1);
		public static WPI_TalonSRX SHOOTER_TALON_2 = new WPI_TalonSRX(RobotMap.CAN.SHOOTER_2);
		
		static {
//			SHOOTER_TALON_1.setInverted(true);
		}
	}

	public static class Feeder {
		public static WPI_TalonSRX FEEDER_TALON_1 = new WPI_TalonSRX(RobotMap.CAN.FEEDER_1);
		public static WPI_TalonSRX FEEDER_TALON_2 = new WPI_TalonSRX(RobotMap.CAN.FEEDER_2);

		static {
			FEEDER_TALON_1.setInverted(true);
		}
	}
}
