package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.FourBarLift;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;

@Autonomous
public class BlueAutonLoad extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Grabber grabber = new Grabber();
    private FourBarLift fbar = new FourBarLift();
    private final int stone = 8;

    public void runOpMode() {
        waitForStart();
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        fbar.init(hardwareMap);

        grabber.up();
        fbar.close();
        hd.strafeToPosition(83, 0.5);

        int count = 0;


        boolean flagSS = false;

        while(!flagSS && count<6) {
            telemetry.addData("color value", grabber.getBR());
            hd.moveToPosition(18, 0.2);
            count++;

            if(grabber.isSkystone()) {
                hd.strafeToPosition(21, 0.5);
                sleep(1000);
                telemetry.addData("FOUND", "SKYSTONE");
                grabber.down();

                sleep(500);
                hd.strafeToPosition(3, 0.3);
                hd.moveToPosition(-5, 0.3);

                hd.strafeToPosition(-120, 0.5);
                hd.miniAdjust();
                flagSS = true;
                telemetry.update();
            }
            else if(Math.abs(hd.getDistance()-3) >= 0.3) {
                telemetry.addData("ADJUSTING", "DISTANCE");
                telemetry.addData("Distance", hd.getDistance());
                double mag = hd.getDistance() - 1;
                hd.strafeToPosition(1*mag, 0.2);
                telemetry.update();
            }
            telemetry.addData("Position", hd.getPosition());
            telemetry.update();
        }

        hd.moveToPosition(-count*stone - 80, 0.7);
        grabber.up();
        hd.moveToPosition(40, 0.7);

        telemetry.update();
    }
}
