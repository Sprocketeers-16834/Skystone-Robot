package org.firstinspires.ftc.teamcode.OpModes.Auton;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class BlueAutonBuild extends LinearOpMode {

    private Drivetrain drivetrain = new Drivetrain();
    private Puller puller = new Puller();

    public void runOpMode(){
        waitForStart();
        //Initialize all subsystems that are to be used
        drivetrain.init(hardwareMap);
        puller.init(hardwareMap);

//        write new auton here

//        Auton code for meet 1
//        puller.up();
//        drivetrain.moveToPosition(-22, 0.5);
//        drivetrain.arc(45.0, 10.0, 0.5);
//        drivetrain.arc(-45.0, 10.0,0.5);
//        drivetrain.moveToPosition(-6.0, 0.5);
//        puller.down();
//        sleep(1000);
//        drivetrain.moveToPosition(45, 0.3);
//        puller.up();
//        drivetrain.moveToPosition(5.0, 0.2);

    }
}

