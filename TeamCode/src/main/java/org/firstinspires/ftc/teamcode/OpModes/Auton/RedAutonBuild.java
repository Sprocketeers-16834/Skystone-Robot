package org.firstinspires.ftc.teamcode.OpModes.Auton;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.FourBarLift;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class RedAutonBuild extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Puller puller = new Puller();
//    private FourBarLift fbar = new FourBarLift();

    public void runOpMode(){
        waitForStart();
        hd.init(hardwareMap);
        puller.init(hardwareMap);
//        fbar.init(hardwareMap);

        hd.strafeToPosition(53, 0.3);

//        hd.moveToPosition(-26.4, 0.2);
//        hd.strafeToPosition(-14, 0.2);
//        hd.moveToPosition(-22,0.2);
//        puller.up();
//        hd.moveToPosition(10, 0.1);
//        hd.moveToPosition(200, 0.5);
//        //
//        puller.down();
//
//        hd.strafeToPosition(59.4, 0.2);

//        Auton for meet 1
//        puller.up();
//        drivetrain.moveToPosition(-22, 0.5);
//        drivetrain.arc(-45.0, 10.0, 0.5);
//        drivetrain.arc(45.0, 10.0,0.5);
//        drivetrain.moveToPosition(-6.0, 0.5);
//        puller.down();
//        sleep(1000);
//        drivetrain.moveToPosition(45, 0.5);
//        puller.up();
//        drivetrain.moveToPosition(5.0, 0.2);
    }
}
