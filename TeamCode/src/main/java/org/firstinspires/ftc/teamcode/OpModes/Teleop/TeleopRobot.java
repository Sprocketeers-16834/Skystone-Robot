package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


import org.firstinspires.ftc.teamcode.Subsystems.FourBarLift;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;


@TeleOp
public class TeleopRobot extends OpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Grabber grabber = new Grabber();
    private Puller puller = new Puller();
    private FourBarLift fBar = new FourBarLift();

    @Override
    public void init() {
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        puller.init(hardwareMap);
        fBar.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double x = this.gamepad1.right_stick_x;
        double y = -this.gamepad1.right_stick_y;
        double turn = this.gamepad1.left_stick_x;

        double rotate = -this.gamepad2.left_stick_y;

        hd.spin(turn);
        hd.drive(x, y);

        fBar.move(rotate);

        if(this.gamepad2.dpad_down) {
            fBar.open();
        } if(this.gamepad2.dpad_up) {
            fBar.close();
        }

        telemetry.addData("color alpha", grabber.getAlpha());
        telemetry.addData("grabber", grabber.getPosition());

        telemetry.update();
    }
}