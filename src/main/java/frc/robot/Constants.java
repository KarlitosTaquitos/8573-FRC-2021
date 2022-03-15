// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    // joysticks
    public class Controls {
        public final static int P1 = 0;
        public final static int P2 = 1;
        public final static int POV = 0;
        public final static int R_BUMPER = 5;
        public final static int L_BUMPER = 6;
        public final static int TRIGGER_1 = 1;
        public final static int THUMB = 2;
        public final static int A = 1;
        public final static int B = 2;
        public final static int XCONTROL = 3;
        public final static int YCONTROL = 4;
        public final static int L_STICK = 9;
        public final static int P1_3 = 3;
        public final static int P1_4 = 4;
        public final static int P1_5 = 5;
        public final static int P1_6 = 6;
        
        public final static int R_TRIGGER = 3;
        public final static int L_TRIGGER = 2;
    }

    // drivetrain motors => switching from VictorSP to CAN
    public class DriveMotors {
        public final static int FL = 7;
        public final static int FR = 1;
        public final static int BL = 2;
        public final static int BR = 4;
    }

    // sparkmax motors
    public class Motors {
        public final static int CLIMB_1 = 10;
        public final static int CLIMB_2 = 11;
        public final static int ELEVATOR = 9;
        public final static int INTAKE_1 = 6;
        public final static int INTAKE_2 = 5;
        public final static int SHOOT = 3;
        public final static int PULLEY = 8;
    }

    // axes
    public class Axes {
        public final static int X = 0;
        public final static int Y = 1;
    }

    // LED PWM "motors"
    public class LEDS {
        public final static int LED_1 = 0;
    }
    

    // mulitpliers
    public class Multipliers {
        public final static double POWER_MULT = 1;
        public final static double EL_MULT = .4;
    }
}
