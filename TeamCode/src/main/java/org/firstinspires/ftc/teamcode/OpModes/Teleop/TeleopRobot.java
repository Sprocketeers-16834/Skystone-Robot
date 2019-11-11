package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.GreenSquishyWheels;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

@TeleOp
public class TeleopRobot extends OpMode {
    private Drivetrain drivetrain = new Drivetrain();
    private Puller puller = new Puller();
    private Grabber grabber = new Grabber();
    private GreenSquishyWheels gsw = new GreenSquishyWheels();

    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        puller.init(hardwareMap);
        grabber.init(hardwareMap);
        gsw.init(hardwareMap);
        grabber.up();
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double right = this.gamepad1.right_stick_y;
        double left = this.gamepad1.left_stick_y;
        drivetrain.tank(left, right);


        if(this.gamepad1.dpad_down) {
            puller.down();
        } else if(this.gamepad1.dpad_up) {
            puller.up();
        }

        if(this.gamepad2.y) {
            grabber.up();
        } else if(this.gamepad2.a) {
            grabber.down();
        }

        if(this.gamepad2.x) {
            gsw.intake(1.0);
        } else if(this.gamepad2.b) {
            gsw.spit(1.0);
        } else {
            gsw.stop();
        }

        telemetry.addData("intake", this.gamepad1.x);
        telemetry.addData("spit", this.gamepad1.b);

        telemetry.update();
    }
}