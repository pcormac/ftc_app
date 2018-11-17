package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "Auto: Sample Crater", group = "Crater Start")
public class AutoSampleCrater extends AutoFunctions {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void declareDevices() throws InterruptedException {
        super.declareDevices();
    }

    public void runOpMode() throws InterruptedException {

        declareMap();

        waitForStart();

        moveElevatorUsingEncoder(1, 500);

        checkDogeCVForTime(5);

        telemetry.addData("AutoStatus: ", "Starting back up");
        telemetry.update();

        if (gold.equalsIgnoreCase("Left")) {
            turnUsingEncoders("Left", 100);
            runUsingEncoders(-.5, -.5,300);
            turnUsingEncoders("Right", 100);
            runUsingEncoders(-.5, -.5,1000);
        } else if (gold.equalsIgnoreCase("Middle")) {
            turnUsingEncoders("Right", 35);
            runUsingEncoders(-.5, -.5,1000);
        } else if (gold.equalsIgnoreCase("Right")) {
            turnUsingEncoders("Right", 200);
            runUsingEncoders(-.5, -.5,1200);
            turnUsingEncoders("Left", 100);
            runUsingEncoders(-.5, -.5,300);
        } else {
            // mineral was not found, default to right
            turnUsingEncoders("Right", 200);
            runUsingEncoders(-.5, -.5,1200);
            turnUsingEncoders("Left", 100);
            runUsingEncoders(-.5, -.5,300);
        }


        telemetry.addData("AutoStatus: ", "Dumping marker");
        telemetry.update();
        tail.setPosition(tail_DOWN);
        sleep(500);
        tail.setPosition(tail_UP);

        telemetry.addData("AutoStatus: ", "Done");
        telemetry.update();
    }
}
