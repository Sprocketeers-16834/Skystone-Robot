import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;
import org.firstinspires.ftc.teamcode.Subsystems.Puller;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class BlueAutonBuild extends LinearOpMode {
    private HolonomicDrive hd = new HolonomicDrive();
    private Puller puller = new Puller();

    public void runOpMode(){
        waitForStart();
        hd.init(hardwareMap);
        puller.init(hardwareMap);

        puller.up();
        hd.moveToPosition(-34, 0.5);    //backwards
        hd.strafeToPosition(-35, 0.5);  //right
        hd.moveToPosition(-38,0.5);     //backwards
        puller.down();
        hd.strafeToPosition(-10, 0.3);  //right
        hd.moveToPosition(10, 0.2);     //forward slow
        hd.moveToPosition(80, 0.3);    //forward zoom
        puller.up();
        hd.strafeToPosition(50, 0.3);   //left towards park
        hd.moveToPosition(10, 0.4);     //forwards if to wall

//        hd.moveToPosition(-50, 0.4);     //backwards if near bridge, comment out if near wall
        hd.strafeToPosition(80, 0.6);  //left to park
        hd.moveToPosition(10, 0.5);
    }
}