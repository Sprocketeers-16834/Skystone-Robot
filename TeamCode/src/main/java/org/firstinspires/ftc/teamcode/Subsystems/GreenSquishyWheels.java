package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GreenSquishyWheels {
    private DcMotor leftGSWF;
    private DcMotor rightGSWF;
//    private DcMotor leftGSWB;
//    private DcMotor rightGSWB;

    public void init(HardwareMap hwMap) {
        leftGSWF = hwMap.get(DcMotor.class, "leftGSWF");
        leftGSWF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSWF.setDirection(DcMotor.Direction.REVERSE);

        rightGSWF = hwMap.get(DcMotor.class, "rightGSWF");
        rightGSWF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        leftGSWB = hwMap.get(DcMotor.class, "leftGSW");
//        leftGSWB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        leftGSWB.setDirection(DcMotor.Direction.REVERSE);
//
//        rightGSWB = hwMap.get(DcMotor.class, "rightGSW");
//        rightGSWB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void intake(double power) {
//        leftGSWF.setPower(power);
        rightGSWF.setPower(power);
//        leftGSWB.setPower(power);
        leftGSWF.setPower(power);
    }

    public void spit(double power) {
//        leftGSWF.setPower(power);
        rightGSWF.setPower(-power);
//        leftGSWB.setPower(power);
        leftGSWF.setPower(-power);
    }

    public void stop() {
//        leftGSWF.setPower(0);
        rightGSWF.setPower(0);
//        leftGSWB.setPower(0);
        leftGSWF.setPower(0);
    }
}
