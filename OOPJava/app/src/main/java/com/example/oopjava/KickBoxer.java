package com.example.oopjava;

public class KickBoxer extends Boxer {

  private   int kickSpeed = 50;
  private   int kickPower = 70;


  public int getKickSpeed() {
    return kickSpeed;
  }

  public void setKickSpeed(int kickSpeed) {
    this.kickSpeed = kickSpeed;
  }

  public int getKickPower() {
    return kickPower;
  }

  public void setKickPower(int kickPower) {
    this.kickPower = kickPower;
  }



  public KickBoxer(int numberOfGloves, int kickSpeed, int kickPower, int punchSpeed, int punchPower) {

  super(numberOfGloves, punchSpeed, punchPower);
    this.kickSpeed = kickSpeed;
    this.kickPower = kickPower;
   // this.punchSpeed = punchSpeed;
   // this.punchPower = punchPower;

    setPunchSpeed(punchSpeed);
    setPunchPower(punchPower);

  }
}
