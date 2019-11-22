package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;

@Autonomous
public class RedAutonLoad extends LinearOpMode {

    private Drivetrain drivetrain = new Drivetrain();
    private Grabber grabber = new Grabber();

    public void runOpMode() {
        waitForStart();
        drivetrain.init(hardwareMap);
        grabber.init(hardwareMap);

//        write new auton here

//        Auton for meet 1
//        int count = 0;
//        grabber.up();
//        drivetrain.moveToPosition(55.5, 0.5);
//        drivetrain.arc(60.0, 24.0, 0.5);
//        drivetrain.moveToPosition(50.0, 0.5);
//        grabber.down();
//        sleep(1000);
//        drivetrain.arc(-10.0, 20.0, 0.5);
////        drivetrain.turnWithGyro(15, 0.5);
//        drivetrain.moveToPosition(-66.0, 0.5);
//        grabber.up();
//        drivetrain.moveToPosition(25.0, 0.5);
    }

}
