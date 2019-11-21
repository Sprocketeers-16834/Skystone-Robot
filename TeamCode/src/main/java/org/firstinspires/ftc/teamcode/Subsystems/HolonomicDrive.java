package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

public class HolonomicDrive {
    private DcMotor drive1;
    private DcMotor drive2;
    private DcMotor drive3;
    private DcMotor drive4;
    private BNO055IMU imu;

    public void init(HardwareMap hwMap) {
        drive1 = hwMap.get(DcMotor.class, "drive1");
        drive1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drive1.setDirection(DcMotor.Direction.REVERSE);

        drive2 = hwMap.get(DcMotor.class, "drive2");
        drive2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        drive2.setDirection(DcMotor.Direction.REVERSE);

        drive3 = hwMap.get(DcMotor.class, "drive3");
        drive3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        drive4 = hwMap.get(DcMotor.class, "drive4");
        drive4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        //parameters.calibrationDataFile = "GyroCal.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        //
        imu = hwMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public void drive(double x, double y){
        double angle = Math.atan(y/x);
        angle+=45;
        double straightPower = Math.sin(angle);
        double sidePower = Math.cos(angle);
        if ( x < 0 ) {
            straightPower *= -1;
            sidePower *= -1;
        }
        drive1.setPower(sidePower);
        drive2.setPower(straightPower);
        drive3.setPower(sidePower);
        drive4.setPower(straightPower);
    }

    public void spin(double turn) {
        turn*=0.8;
        drive1.setPower(turn);
        drive2.setPower(turn);
        drive3.setPower(turn);
        drive4.setPower(turn);
    }
}
