package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {
    private Servo grabber;

    public void init(HardwareMap hwMap) {
        grabber = hwMap.get(Servo.class, "grabber");
    }


    public void down() {
        grabber.setPosition(Servo.MAX_POSITION);
    }

    public void up() {
        grabber.setPosition(Servo.MIN_POSITION);
    }

}
