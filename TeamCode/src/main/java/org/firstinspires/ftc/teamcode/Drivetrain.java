package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    void init(HardwareMap hwMap) {
        leftMotor = hwMap.get(DcMotor.class, "leftMotor");
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        rightMotor = hwMap.get(DcMotor.class, "leftMotor");
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    void arcade(double power, double turn) {
        leftMotor.setPower(power - turn);
        rightMotor.setPower(power + turn);
    }

    void tank(double left, double right) {
        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }
}
