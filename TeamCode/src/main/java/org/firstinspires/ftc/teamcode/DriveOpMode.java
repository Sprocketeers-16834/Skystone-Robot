package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class DriveOpMode extends LinearOpMode {
    private DcMotor motorFrontLeft;
    private DcMotor motorFrontRight;
    private DcMotor motorBackLeft;
    private DcMotor motorBackRight;

    @Override
    public void runOpMode() {
        motorFrontLeft = hardwareMap.get(DcMotor.class, "motorFrontLeft");
        motorFrontRight = hardwareMap.get(DcMotor.class, "motorFrontRight");
        motorBackLeft = hardwareMap.get(DcMotor.class, "motorBackLeft");
        motorBackRight = hardwareMap.get(DcMotor.class, "motorBackRight");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        double powerLeft = 0;
        double powerRight = 0;

        while(opModeIsActive()) {
            powerLeft = -this.gamepad1.left_stick_y;
            powerRight = -this.gamepad1.right_stick_y;
            motorFrontLeft.setPower(powerLeft);
            motorBackLeft.setPower(powerLeft);
            motorFrontRight.setPower(powerRight);
            motorBackRight.setPower(powerRight);

            telemetry.addData("Robot is driving", "");
            telemetry.update();
        }
    }
}
