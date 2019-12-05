package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;

@Autonomous
public class BlueAutonLoad extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Grabber grabber = new Grabber();

    public void runOpMode() {
        waitForStart();
        hd.init(hardwareMap);
        grabber.init(hardwareMap);

//        hd.moveToPosition(28, 0.5);
//        hd.turnWithGyro(90, 0.4);

        boolean flagSS = false;
        int count = 0;
        while(!flagSS && count<6) {
            hd.moveToPosition(10, 0.3);
            count++;

            if(grabber.isSkystone()) {
                flagSS = true;
            }
        }

        telemetry.addData("grabber", grabber.getPosition());
        grabber.down();

//        hd.turnWithGyro(10, 0.3);
//        hd.moveToPosition(24, 0.4);
        grabber.down();


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
