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
        waitForStart();
        drivetrain.init(hardwareMap);
        grabber.init(hardwareMap);

//        write new auton here

//        Auton code for meet 1
//        int count = 0;
//        grabber.up();
//        drivetrain.moveToPosition(60, 0.5);
//        drivetrain.arc(45.0, 24.0, 0.5);
////        drivetrain.moveToPosition(-5.0, 0.5);
//        grabber.down();
////        drivetrain.arc(5.0, 20.0, 0.5);
//        drivetrain.turnWithGyro(-7, 0.5);
//        drivetrain.moveToPosition(66.0, 0.5);
//        grabber.up();
//        drivetrain.moveToPosition(-25.0, 0.5);

    }

}
