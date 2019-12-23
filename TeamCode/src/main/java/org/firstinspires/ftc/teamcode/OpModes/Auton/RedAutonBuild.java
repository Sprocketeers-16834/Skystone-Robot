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

//        parking auton
//        hd.strafeToPosition(53, 0.3);

        puller.up();
//        hd.turnWithGyro(90, 0.3);
        hd.moveToPosition(-30, 0.2);
        hd.strafeToPosition(50, 0.2);
        hd.moveToPosition(-40,0.2);
        puller.down();
        hd.moveToPosition(10, 0.1);
        hd.moveToPosition(90, 0.5);
        puller.up();
        hd.strafeToPosition(-150, 0.2);

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
