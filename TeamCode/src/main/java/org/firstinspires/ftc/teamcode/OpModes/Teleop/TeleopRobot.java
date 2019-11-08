package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

@TeleOp
public class TeleopRobot extends OpMode {
    private Drivetrain drivetrain = new Drivetrain();
    private Puller puller = new Puller();
//    private Lift lift = new Lift();
//    private Pincer pincer= new Pincer();

    @Override
    public void init() {
        drivetrain.init(hardwareMap);
        puller.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
//        double power = -this.gamepad1.right_stick_y;
//        double turn = -this.gamepad1.right_stick_x;
//        drivetrain.single(power, turn);

        double right = this.gamepad1.right_stick_y;
        double left = this.gamepad1.left_stick_y;
        drivetrain.tank(left, right);


        if(this.gamepad1.y) {
            puller.down();
            telemetry.addData("y", this.gamepad1.y);
        }
        if(this.gamepad1.a) {
            puller.up();
            telemetry.addData("a", this.gamepad1.a);
        }


        telemetry.update();
    }
}