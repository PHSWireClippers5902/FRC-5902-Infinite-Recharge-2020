package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidWrapper extends Solenoid {

    private boolean lastValue = false;

    // The constructor when the canID is 0
    SolenoidWrapper(int channel) {
        super(channel);
    }

    // Constructor when PWM canID is other than default 0
    SolenoidWrapper(int canID, int channel) {
        super(canID, channel);
    }

    public void set(boolean on) {
        lastValue = on;
        super.set(on);
    }

    @Override
    public boolean get() {
        return lastValue;
    }
}