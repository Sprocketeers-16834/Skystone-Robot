package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drivetrain {
    private DcMotor leftMotorF;
    private DcMotor leftMotorB;
    private DcMotor rightMotorF;
    private DcMotor rightMotorB;

    int cpr = 28;
    double wheelDiameter = 4;


    public void init(HardwareMap hwMap) {
        leftMotorF = hwMap.get(DcMotor.class, "leftMotorF");
        leftMotorF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotorB = hwMap.get(DcMotor.class, "leftMotorB");
        leftMotorB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightMotorF = hwMap.get(DcMotor.class, "rightMotorF");
        rightMotorF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorF.setDirection(DcMotor.Direction.REVERSE);

        rightMotorB = hwMap.get(DcMotor.class, "rightMotorB");
        rightMotorB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorB.setDirection(DcMotor.Direction.REVERSE);

    }

    public void arcade(double power, double turn) {
        leftMotorF.setPower(power - turn);
        leftMotorB.setPower(power - turn);

        rightMotorF.setPower(power + turn);
        rightMotorB.setPower(power + turn);
    }

    public void tank(double left, double right) {

        leftMotorF.setPower(left);
        leftMotorB.setPower(left);
        rightMotorF.setPower(right);
        rightMotorB.setPower(right);

    }

    public void single(double power, double     turn) {
        leftMotorF.setPower(power - turn);
        leftMotorB.setPower(power - turn);
        rightMotorF.setPower(power + turn);
        rightMotorB.setPower(power + turn);

    }

    //Autonomous methods

    public void move(int counts, double power) {
        rightMotorF.setTargetPosition(counts);
        rightMotorF.setPower(power);

        rightMotorB.setTargetPosition(counts);
        rightMotorB.setPower(power);

        leftMotorF.setTargetPosition(counts);
        leftMotorF.setPower(power);

        leftMotorB.setTargetPosition(counts);
        leftMotorB.setPower(power);
    }
    public void moveInches(double inches, double speed) {
        int startLeft = leftMotorF.getCurrentPosition();
        int startRight = rightMotorF.getCurrentPosition();

        //dont think im converting right but im lazy to fix
        leftMotorF.setTargetPosition((int)(cpr/(Math.PI*wheelDiameter) * inches) - startLeft);
        rightMotorF.setTargetPosition((int)(cpr/(Math.PI*wheelDiameter) * inches) - startRight);

        leftMotorF.setPower(speed);
        rightMotorF.setPower(speed);
    }

//    public void turn90(double power) {
//        rightMotorF.setPower();
//    }

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
        int rightStart = rightMotorF.getCurrentPosition();
        int leftStart = leftMotorF.getCurrentPosition();

        while(angleTurned <= numOfTicks) {  //??

        }


        leftMotorF.setPower(0);
        rightMotorF.setPower(0);
    }

    private double angleToTicks(double angle) {
        int ticks = 0;
        return ticks;
    }
}
