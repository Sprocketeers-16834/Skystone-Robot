package org.firstinspires.ftc.teamcode.OpModes.Teleop;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import java.awt.Color;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.Grabber;
import org.firstinspires.ftc.teamcode.Subsystems.HolonomicDrive;

@TeleOp
public class ColorTest extends OpMode {
    private Grabber grabber = new Grabber();
    private HolonomicDrive hd = new HolonomicDrive();
//    private static final double[] targetY = {0.6, 0.5, 3.5};
//    private static final double[] targetR = {1.2, 0.4, 2.4};
//    private static final double[] targetG = {0.5, 1.2, 2.3};
//    private static final double[] targetB = {0.4, 2.6, 1.5};

    private static final double maxVal = 100000;
    private static final double[] yRange = {79, 98};
    private static final double[] rRange = {25, 50};
    private static final double[] gRange = {114, 140};
    private static final double[] bRange = {148, 196};

    public void init() {
        grabber.init(hardwareMap);
        hd.init(hardwareMap);
    }

    private String identifyColor(double r, double g, double b) {
        double hue = hue(r, g, b);
        if(yRange[0] < hue && hue < yRange[1])
            return "yellow";
        else if(rRange[0] < hue && hue < rRange[1])
            return "red";
        else if(gRange[0] < hue && hue < gRange[1])
            return "green";
        else if(bRange[0] < hue && hue < bRange[1])
            return "blue";
        else
            return "unknown";
    }

    private double hue(double r, double g, double b) {
        r /= maxVal;
        g /= maxVal;
        b /= maxVal;

        double cMax = Math.max(r, Math.max(g, b));
        double cMin = Math.min(r, Math.min(g, b));
        double chroma = cMax - cMin;
        double hue = 60;
        if(cMax == r) {
            double val = ((g - b) / chroma);
            if(val > 0)
                hue *= val;
            else
                hue *= val + 6;
        } else if(cMax == g) {
            hue *= ((b - r) / chroma) + 2;
        } else if(cMax == b) {
            hue *= ((r - g) / chroma) + 4;
        } else {
            hue = 0;
        }
        return hue;
    }

    public void loop() {
        double r = grabber.getRed();
        double g = grabber.getGreen();
        double b = grabber.getBlue();

//        telemetry.addData("hue:", hue(r, g, b));
//        telemetry.addData("color:", identifyColor(r, g, b));
        telemetry.addData("br", grabber.getBR());
        telemetry.update();
    }
}
