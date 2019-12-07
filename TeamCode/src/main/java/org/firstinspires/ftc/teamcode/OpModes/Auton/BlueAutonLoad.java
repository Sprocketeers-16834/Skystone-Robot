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

        hd.strafeToPosition(-38.0, 0.2);
        hd.moveToPosition(10, 0.3);


        for(int i=0; i<2; i++) {
            boolean flagSS = false;
            int count = 0;
            hd.moveToPosition(10, 0.3);

            while(!flagSS && count<6) {
                count++;

                if(grabber.isSkystone()) {
                    flagSS = true;
                    grabber.down();
                }
            }
            grabber.down();
            hd.strafeToPosition(-   6.6, 0.2);
            hd.moveToPosition(-74, 0.2);
            grabber.up();
            hd.moveToPosition(41, 0.2);
            hd.strafeToPosition(7.0, 0.2);
        }

        hd.moveToPosition(-41, 0.2);
        hd.strafeToPosition(-7.0, 0.2);
//        hd.moveToPosition(-16, 0.2);

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
