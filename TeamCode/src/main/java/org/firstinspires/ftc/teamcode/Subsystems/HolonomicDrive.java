package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HolonomicDrive {
    private DcMotor leftMotorF;
    private DcMotor leftMotorB;
    private DcMotor rightMotorF;
    private DcMotor rightMotorB;
    private BNO055IMU imu;

    public HolonomicDrive(HardwareMap hwMap) {
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

    public void drive(double x, double y, double z) {
        rightMotorF.setPower(y+x-z);
        leftMotorF.setPower(y-x+z);
        rightMotorB.setPower(y-x-z);
        leftMotorB.setPower(y+x+z);
    }
}
