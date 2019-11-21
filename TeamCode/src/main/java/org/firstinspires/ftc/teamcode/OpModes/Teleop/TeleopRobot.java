package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.GreenSquishyWheels;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

@TeleOp
public class TeleopRobot extends OpMode {
//    private Drivetrain drivetrain = new Drivetrain(hardwareMap);
    private HolonomicDrive hd = new HolonomicDrive();
//    private Puller puller = new Puller();
//    private Grabber grabber = new Grabber();
//    private GreenSquishyWheels gsw = new GreenSquishyWheels();

    @Override
    public void init() {
        hd.init(hardwareMap);
//        grabber.up();
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double x = this.gamepad1.right_stick_x;
        double y = -this.gamepad1.right_stick_y;
        double turn = this.gamepad1.left_stick_x;
        hd.spin(x);
        hd.drive(x, y);


//        if (this.gamepad1.dpad_down) {
//            puller.down();
//        } else if (this.gamepad1.dpad_up) {
//            puller.up();
//        }
//
//        if (this.gamepad2.dpad_up) {
//            grabber.up();
//        } else if (this.gamepad2.dpad_down) {
//            grabber.down();
//        }
//
//        double intakePower = this.gamepad2.right_stick_y;
//        gsw.allIn(intakePower);
//        if(this.gamepad2.a) {
//            gsw.intake(1.0);
//        } else if(this.gamepad2.y) {
//            gsw.outtake(1.0);
//        } else if(this.gamepad2.x) {
//            gsw.allIn(1.0);
//        } else if(this.gamepad2.b) {
//            gsw.allOut(1.0);
//        } else {
//            gsw.stop();
//        }
//
//        telemetry.addData("intake", this.gamepad1.x);
//        telemetry.addData("leftJoystick", this.gamepad1.left_stick_y);
//        telemetry.addData("rightJoystick", this.gamepad1.right_stick_y);
//        telemetry.addData("spit", this.gamepad1.b);
//        telemetry.addData("color!", grabber.getAlpha());
        telemetry.update();
    }
}