package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TapeMeasure {
    private DcMotor tapeMeasureMotor;

    public void init(HardwareMap hwMap) {
        tapeMeasureMotor = hwMap.get(DcMotor.class, "tapeMeasureMotor");
    }

    public void move(double speed) {
        tapeMeasureMotor.setPower(speed);
    }
}
