package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;

@TeleOp
public class TeleopRobot extends OpMode {
    private HolonomicDrive hd = new HolonomicDrive();

    @Override
    public void init() {
        hd.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double x = this.gamepad1.right_stick_x;
        double y = -this.gamepad1.right_stick_y;
        double turn = this.gamepad1.left_stick_x;
        hd.spin(turn);
        hd.drive(x, y);
        
        telemetry.update();
    }
}