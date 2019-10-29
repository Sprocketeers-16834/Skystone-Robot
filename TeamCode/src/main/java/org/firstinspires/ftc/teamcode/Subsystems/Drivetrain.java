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
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        rightMotor = hwMap.get(DcMotor.class, "leftMotor");
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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

    public void turnAngle(double angle, double speed){

        leftMotor.setPower(speed);
        rightMotor.setPower(-speed);
    }

    private double angleToTicks(double angle) {
        int ticks = 0;
        return ticks;
    }
}
