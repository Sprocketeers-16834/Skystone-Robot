package org.firstinspires.ftc.teamcode.OpModes.Auton;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Lift;
import org.firstinspires.ftc.teamcode.Subsystems.Pincer;

@Autonomous
public class EmmaAutonRed extends LinearOpMode {
    private Drivetrain drivetrain = new Drivetrain();
    private Lift lift = new Lift();
    private Pincer pincer= new Pincer();

    int cpr = 28;

    public void runOpMode() {
        //list of commands :(
    }
}


