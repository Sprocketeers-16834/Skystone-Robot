package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Puller {
    private Servo rightPuller;
    private Servo leftPuller;

    public void init(HardwareMap hwMap) {
        rightPuller = hwMap.get(Servo.class, "rightPuller");
        leftPuller = hwMap.get(Servo.class, "leftPuller");
    }

    public void down() {
        leftPuller.setPosition(1.0);
        rightPuller.setPosition(0);
    }

    public void up() {
        leftPuller.setPosition(Servo.MIN_POSITION);
        rightPuller.setPosition(Servo.MAX_POSITION);
    }
}
