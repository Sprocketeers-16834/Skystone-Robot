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
    private final int stone = 12;

    private int count = 0;

    public void runOpMode() {
        waitForStart();
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        fbar.init(hardwareMap);

        grabber.up();
        fbar.close();

        hd.strafeToPosition(-70, 0.6);   //left to approach quarry
        search();   //scan for ss and head over line
        grabber.up();   //release stone
        //second stone
        hd.moveToPosition((count+2)*stone +96,0.7); //forwards to approach next stone
        hd.strafeToPosition(-45, 0.7); //left to approach quarry
        search();  //scan for ss and head over line
        hd.moveToPosition(-60, 1.0);   //backwards a bit more over line
        grabber.up(); //release stone
        hd.moveToPosition(30, 1.0); //forwards to park

    }

    private void search() {
        count = 0;
        boolean flagSS = false;

        while(!flagSS && count<6) {
            if(Math.abs(hd.getGrabDistance()-3) >= 0.3) {       //strafe to make adjustments for distance to stone
                microAdjust();
            }

            if(grabber.isSkystone()) {
                ssProcedures();
                flagSS = true;                               //inform that skystone been found
            } else {
                telemetry.addData("color value", grabber.getBR());
                hd.moveToPosition(stone, 0.2);         //move forwards one stone
                count++;
            }
            telemetry.update();
        }

        hd.moveToPosition(-count*stone - 70, 1.0);  //backwards to pass the line
    }

    private void microAdjust() {
        telemetry.addData("ADJUSTING", "DISTANCE");
        telemetry.addData("Distance", hd.getGrabDistance());
        double mag = hd.getGrabDistance() - 1;
        hd.strafeToPosition(1*mag, 0.4);
        telemetry.update();
    }

    private void ssProcedures() {
        hd.strafeToPosition(-10, 0.6);   //left to push IN skystone
        sleep(500);                      //pause
        telemetry.addData("FOUND", "SKYSTONE");
        grabber.down();

        sleep(500);
        hd.strafeToPosition(-3, 0.4);    //left for small adjustments by PUSHING IN
        hd.moveToPosition(-5, 0.4);     //backwards for small adjustments in case overshot

        hd.strafeToPosition(40, 1.0); //right to drag stone OUT
    }
}
