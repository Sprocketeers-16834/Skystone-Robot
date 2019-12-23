package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

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

    public void move(double power){
        pincer.setPower(power);
    }

}
