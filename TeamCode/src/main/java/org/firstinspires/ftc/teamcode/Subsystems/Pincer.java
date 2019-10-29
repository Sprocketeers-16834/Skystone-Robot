package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Pincer {
    private Servo pincer;

    public void init(HardwareMap hwMap) {
        pincer = hwMap.get(Servo.class, "pincer");
    }

    public void open() {
        pincer.setPosition(1.0);
    }

    public void close() {
        pincer.setPosition(0);
    }

}
