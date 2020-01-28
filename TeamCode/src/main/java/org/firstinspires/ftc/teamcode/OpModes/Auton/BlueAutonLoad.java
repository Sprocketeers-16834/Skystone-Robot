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
    private final int stone = 15;

    public void runOpMode() {
        waitForStart();
        hd.init(hardwareMap);
        grabber.init(hardwareMap);
        fbar.init(hardwareMap);

        grabber.up();
        fbar.close();

        hd.strafeToPosition(60, 0.6);   //left to approach quarry

        int count = 0;
        boolean flagSS = false;

        while(!flagSS && count<6) {
            if(Math.abs(hd.getDistance()-3) >= 0.3) {       //strafe to make adjustments for distance to stone
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

        hd.moveToPosition(-count*stone - 80, 0.7);  //backwards to pass the line
        grabber.up();

        //second stone
        hd.moveToPosition((count+2)*stone +120,0.7); //forwards to approach next stone
        hd.strafeToPosition(70, 0.7);
        microAdjust();
        ssProcedures();
        hd.moveToPosition(50, 1.0);
        hd.moveToPosition((count+2)*stone+160, 1.0);     //forwards to drop
        grabber.up();
        hd.moveToPosition(-50, 1.0); //backwards to park
    }

    private void microAdjust() {
        telemetry.addData("ADJUSTING", "DISTANCE");
        telemetry.addData("Distance", hd.getDistance());
        double mag = hd.getDistance() - 1;
        hd.strafeToPosition(1*mag, 0.2);
        telemetry.update();
    }

    private void ssProcedures() {
        hd.strafeToPosition(10, 0.5);   //left to push IN skystone
        sleep(500);                      //pause
        telemetry.addData("FOUND", "SKYSTONE");
        grabber.down();

        sleep(500);
        hd.strafeToPosition(3, 0.3);    //left for small adjustments by PUSHING IN
        hd.moveToPosition(-5, 0.3);     //backwards for small adjustments in case overshot

        hd.strafeToPosition(-60, 0.8); //right to drag stone OUT
    }
}
