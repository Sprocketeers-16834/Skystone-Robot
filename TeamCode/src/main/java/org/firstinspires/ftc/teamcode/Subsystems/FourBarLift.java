package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class FourBarLift {
    private DcMotor rotate;
    private Servo pincer;

    public void init(HardwareMap hwMap) {
        rotate = hwMap.get(DcMotor.class, "rotate");
        pincer = hwMap.get(Servo.class, "pincer");
    }

    public void move(double power){
        rotate.setPower(0.5*power);
    }

    public void close() {
        pincer.setPosition(Servo.MIN_POSITION);
    }

    public void open() {
        pincer.setPosition(0.7);
    }

}
