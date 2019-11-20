package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

//negative means cw for arc

public class Drivetrain {
    private DcMotor leftMotorF;
    private DcMotor leftMotorB;
    private DcMotor rightMotorF;
    private DcMotor rightMotorB;
    private BNO055IMU imu;

    Double width = 16.0; //inches
    Integer cpr = 28; //counts per rotation
    Integer gearratio = 40;
    Double diameter = 4.125;
    Double cpi = (cpr * gearratio)/(Math.PI * diameter); //counts per inch -> counts per rotation / circumference
    Double bias = 1.0;
    Double arcBias = 0.0;//Not recommended

    Double conversion = cpi * bias;
    Boolean exit = false;

    Orientation angles;
    Acceleration gravity;

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

    public void arcade(double power, double turn) {
        setLeft(power-turn);
        setRight(power+turn);
    }

    public void tank(double left, double right) {
        if ( Math.abs(left) > 0.1 )
            setLeft(left);
        if ( Math.abs(right) > 0.1 )
            setRight(right);
        else {
            setLeft(0);
            setRight(0);
        }
    }

    private void setLeft(double power) {
        leftMotorF.setPower(power);
        leftMotorB.setPower(power);
    }

    private void setRight(double power) {
        rightMotorF.setPower(power);
        rightMotorB.setPower(power);
    }

    private void setTargetLeft(int position) {
        leftMotorF.setTargetPosition(position);
        leftMotorB.setTargetPosition(position);
    }

    private void setTargetRight(int position) {
        rightMotorF.setTargetPosition(position);
        rightMotorB.setTargetPosition(position);
    }

    private int getPositionLeft() {
        return (leftMotorF.getCurrentPosition() + leftMotorB.getCurrentPosition())/2;
    }

    private int getPositionRight() {
        return (rightMotorF.getCurrentPosition() + rightMotorB.getCurrentPosition())/2;
    }

    //Autonomous methods
    public void moveToPosition(double inches, double speed){
        inches*=-1;

        leftMotorF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotorF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMotorB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotorF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotorB.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        if (inches < 5) {
            int move = (int) (Math.round(inches * conversion));

            setTargetLeft(getPositionLeft() + move);
            setTargetRight(getPositionRight() + move);

            setLeft(speed);
            setRight(speed);

            while (leftMotorF.isBusy() && rightMotorF.isBusy()) {}
            setLeft(0);
            setRight(0);
        }
        else {
            int move1 = (int)(Math.round((inches - 5) * conversion));
            int movel2 = getPositionLeft() + (int)(Math.round(inches * conversion));
            int mover2 = getPositionRight() + (int)(Math.round(inches * conversion));

            setTargetLeft(getPositionLeft() + move1);
            setTargetRight(getPositionRight() + move1);

            setLeft(speed);
            setRight(speed);

            while (leftMotorF.isBusy() && rightMotorF.isBusy()) {}

            setTargetLeft(movel2);
            setTargetRight(mover2);

            setLeft(.1);
            setRight(.1);

            while (leftMotorF.isBusy() && rightMotorF.isBusy()) {}
            setLeft(0);
            setRight(0);
        }
        return;
    }

    public void arc(Double angle, Double length, Double speed){
        //\frac{c*sin*(90-b)}{\sin2b}
        Double radius = ((length + arcBias) * Math.sin(Math.toRadians(90-angle)))/(Math.sin(Math.toRadians(2 * angle)));

        Double rightMotor;
        Double leftMotor;
        rightMotor = 2 * Math.PI * (radius - (width / 2)) * (angle / 180);
        leftMotor = 2 * Math.PI * (radius + (width / 2)) * (angle / 180);

        int rightd = (int) (Math.round(rightMotor * conversion));
        int leftd = (int) (Math.round(leftMotor * conversion));


        leftMotorF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftMotorB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorF.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotorB.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotorF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftMotorB.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotorF.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotorB.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        setTargetRight(getPositionRight() + rightd);
        setTargetLeft(getPositionLeft() + leftd);

        setLeft(speed);
        setRight((rightMotor / leftMotor) * speed);

        while (leftMotorF.isBusy() || rightMotorF.isBusy()){
            if (exit){
                setRight(0);
                setLeft(0);
                return;
            }
        }
        setRight(0);
        setLeft(0);
        return;
    }

    /*
 This function uses the Expansion Hub IMU Integrated Gyro to turn a precise number of degrees (+/- 5).
 Degrees should always be positive, make speedDirection negative to turn left.
  */
    public void turnWithGyro(double degrees, double speedDirection){
        angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        double yaw = -angles.firstAngle;//make this negative

        double first;
        double second;

        if (speedDirection > 0){//set target positions

            if (degrees > 20){
                first = (degrees - 20) + devertify(yaw);
                second = degrees + devertify(yaw);
            }else{
                first = devertify(yaw);
                second = degrees + devertify(yaw);
            }

        }else {
            if (degrees > 20) {
                first = devertify(-(degrees - 20) + devertify(yaw));
                second = devertify(-degrees + devertify(yaw));
            } else {
                first = devertify(yaw);
                second = devertify(-degrees + devertify(yaw));
            }
        }

        Double firsta = convertify(first - 5);//175
        Double firstb = convertify(first + 5);//-175
        //
        turnWithEncoder(speedDirection);
        //
        if (Math.abs(firsta - firstb) < 11) {
            while (!(firsta < yaw && yaw < firstb)) {//within range?
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
                yaw = -angles.firstAngle;
            }
        } else{
            //
            while (!((firsta < yaw && yaw < 180) || (-180 < yaw && yaw < firstb))) {//within range?
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
                yaw = -angles.firstAngle;
            }
        }
        //
        Double seconda = convertify(second - 5);//175
        Double secondb = convertify(second + 5);//-175
        //
        turnWithEncoder(speedDirection / 3);
        //
        if (Math.abs(seconda - secondb) < 11) {
            while (!(seconda < yaw && yaw < secondb)) {//within range?
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
                yaw = -angles.firstAngle;;
            }
        }else {
            while (!((seconda < yaw && yaw < 180) || (-180 < yaw && yaw < secondb))) {//within range?
                angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity = imu.getGravity();
                yaw = -angles.firstAngle;
            }
        }
        //</editor-fold>
        //
        setLeft(0);
        setRight(0);
    }

    public double devertify(double degrees){
        if (degrees < 0){
            degrees = degrees + 360;
        }
        return degrees;
    }
    public double convertify(double degrees){
        if (degrees > 179){
            degrees = -(360 - degrees);
        } else if(degrees < -180){
            degrees = 360 + degrees;
        } else if(degrees > 360){
            degrees = degrees - 360;
        }
        return degrees;
    }
    //
    /*
    This function is called at the beginning of the program to activate
    the IMU Integrated Gyro.
     */


    public void turnWithEncoder(double input){
        leftMotorF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotorB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorF.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotorB.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //
        setLeft(input);
        setRight(-input);
    }

}
