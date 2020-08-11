package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodesupport.AutoOpMode;
import org.firstinspires.ftc.teamcode.robots.HansonNightmare;

@Autonomous
public class BasicAutoHanson extends AutoOpMode {
    public void runOp() throws InterruptedException {
        HansonNightmare hansonNightmare = new HansonNightmare();

        telemetry.addData("Status", "initialized");
        waitForStart();

        hansonNightmare.DriveForward(0.5);
        sleep(1800);
        hansonNightmare.Stop();

        hansonNightmare.TurnLeft(1);
        sleep(500);
        hansonNightmare.Stop();

        hansonNightmare.DriveBackward(0.7);
        sleep(1800);
        hansonNightmare.Stop();
    }
}
