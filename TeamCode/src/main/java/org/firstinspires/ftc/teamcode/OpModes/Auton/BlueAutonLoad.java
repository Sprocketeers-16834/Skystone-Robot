package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;

@Autonomous
public class BlueAutonLoad extends LinearOpMode {

    private Drivetrain drivetrain = new Drivetrain();
    private Grabber grabber = new Grabber();

    public void runOpMode() {
        drivetrain.init(hardwareMap);
        grabber.init(hardwareMap);
        int count = 0;

        waitForStart();
        grabber.up();
        drivetrain.moveToPosition(60, 0.5);
        drivetrain.arc(45.0, 24.0, 0.5);
//        drivetrain.moveToPosition(-5.0, 0.5);
        grabber.down();
//        drivetrain.arc(5.0, 20.0, 0.5);
        drivetrain.turnWithGyro(-7, 0.5);
        drivetrain.moveToPosition(66.0, 0.5);
        grabber.up();
        drivetrain.moveToPosition(-25.0, 0.5);

//        grabber.up();
//        drivetrain.moveToPosition(-17.6, 0.5);
//        drivetrain.arc(44.0, 10.4, 0.5);
//
//        while(grabber.getAlpha() < 20 && count<6) {
//            drivetrain.moveToPosition(-6.4, 0.5);
//            count++;
//        }
//        grabber.down();
//        drivetrain.turnWithGyro(9, -.5);
//        drivetrain.moveToPosition(81.4, 0.5);
//        grabber.up();
//        drivetrain.moveToPosition(-22.6, 0.5);
    }

}
