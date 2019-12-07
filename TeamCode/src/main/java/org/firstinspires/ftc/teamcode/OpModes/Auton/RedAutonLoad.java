package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.FourBarLift;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;

@Autonomous
public class RedAutonLoad extends LinearOpMode {

    private HolonomicDrive hd = new HolonomicDrive();
    private Grabber grabber = new Grabber();
    private FourBarLift fbar = new FourBarLift();

    public void runOpMode() {
        waitForStart();
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        fbar.init(hardwareMap);

        grabber.up();
        fbar.close();
        hd.strafeToPosition(-38.9, 0.2);

        int count = 0;

        for(int i=0; i<2; i++) {
            boolean flagSS = false;
            count = 0;
            telemetry.addData("color value", grabber.getValue());

            while(!flagSS && count<6) {
                telemetry.addData("color value", grabber.getValue());
                hd.moveToPosition(-12 , 0.3);
                count++;

                if(grabber.isSkystone()) {
                    telemetry.addData("FOUND", "SKYSTONE");

                    grabber.down();
                    flagSS = true;
                }
            }

            grabber.down();
            hd.strafeToPosition(10, 0.4);
            hd.moveToPosition(count*11 + 60, 0.4);
            grabber.up();
            hd.moveToPosition(-count*11-36, 0.4);
//            hd.strafeToPosition(-12, 0.4);
        }

        hd.moveToPosition(count*11 + 30, 0.4);
//        hd.strafeToPosition(7.0, 0.4);
//        hd.moveToPosition(-28, 0.4);

        telemetry.update();
    }

}
