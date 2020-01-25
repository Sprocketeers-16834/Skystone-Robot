package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Grabber {
    private Servo grabber;
    private ColorSensor color;

    public void init(HardwareMap hwMap) {
        grabber = hwMap.get(Servo.class, "grabber");
        color = hwMap.get(ColorSensor.class, "color");
        color.enableLed(false);
    }

    public double getRed() {
        return color.red();
    }
    public double getGreen() {
        return color.green();
    }
    public double getBlue() {
        return color.blue();
    }
    public double getAlpha() { return color.alpha();}

    public double getC() {
        double R = color.red()/65025;

        double C = (1-R-getK()) / (1-getK());
        return C;
    }

    public double getM() {
        double G = color.green()/65025;

        double M = (1-G-getK()) / (1-getK());
        return M;
    }

    public double getY() {
        double B = color.blue()/65025;

        double Y = (1-B-getK()) / (1-getK());
        return Y;
    }

    public double getK() {
        double R = color.red()/65025;
        double G = color.green()/65025;
        double B = color.blue()/65025;

        double K = 1-Math.max(R, Math.max(G, B));
        return K;
    }

    public double getBR() {
        return getBlue()/getRed();
    }

    public double getPosition() {
        return grabber.getPosition();
    }

    public void down() {
        grabber.setPosition(0.6);
    }

    public void up() {
        grabber.setPosition(0.05);
    }

//    Autonomous stuff
    public boolean isSkystone() {
        double br = getBlue()/getRed();
        if(br>0.6) {
            return true;
        }
        return false;
    }
}
