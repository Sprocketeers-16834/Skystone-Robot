package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


//false state means closed
public class Pincer {
    private DcMotor pincer;
    private boolean state = true;

    public void init(HardwareMap hwMap) {
        pincer = hwMap.get(DcMotor.class, "pincer");
    }

    public boolean getState() {
        return state;
    }

    /*public void open() {
        pincer.setPower(1.0);
        state = true;
    }

    public void close() {
        pincer.setPosition(0);
        state = false;
    }*/


    public void move(double power){
        pincer.setPower(power);
    }

}
