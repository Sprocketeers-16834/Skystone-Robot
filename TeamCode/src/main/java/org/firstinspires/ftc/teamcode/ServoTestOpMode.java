package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class ServoTestOpMode extends LinearOpMode {
    private Servo servoTest;

    @Override
    public void runOpMode() {
        servoTest = hardwareMap.get(Servo.class, "servoTest");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while(opModeIsActive()) {
            servoTest.setPosition(1);
            telemetry.addData("Servo position: ", servoTest.getPosition());
            telemetry.update();
        }
    }
}
