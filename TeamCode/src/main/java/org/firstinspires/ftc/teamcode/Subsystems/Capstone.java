package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Capstone {
    private Servo capstone;

    public void init(HardwareMap hwMap) {
        capstone = hwMap.get(Servo.class, "capstone");
    }

    public void down() {
        capstone.setPosition(0.4);
    }

    public void up() {
        capstone.setPosition(1.0);
    }
}


