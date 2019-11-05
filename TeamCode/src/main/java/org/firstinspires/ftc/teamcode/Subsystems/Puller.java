package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Puller {
    private Servo rightPuller;
    private Servo leftPuller;

    public void init(HardwareMap hwMap) {
        rightPuller = hwMap.get(Servo.class, "rightPuller");
        leftPuller = hwMap.get(Servo.class, "leftPuller");
    }

    public void move(double power){
        if(leftPuller.getPosition() < 0.2) {
            leftPuller.setPosition(1);
            rightPuller.setPosition(1);
        }
        if(leftPuller.getPosition() >0.8) {
            leftPuller.setPosition(0);
            rightPuller.setPosition(0);
        }
    }

}
