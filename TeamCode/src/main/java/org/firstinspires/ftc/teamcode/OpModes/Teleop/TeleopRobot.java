package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.GreenSquishyWheels;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

@TeleOp
public class TeleopRobot extends OpMode {
    private Drivetrain drivetrain = new Drivetrain(hardwareMap);
    private Puller puller = new Puller(hardwareMap);
    private Grabber grabber = new Grabber(hardwareMap);
    private GreenSquishyWheels gsw = new GreenSquishyWheels(hardwareMap);

    @Override
    public void init() {
        grabber.up();
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double right = this.gamepad1.right_stick_y;
        double left = this.gamepad1.left_stick_y;
        drivetrain.tank(left, right);


        if (this.gamepad1.dpad_down) {
            puller.down();
        } else if (this.gamepad1.dpad_up) {
            puller.up();
        }

        if (this.gamepad2.dpad_up) {
            grabber.up();
        } else if (this.gamepad2.dpad_down) {
            grabber.down();
        }

        double intakePower = this.gamepad2.right_stick_y;
        gsw.allIn(intakePower);
        if(this.gamepad2.a) {
            gsw.intake(1.0);
        } else if(this.gamepad2.y) {
            gsw.outtake(1.0);
        } else if(this.gamepad2.x) {
            gsw.allIn(1.0);
        } else if(this.gamepad2.b) {
            gsw.allOut(1.0);
        } else {
            gsw.stop();
        }

        telemetry.addData("intake", this.gamepad1.x);
        telemetry.addData("leftJoystick", this.gamepad1.left_stick_y);
        telemetry.addData("rightJoystick", this.gamepad1.right_stick_y);
        telemetry.addData("spit", this.gamepad1.b);
        telemetry.addData("color!", grabber.getAlpha());
        telemetry.update();
    }
}