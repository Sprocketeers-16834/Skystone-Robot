package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Lift {
    private DcMotor leftLift;
    private DcMotor rightLift;
    private final int rotToBlock = 4;

    public Lift(HardwareMap hwMap) {
        leftLift = hwMap.get(DcMotor.class, "leftLift");
        leftLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftLift.setDirection(DcMotor.Direction.REVERSE);

        rightLift = hwMap.get(DcMotor.class, "rightLift");
        rightLift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void lift(double power) {
        leftLift.setPower(power);
        rightLift.setPower(power);
    }

    public void liftBlock(int block) {
        leftLift.setTargetPosition(block*rotToBlock);
    }

}
