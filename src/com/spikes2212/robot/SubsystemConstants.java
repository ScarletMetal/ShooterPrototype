package com.spikes2212.robot;

import java.util.function.Supplier;

import com.spikes2212.dashboard.ConstantHandler;

public class SubsystemConstants {
	public static class Shooter{
		public static final Supplier<Double> SHOOTER_SPEED = ConstantHandler.addConstantDouble("shooter speed", 0.2);
	}

}
