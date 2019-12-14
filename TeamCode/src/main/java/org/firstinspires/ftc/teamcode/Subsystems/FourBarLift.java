package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


public class FourBarLift {
    private DcMotor rotate;
    private Servo leftPincer;
    private Servo rightPincer;

    public void init(HardwareMap hwMap) {
        rotate = hwMap.get(DcMotor.class, "rotate");
        leftPincer = hwMap.get(Servo.class, "leftPincer");
        rightPincer = hwMap.get(Servo.class, "rightPincer");
    }

    public void move(double power){
        rotate.setPower(0.5*power);
    }

    public void close() {
        leftPincer.setPosition(Servo.MIN_POSITION);
        rightPincer.setPosition(Servo.MAX_POSITION);
    }

    public void open() {
        leftPincer.setPosition(0.6);
        rightPincer.setPosition(0.6);
    }

}
