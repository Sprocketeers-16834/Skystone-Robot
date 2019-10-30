package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {
    private DcMotor leftMotor;
    private DcMotor rightMotor;

    int cpr = 28;
    double wheelDiameter = 4;


    public void init(HardwareMap hwMap) {
        leftMotor = hwMap.get(DcMotor.class, "leftMotor");
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightMotor = hwMap.get(DcMotor.class, "leftMotor");
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);


    }

    public void arcade(double power, double turn) {
        leftMotor.setPower(power - turn);
        rightMotor.setPower(power + turn);
    }

    public void tank(double left, double right) {
        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }

    //Autonomous methods
    void moveInches(double inches, double speed) {
        int startLeft = leftMotor.getCurrentPosition();
        int startRight = rightMotor.getCurrentPosition();

        //dont think im converting right but im lazy to fix
        leftMotor.setTargetPosition((int)(cpr/(Math.PI*wheelDiameter) * inches) - startLeft);
        rightMotor.setTargetPosition((int)(cpr/(Math.PI*wheelDiameter) * inches) - startRight);

        leftMotor.setPower(speed);
        rightMotor.setPower(speed);
    }

    public void turnAngle(double angle, double speed) {
        int ticksPer10Deg = 20; //CHANGE THISSSS
        int numOfTicks = (int)((ticksPer10Deg*angle)/8.2); //CHANGE THISSSS

        //true means CW
        boolean direction = true;
        if(angle<0 || angle>180) {
            direction = false;
        }

        if(direction==true){
            int multR=-1;
            int multL=-1;
        } else if(direction==false){
            int multR=1;
            int multL=1;
        }

        int angleTurned = 0;
        int rightStart = rightMotor.getCurrentPosition();
        int leftStart = leftMotor.getCurrentPosition();

        while(angleTurned <= numOfTicks) {  //??

        }


        leftMotor.setPower(0);
        rightMotor.setPower(0);
    }

//    void turnAngle(int speed, int angle, bool clockwise){ //numbers require fine-tuning by testing the encoder values
//        SlowDown = .8 * numOfTicks;
//        AngleTurned = 0;
//        encvalLD = abs(SensorValue[encLeftDrive]);
//        encvalRD = abs(SensorValue[encRightDrive]);
//        while(AngleTurned <= TATicks)
//        {
//            encvalLD = abs(SensorValue[encLeftDrive]);
//            encvalRD = abs(SensorValue[encRightDrive]);
//            AngleTurned = abs(multR * encvalRD);
//            if (AngleTurned < SlowDown)
//                realSpeed = speed;
//            else
//                realSpeed = .75 * speed;
//            RightSpeed = multR * realSpeed;
//            LeftSpeed = multL * realSpeed * SpeedCorr;
//            motor[FRWheel]= RightSpeed; //turning
//            motor[RRWheel]= RightSpeed;
//            motor[FLWheel]= LeftSpeed;
//            motor[RLWheel]= LeftSpeed;
//            if(AngleTurned >= TATicks)
//            {
//                motor[FRWheel] = 0;
//                motor[RRWheel] = 0;
//                motor[FLWheel] = 0;
//                motor[RLWheel] = 0;
//            }
//        }
//        motor[FRWheel]=0;	//just in case stuff happens and motors don't stop
//        motor[RRWheel]=0;
//        motor[FLWheel]=0;
//        motor[RLWheel]=0;
//    }


    private double angleToTicks(double angle) {
        int ticks = 0;
        return ticks;
    }
}
