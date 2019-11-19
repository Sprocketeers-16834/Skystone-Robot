package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GreenSquishyWheels {
    private DcMotor leftGSWF;
    private DcMotor rightGSWF;
    private DcMotor leftGSWB;
    private DcMotor rightGSWB;

    public GreenSquishyWheels(HardwareMap hwMap) {
        leftGSWF = hwMap.get(DcMotor.class, "leftGSWF");
        leftGSWF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSWF.setDirection(DcMotor.Direction.REVERSE);

        rightGSWF = hwMap.get(DcMotor.class, "rightGSWF");
        rightGSWF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftGSWB = hwMap.get(DcMotor.class, "leftGSWB");
        leftGSWB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSWB.setDirection(DcMotor.Direction.REVERSE);

        rightGSWB = hwMap.get(DcMotor.class, "rightGSWB");
        rightGSWB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void intake(double power) {
        leftGSWF.setPower(-power);
        rightGSWF.setPower(-power);
    }

    public void allIn(double power) {
        leftGSWF.setPower(-power);
        rightGSWF.setPower(-power);
        leftGSWB.setPower(-power);
        rightGSWB.setPower(-power);
    }

    public void allOut(double power) {
        leftGSWF.setPower(power);
        rightGSWF.setPower(power);
        leftGSWB.setPower(power);
        rightGSWB.setPower(power);
    }

    public void outtake(double power) {
        leftGSWB.setPower(power);
        rightGSWB.setPower(power);
    }

    public void stop() {
        leftGSWF.setPower(0);
        rightGSWF.setPower(0);
        leftGSWB.setPower(0);
        rightGSWB.setPower(0);
    }
}
