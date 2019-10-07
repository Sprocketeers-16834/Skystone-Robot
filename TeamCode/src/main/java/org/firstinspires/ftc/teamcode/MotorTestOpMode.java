package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class MotorTestOpMode extends LinearOpMode {
    private DcMotor motorTest;

    @Override
    public void runOpMode() {
        hardwareMap.get(DcMotor.class, "motorTest");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {
            motorTest.setPower(0.5);

            telemetry.addData("Motor is running at: ", motorTest.getPower());
            telemetry.update();
        }
    }
}
