package org.firstinspires.ftc.teamcode.OpModes.Auton;

import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class RedAutonBuild extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Puller puller = new Puller();

    public void runOpMode(){
        waitForStart();
        hd.init(hardwareMap);
        puller.init(hardwareMap);

        puller.up();
        hd.moveToPosition(-34, 0.5);    //backwards
        hd.strafeToPosition(-29, 0.5);   //left
        hd.moveToPosition(-38,0.5);     //backwards
        puller.down();
        sleep(1000);
        hd.moveToPosition(10, 0.2);     //forward slow
        hd.moveToPosition(80, 0.3);    //forward zoom
        puller.up();
        hd.strafeToPosition(50, 0.3);  //right towards park
//        hd.moveToPosition(-50, 0.4);     //backwards if near bridge
        hd.strafeToPosition(80, 0.6); //right to park
        hd.moveToPosition(10, 0.5);
    }
}
