package com.spikes2212.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.RemoteFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.spikes2212.genericsubsystems.BasicSubsystem;
import com.spikes2212.robot.SubsystemComponents;

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
        this.setpoint = setpoint;
        this.kP = kP;
        this.kI = kI;
        this.kD = kD;
    }

    @Override
    protected void initialize() {
    	talonSRX.configNominalOutputForward(0);
    	talonSRX.configNominalOutputReverse(0);
    	talonSRX.configPeakOutputForward(1);
    	talonSRX.configPeakOutputReverse(-1);
        talonSRX.config_kP(0, kP.get());
        talonSRX.config_kI(0, kI.get());
        talonSRX.config_kD(0, kD.get());
    }

    @Override
    protected void execute() {
    	System.out.println("executing pid command on talon");
        talonSRX.set(ControlMode.Velocity, setpoint.get()*1024);
        SubsystemComponents.Shooter.ShooterTalon2.set(talonSRX.getMotorOutputPercent());
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
