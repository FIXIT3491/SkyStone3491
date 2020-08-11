package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;


@Autonomous(name="IMUAttempt", group="Linear Opmode")
public class IMUAttempt extends LinearOpMode {




    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode() {

        BNO055IMU imu;
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        Orientation angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        telemetry.addData("Status", "Initialized");
        telemetry.addData("angle1", angles.firstAngle);
        telemetry.update();


        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).

        //frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeft");
        //frontRightDrive = hardwareMap.get(DcMotor.class, "frontRight");
       // backLeftDrive = hardwareMap.get(DcMotor.class, "frontLeft");
      //  backRightDrive = hardwareMap.get(DcMotor.class, "frontRight");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();


        // Setup a variable for each drive wheel to save power level for telemetry
        double speed = 1;

        //drives forward for 1 second, then stops and displays an update
        DriveForward(speed, angles.firstAngle);
        sleep(1000);
        DriveReset();
        telemetry.addData("angle1", angles.firstAngle);
        telemetry.update();
        sleep(5000);

        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        float turnValue = Math.abs(angles.firstAngle);

        //turns right for 1 second, then stops and displays an update
        /*TurnRight(speed);

        while (turnValue < 90) {
            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            turnValue = Math.abs(angles.firstAngle);
            sleep(200); //Turn until you almost reach 90deg

            telemetry.addData("angle1", angles.firstAngle);
            telemetry.update();

        }*/
        DriveReset();
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        telemetry.addData("angle1", angles.firstAngle);
        telemetry.update();
        sleep(5000);
    }


    //methods

    private void DriveReset() {
        leftDrive.setPower(0);
        rightDrive.setPower(0);
    }

    public void DriveForward(double speed, float angles){

        telemetry.addData("angle1", angles);
        boolean DriveForward = true;
        leftDrive.setPower(speed);
        rightDrive.setPower(speed);
        while (DriveForward = true){
            if (angles > 2){
                leftDrive.setPower(speed - angles);
            }
            if (angles < -2){
                rightDrive.setPower(speed - angles);
            }
        }

    }

    public void DriveBackward(double speed){
        leftDrive.setPower(-speed);
        rightDrive.setPower(-speed);
    }

    public void TurnLeft(double speed){
        leftDrive.setPower((speed - 0.75)/2);
        rightDrive.setPower(speed/2);
    }

    public void TurnRight(double speed){
        leftDrive.setPower(speed/2);
        rightDrive.setPower(speed/-2);
    }




}
