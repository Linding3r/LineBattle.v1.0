package com.company;

public class Player {

  int playerPower = 2500;
  int playerSoldier = 25;
  int playerLocation = 0;
  final int playerBombLocation = 20;
  int attackPower;
  final int retreatPoints = 250;

  public Player(int playerPower, int playerSoldier, int playerLocation, int attackPower) {
    this.playerPower = playerPower;
    this.playerSoldier = playerSoldier;
    this.playerLocation = playerLocation;
    this.attackPower = attackPower;
  }

  public Player() {
  }

  public int getPlayerPower() {
    return playerPower;
  }

  public void setPlayerPower(int playerPower) {
    this.playerPower = playerPower;
  }

  public int getPlayerSoldier() {
    return playerSoldier;
  }

  public void setPlayerSoldier(int playerSoldier) {
    this.playerSoldier = playerSoldier;
  }

  public int getPlayerLocation() {
    return playerLocation;
  }

  public void setPlayerLocation(int playerLocation) {
    this.playerLocation = playerLocation;
  }

  public int getPlayerBombLocation() {
    return playerBombLocation;
  }

  public int getAttackPower() {
    return attackPower;
  }

  public void setAttackPower(int attackPower) {
    this.attackPower = attackPower;
  }

  public int getRetreatPoints() {
    return retreatPoints;
  }
}
