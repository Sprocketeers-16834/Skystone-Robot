package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GreenSquishyWheels {
    private DcMotor leftGSW;
    private DcMotor rightGSW;

    void init(HardwareMap hwMap) {
        leftGSW = hwMap.get(DcMotor.class, "leftGSW");
        leftGSW.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSW.setDirection(DcMotor.Direction.REVERSE);

        rightGSW = hwMap.get(DcMotor.class, "rightGSW");
        rightGSW.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    void intake(double power) {
        leftGSW.setPower(power);
        rightGSW.setPower(power);
    }
}
