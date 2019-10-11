package org.firstinspires.ftc.teamcode.TestingOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class DriveOpMode extends LinearOpMode {
    private DcMotor motorLeft;
    private DcMotor motorRight;


    @Override
    public void runOpMode() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        double powerLeft = 0;
        double powerRight = 0;

        while(opModeIsActive()) {
            powerLeft = -this.gamepad1.left_stick_y;
            powerRight = -this.gamepad1.right_stick_y;
            motorLeft.setPower(powerLeft);
            motorRight.setPower(powerRight);

            telemetry.addData("Robot is driving", "");
            telemetry.update();
        }
    }
}
