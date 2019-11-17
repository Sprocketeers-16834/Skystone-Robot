package org.firstinspires.ftc.teamcode.OpModes.Auton;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class RedAutonBuild extends LinearOpMode {
    private Drivetrain drivetrain = new Drivetrain();
    private Puller puller = new Puller();
    public void runOpMode(){
        drivetrain.init(hardwareMap);
        puller.init(hardwareMap);

        waitForStart();
        puller.up();
        drivetrain.moveToPosition(-22, 0.5);
        drivetrain.arc(-45.0, 10.0, 0.5);
        drivetrain.arc(45.0, 10.0,0.5);
        drivetrain.moveToPosition(-6.0, 0.5);
        puller.down();
        sleep(1000);
        drivetrain.moveToPosition(45, 0.5);
        puller.up();
        drivetrain.moveToPosition(5.0, 0.2);

//        drivetrain.moveToPosition(55, 0.5);
//        drivetrain.turnWithGyro(-90, -0.5);
//        drivetrain.moveToPosition(-9.4, 0.5);
////        puller.down();
////        drivetrain.arc(-45.0, 17.2, 0.5);
////        drivetrain.moveToPosition(24.2, 0.5);
////        drivetrain.arc(45.0, 13.6, 0.5);
////        drivetrain.moveToPosition(-22, 0.5);
    }
}
