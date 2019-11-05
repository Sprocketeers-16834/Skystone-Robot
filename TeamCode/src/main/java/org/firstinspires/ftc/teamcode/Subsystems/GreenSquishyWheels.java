package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GreenSquishyWheels {
    private DcMotor leftGSWF;
    private DcMotor rightGSWF;
    private DcMotor leftGSWB;
    private DcMotor rightGSWB;

    void init(HardwareMap hwMap) {
        leftGSWF = hwMap.get(DcMotor.class, "leftGSW");
        leftGSWF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSWF.setDirection(DcMotor.Direction.REVERSE);

        rightGSWF = hwMap.get(DcMotor.class, "rightGSW");
        rightGSWF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSWB = hwMap.get(DcMotor.class, "leftGSW");
        leftGSWB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftGSWB.setDirection(DcMotor.Direction.REVERSE);

        rightGSWB = hwMap.get(DcMotor.class, "rightGSW");
        rightGSWB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    void intake(double power) {
        leftGSWF.setPower(power);
        rightGSWF.setPower(power);
        leftGSWB.setPower(power);
        rightGSWB.setPower(power);
    }
}
