package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.HansonNightmare;

@TeleOp
public class BasicTeleOpHanson extends TeleOpMode {
    HansonNightmare HansonNightmare;

    @Override
    public void initialize() {
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loopOpMode() {
        if (joy1.leftTrigger()){
            telemetry.addData("Status", "Reverse");
            HansonNightmare.driveR(gamepad1.left_stick_y*0.9);
            HansonNightmare.driveL(gamepad1.right_stick_y*0.9);
        }

        if (!joy1.leftTrigger()) {
            telemetry.addData("Status", "Normal Driving");
            HansonNightmare.driveL(-gamepad1.left_stick_y);
            HansonNightmare.driveR(-gamepad1.right_stick_y);
        }
    }
}
