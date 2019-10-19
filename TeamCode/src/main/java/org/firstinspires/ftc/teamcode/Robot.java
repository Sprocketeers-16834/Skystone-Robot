package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Robot extends OpMode {
    private Drivetrain drivetrain = new Drivetrain();
    private GreenSquishyWheels greenSquishyWheels= new GreenSquishyWheels();
    private Lift lift = new Lift();
    private Pincer pincer= new Pincer();

    @Override
    public void init() {
        drivetrain.init(hardwareMap);
    }

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {
        double left = -this.gamepad2.left_stick_y;
        double right= -this.gamepad2.right_stick_y;

        drivetrain.tank(left, right);
    }
}