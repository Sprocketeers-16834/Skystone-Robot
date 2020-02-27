package org.firstinspires.ftc.teamcode.OpModes.Auton;

import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class MoveForward extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();

    public void runOpMode(){
        waitForStart();
        hd.init(hardwareMap);

        hd.moveToPosition(30, 0.5);
    }
}