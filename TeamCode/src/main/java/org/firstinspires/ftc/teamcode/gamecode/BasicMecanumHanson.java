package org.firstinspires.ftc.teamcode.gamecode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.opmodesupport.TeleOpMode;
import org.firstinspires.ftc.teamcode.robots.HansonNightmare;

@TeleOp
public class BasicMecanumHanson extends TeleOpMode {
    HansonNightmare HansonNightmare;

    @Override
    public void initialize() {
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loopOpMode() {

        //Slow Button
        if (joy1.leftTrigger()) {
            float pivot = gamepad1.right_stick_y / 2;
            float horizontal = -gamepad1.right_stick_x / 2;
            float vertical = gamepad1.left_stick_x / 2;
            HansonNightmare.FrontRight.setPower(-pivot + (vertical + horizontal));
            HansonNightmare.BackRight.setPower(-pivot + (vertical - horizontal));
            HansonNightmare.FrontLeft.setPower(pivot + (vertical + horizontal));
            HansonNightmare.BackLeft.setPower(pivot + (vertical - horizontal));

        //Normal Driving
        } else {
            float pivot = gamepad1.right_stick_y;
            float horizontal = -gamepad1.right_stick_x;
            float vertical = gamepad1.left_stick_x;
            HansonNightmare.FrontRight.setPower(-pivot + (vertical + horizontal));
            HansonNightmare.BackRight.setPower(-pivot + (vertical - horizontal));
            HansonNightmare.FrontLeft.setPower(pivot + (vertical + horizontal));
            HansonNightmare.BackLeft.setPower(pivot + (vertical - horizontal));
        }
    }
}