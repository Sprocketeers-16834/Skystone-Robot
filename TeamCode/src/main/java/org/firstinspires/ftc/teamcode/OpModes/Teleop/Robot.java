package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Lift;
import org.firstinspires.ftc.teamcode.Subsystems.Pincer;

@TeleOp
public class Robot extends OpMode {
    private Drivetrain drivetrain = new Drivetrain();
    private Lift lift = new Lift();
    private Pincer pincer= new Pincer();

    @Override
    public void init() {
        drivetrain.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double left = -this.gamepad1.left_stick_y;
        double right = -this.gamepad1.right_stick_y;
        drivetrain.tank(left, right);

        double liftPower = -this.gamepad2.left_stick_x;
        lift.lift(liftPower);
    }
}