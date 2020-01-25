package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.FourBarLift;
import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;

@Autonomous
public class RedAutonLoad extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Grabber grabber = new Grabber();
    private FourBarLift fbar = new FourBarLift();
    private final int stone = 10;

    public void runOpMode() {
        waitForStart();
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        fbar.init(hardwareMap);

//        hd.strafeToPosition(20, 0.3);
//        hd.strafeToPosition(-20, 0.3);
        grabber.up();
        fbar.close();
        hd.strafeToPosition(76, 0.5);

        int count = 0;

        for(int i=0; i<1; i++) {
            boolean flagSS = false;
//            hd.moveToPosition(10, 0.3);
//            telemetry.addData("color value", grabber.getValue());

            while(!flagSS && count<6) {
                telemetry.addData("color value", grabber.getBR());
                hd.moveToPosition(-18, 0.2);
                count++;

                if(grabber.isSkystone()) {
                    hd.strafeToPosition(15, 0.5);
                    telemetry.addData("FOUND", "SKYSTONE");

                    sleep(1000);
                    grabber.down();

                    sleep(500);
                    hd.strafeToPosition(3, 0.3);
                    hd.moveToPosition(-5, 0.3);

                    hd.strafeToPosition(-35, 0.5);
                    flagSS = true;
                    telemetry.update();
                }
                if(Math.abs(hd.getDistance()-4) >= 0.3) {
                    telemetry.addData("ADJUSTING", "DISTANCE");
                    telemetry.addData("Distance", hd.getDistance());
                    double mag = hd.getDistance() - 1;
                    hd.strafeToPosition(-1*mag, 0.2);
                    telemetry.update();
                }
                telemetry.addData("Position", hd.getPosition());
                telemetry.update();
            }

//            if(!flagSS) {
//                grabber.down();
//                hd.strafeToPosition(-25, 0.5);
//                telemetry.addData("NONE OF", "THE ABOVE");
//            }

//            hd.moveToPosition(count*stone + 80, 0.5);
//            grabber.up();
//            hd.moveToPosition(-count*stone-120, 0.5);
//            hd.strafeToPosition(25, 0.5);
        }

        hd.moveToPosition(count*stone + 90, 0.7);
        grabber.up();
//        hd.strafeToPosition(7.0, 0.7);
        hd.moveToPosition(-20, 0.7);

        //parking align
        hd.strafeToPosition(20, 0.5);

        telemetry.update();
    }

}
