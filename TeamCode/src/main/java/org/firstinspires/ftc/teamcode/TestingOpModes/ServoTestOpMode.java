package org.firstinspires.ftc.teamcode.TestingOpModes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
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

        while(true) {
            if (Math.abs(servoTest.getPosition()) >= 0.9 ) {
                servoTest.setPosition(0);
                telemetry.addData("Servo position: ", servoTest.getPosition());
            }
            if (Math.abs(servoTest.getPosition()) <= 0.1 ) {
                servoTest.setPosition(1);
                telemetry.addData("Servo position: ", servoTest.getPosition());
            }
//                telemetry.update();
        }

    }
}
