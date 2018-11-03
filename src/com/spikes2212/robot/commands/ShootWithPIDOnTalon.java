package com.spikes2212.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.spikes2212.genericsubsystems.basicSubsystem.BasicSubsystem;
import edu.wpi.first.wpilibj.command.Command;

import java.util.function.Supplier;

public class ShootWithPIDOnTalon extends Command {

    private BasicSubsystem subsystem;
    private TalonSRX talonSRX;
    private Supplier<Double> setpoint, kP, kI, kD;

    public ShootWithPIDOnTalon(BasicSubsystem subsystem, TalonSRX talonSRX, Supplier<Double> setpoint,Supplier<Double> kP,
                               Supplier<Double> kI, Supplier<Double> kD) {
        requires(subsystem);
        this.subsystem = subsystem;
        this.talonSRX = talonSRX;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    @Override
    protected void initialize() {
        talonSRX.config_kP(0, kP.get());
        talonSRX.config_kI(0, kI.get());
        talonSRX.config_kD(0, kD.get());
    }

    @Override
    protected void execute() {
        talonSRX.set(ControlMode.Velocity, setpoint.get()*1024);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void end() {
        talonSRX.config_kP(0, 0);
        talonSRX.config_kI(0, 0);
        talonSRX.config_kD(0, 0);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
