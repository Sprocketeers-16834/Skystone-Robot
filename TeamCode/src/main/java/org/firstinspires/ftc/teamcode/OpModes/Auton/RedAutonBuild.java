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

        hd.moveToPosition(-34, 0.2);
        hd.strafeToPosition(29, 0.3);
        hd.moveToPosition(-38,0.2);
        puller.down();
        hd.moveToPosition(10, 0.1);
        hd.moveToPosition(70 , 0.5);
        puller.up();
        hd.strafeToPosition(-120, 0.3);
    }
}
