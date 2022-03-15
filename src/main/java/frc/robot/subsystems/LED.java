// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
//import edu.wpi.first.wpilibj.AddressableLED;
//import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import frc.robot.Constants;


  public class LED extends SubsystemBase {

  Spark led1;
  Spark led2;
  boolean red;

  /** Creates a new LED. */
  public LED(boolean r) {
    led1 = new Spark(0);
    led2 = new Spark(1);
    red = r;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setAlliance(boolean r) {
    red = r;
  }

  public void allianceColor() {
    if (red) {
      led1.set(-0.17);
      led2.set(-0.17);
    }
    else {
      led1.set(-0.15);
      led2.set(-0.15);
    }
  }

  public void shoot() {
    led1.set(0.13);
    led2.set(0.13);
  }
}
