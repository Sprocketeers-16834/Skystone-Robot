package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Capstone;
import org.firstinspires.ftc.teamcode.Subsystems.FourBarLift;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;
import org.firstinspires.ftc.teamcode.Subsystems.TapeMeasure;


@TeleOp
public class TeleopNew extends OpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Grabber grabber = new Grabber();
    private Puller puller = new Puller();
    private FourBarLift fBar = new FourBarLift();
    private Capstone cap = new Capstone();
    private TapeMeasure tape = new TapeMeasure();

    @Override
    public void init() {
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        puller.init(hardwareMap);
        fBar.init(hardwareMap);
        cap.init(hardwareMap);
        tape.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double y = this.gamepad1.right_stick_x;
        double x = -this.gamepad1.right_stick_y;
        double turn = this.gamepad1.left_stick_x;

        double rotate = -this.gamepad2.left_stick_y;
        double tapeSpeed = -this.gamepad2.right_stick_y;

        if(Math.abs(turn)<0.1) {
            hd.drive(x, y);
        }

        if(x==0 && y==0) {
            hd.spin(turn);
        }

        if(rotate!=0) {
            fBar.move(rotate);
        } else {
            fBar.move(0);
        }

        if(Math.abs(tapeSpeed) > 0.1) {
            if(tapeSpeed>0) puller.down();
            tape.move(tapeSpeed);
        } else {
            tape.move(0);
        }

        if(this.gamepad2.b) {
            fBar.open();

        } else if(this.gamepad2.x) {
            fBar.close();
        }

        if(this.gamepad1.dpad_up) {
            puller.up();
        } else if(this.gamepad1.dpad_down) {
            puller.down();
        }

       if(this.gamepad2.y) {
           cap.up();
       } else if(this.gamepad2.a) {
           cap.down();
       }

       if(this.gamepad2.dpad_up) {
           grabber.up();
       } else if(this.gamepad2.dpad_down) {
           grabber.down();
       }

       telemetry.update();
    }
}