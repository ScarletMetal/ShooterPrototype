package com.spikes2212.robot.components;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

import java.util.function.Supplier;

public class TalonSRXEncoder implements PIDSource {

    private Supplier<Double> velocitySupplier;
    public TalonSRXEncoder(Supplier<Double> velocitySupplier) {
        this.velocitySupplier = velocitySupplier;
    }

    @Override
    public void setPIDSourceType(PIDSourceType pidSource) {

    }

    @Override
    public PIDSourceType getPIDSourceType() {
        return PIDSourceType.kRate;
    }

    @Override
    public double pidGet() {
        return velocitySupplier.get();
    }
}
