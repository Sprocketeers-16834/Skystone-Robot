package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Pincer {
    private Servo pincer;

    void init(HardwareMap hwMap) {
        pincer = hwMap.get(Servo.class, "pincer");
    }

}
