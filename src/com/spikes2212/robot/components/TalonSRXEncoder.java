package com.spikes2212.robot.components;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.spikes2212.robot.SubsystemComponents;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

import java.util.function.Supplier;

public class TalonSRXEncoder implements PIDSource {

    private Supplier<Double> velocitySupplier;
    public TalonSRXEncoder() {
        this.velocitySupplier = () -> (double) SubsystemComponents.Shooter.ShooterTalon1.getSelectedSensorVelocity() / 1024;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return null;
    }

    @Override
    public double pidGet() {
    	System.out.println("Returning " + velocitySupplier.get());
        return velocitySupplier.get();
    }
}
