package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MotorTestOpMode extends LinearOpMode {
    private DcMotor motorTest;
    private DcMotor motorTest2;

    @Override
        public void runOpMode() {
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        motorTest2 = hardwareMap.get(DcMotor.class, "motorTest2");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        double power = 0;
        double power2 = 0;

        while(opModeIsActive()) {
            power = -this.gamepad1.left_stick_y;
            power2 = -this.gamepad1.right_stick_y;
            motorTest.setPower(power);
            motorTest2.setPower(power2);
            telemetry.addData("Servo position: ", motorTest.getPower());
            telemetry.update();
        }
    }
}
