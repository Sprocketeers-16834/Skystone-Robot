package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

public class Puller {
    private Servo rightPuller;
    private Servo leftPuller;

    public Puller(HardwareMap hwMap) {
        rightPuller = hwMap.get(Servo.class, "rightPuller");
        leftPuller = hwMap.get(Servo.class, "leftPuller");
    }

    public void down() {
        leftPuller.setPosition(Servo.MIN_POSITION);
        rightPuller.setPosition(Servo.MAX_POSITION);
    }

    public void up() {
        leftPuller.setPosition(0.5);
        rightPuller.setPosition(0.5);
    }

//    public void move(){
//        if(leftPuller.getPosition() < 0.2) {
//            leftPuller.setPosition(1);
//            rightPuller.setPosition(0);
//        }
//        if(leftPuller.getPosition() >0.8) {
//            leftPuller.setPosition(0);
//            rightPuller.setPosition(1);
//        }
//    }

}
