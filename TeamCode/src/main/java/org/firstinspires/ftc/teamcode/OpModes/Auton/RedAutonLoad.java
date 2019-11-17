package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;

@Autonomous
public class RedAutonLoad extends LinearOpMode {

    private Drivetrain drivetrain = new Drivetrain();
    private Grabber grabber = new Grabber();

    public void runOpMode() throws InterruptedException{
        drivetrain.init(hardwareMap);
        grabber.init(hardwareMap);
        int count = 0;

        waitForStart();

        grabber.up();
        drivetrain.moveToPosition(55.5, 0.5);
        drivetrain.arc(60.0, 24.0, 0.5);
        drivetrain.moveToPosition(50.0, 0.5);
        grabber.down();
        sleep(1000);
        drivetrain.arc(-10.0, 20.0, 0.5);
//        drivetrain.turnWithGyro(15, 0.5);
        drivetrain.moveToPosition(-66.0, 0.5);
        grabber.up();
        drivetrain.moveToPosition(25.0, 0.5);
//        drivetrain.moveToPosition(17.6, 0.3);
//        drivetrain.arc(45.0, 10.4, 0.3);

//        while(grabber.getAlpha() < 20 && count<6) {
//            drivetrain.moveToPosition(6.4, 0.3);
//            count++;
//        }
//        grabber.down();
//        drivetrain.turnWithGyro(171, -0.3);
//        drivetrain.moveToPosition(81.4, 0.3);
//        grabber.up();
//        drivetrain.moveToPosition(-22.6, 0.3);
    }

}
