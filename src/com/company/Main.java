package com.company;

import java.util.Scanner;

public class Main {

  Scanner sc = new Scanner(System.in);
  int playerPower = 2500;
  int enemyPower = 2500;
  int playerSoldier = 25;
  int enemySoldier = 25;
  int playerLocation = 0;
  int enemyLocation = 20;
  final int enemyBombLocation = 0;
  final int playerBombLocation = 20;
  int attackPower;

  //Game Status Display
  public void gameStatus(){
    System.out.printf("\n\nENEMY POWER:\t\t %5d",enemyPower);
    System.out.printf("\nENEMY SOLDIER(s):\t %5d",enemySoldier);
    System.out.printf("\nENEMY LOCATION:\t\t %5d",enemyLocation);
    System.out.printf("\n\nPLAYER POWER:\t\t %5d",playerPower);
    System.out.printf("\nPLAYER SOLDIER(s):\t %5d",playerSoldier);
    System.out.printf("\nPLAYER LOCATION:\t %5d",playerLocation);
  }

  //Player Location on the board
  public int playerBoard(int move){
    playerLocation += (move);
    if (playerLocation > playerBombLocation){
      playerLocation = playerBombLocation;
    } else if (playerLocation < enemyBombLocation){
      playerLocation = enemyBombLocation;
    }
    return playerLocation;
  }

  //Enemy Location on the board
  public int enemyBoard(int move){
    enemyLocation -= (move);
    if (enemyLocation > enemyBombLocation){
      enemyLocation = enemyBombLocation;
    }else if (enemyLocation < playerBombLocation){
      enemyLocation = playerBombLocation;
    }
    return enemyLocation;
  }

  //Enenmy attack Method
  public void enemyAttack() {
    enemyAttackPowerDeduct();
    System.out.println("Enemy has used " + attackPower + " attack power!");
    System.out.println("The enemy has " + enemyPower + " attack power left!");
  }
  //Player attack Method
  public void playerAttack() {
    playerAttackPowerDeduct();
    System.out.println("You have used " + attackPower + " attack power!");
    System.out.println("You have " + playerPower + " attack power left!");
  }

  //Deduct the attack power from Enemy total Power
  public int enemyAttackPowerDeduct() {
    attackPower = attackDamage();
    enemyPower = enemyPower - attackPower;
    return enemyPower;
  }

  //Deduct the attack power from Player total Power
  public int playerAttackPowerDeduct() {
    attackPower = attackDamage();
    playerPower = playerPower - attackPower;
    return playerPower;
  }

  //Planting bomb method to win the game
  public void playerBombPlanting(){
    System.out.println("You have reached the enemy's base!");
    System.out.println("Press 1 to place the Bomb to win the game!");
    int placeBomb;
    do {
      placeBomb = sc.nextInt();
      if(placeBomb != 1){
        System.out.println("Invalid input! Please try again.");
      }
    }while (placeBomb != 1);
    System.out.println("You have placed the bomb!\nTo detonate the bomb and win the game, press 1 again");
    int detonate;
    do {
      detonate = sc.nextInt();
      if (detonate != 1) {
        System.out.println("Invalid input! Please try again.");
      }
    }while (detonate != 1);
    System.out.println("The Bomb has exploded\nYou have won the game!");
  }

  //Dice where you input either 2,3,6 depending on how many outcomes you want
  public int dice(int max) {
    int dice = (int) (Math.random() * max + 1);
    return dice;
  }

  //Attack damage = dice * 100
  public int attackDamage() {
    int attack = dice(6) * 100;
    return attack;
  }

  //Move Forward
  public int forward() {
    int tile = dice(2);
    return tile;
  }

  //Move backwards
  public int backwards() {
    int tile = dice(3) * (-1);
    return tile;
  }

  //Player move
  public void playerMove() {
    //If player is at anemy base get option to place bomb to win the game
    System.out.println("\nChose one of the following moves:");
    System.out.println("1: Foward");
    System.out.println("2: Retreat");
    System.out.println("3: Attack");
    int move = sc.nextInt();
    if (move == 3) {
      if (playerPower <= 0) {
        System.out.println("You have no more Attack Power! You will need to retreat to gain new Attack Power!");
        System.out.println("Try with another move.");
        playerMove();
      } else {
        playerAttack();
      }
    } else if (move == 2) {
      if (playerLocation == enemyBombLocation){
        System.out.println("You are can't move further back than you base!");
        System.out.println("Please chose a different move!");
        playerMove();
      }else {
        int steps = backwards();
        playerBoard(steps);
        System.out.println("You have moved " + steps + " tiles back!");
        System.out.println("You are now on tile: " + playerLocation);
      }
    } else if (move == 1) {
      int steps = forward();
      playerBoard(steps);
      System.out.println("You have moved " + steps + " tiles forward!");
      System.out.println("You are now on tile: " + playerLocation);
    } else {
      System.out.println("Invalid Input, Please try again");
      playerMove();
    }
  }

  //Enemy move
  public void enemyMove() {
    int move = dice(3);
    if (move == 3) {
      if (enemyPower <= 0) {
        playerMove();
      } else {
        enemyAttack();
        System.out.println("Enemy has Attacked you");
      }
    } else if (move == 2) {
      int steps = backwards();
      enemyBoard(steps);
      System.out.println("Enemy has moved " + steps + " tiles back!");
      System.out.println("Enemy is now on tile: " + enemyLocation);
    } else if (move == 1) {
      int steps = forward();
      enemyBoard(steps);
      System.out.println("Enemy has moved " + steps + " tiles forward!");
      System.out.println("Enemy is now on tile: " + enemyLocation);
    }
  }

  //Actual game until someone is dead
  public void game() {
    do {
      playerMove();
      enemyMove();
      gameStatus();
   } while (playerSoldier != 0 || enemySoldier != 0);
  }

  public static void main(String[] args) {

    Main prg = new Main();
    prg.game();


    //Dice 1-6 both for player and computer to chose start placement & Attack during game

    //Dice 1-2 for rest fo the game

    //Chose move (Forward, Retreat, attack, (Bomb))

    //Forward -> Roll Dice (1 or 2)

    //Retreat -> Roll Dice (1 or 2)

    //Attack -> Roll Dice (1 or 2)

    //(If at enemy base Place Bomb)

    //Game Status (Debug)

    //Show Status of Soldiers of player
    //Show Status of Soldiers of computer

    //Show Status of where on the board you are
    //Show Status of where on the board the Computer is

    //Show Status of Attack Power of player
    //Show Status of Attack Power of Computer

    //Show Scout Status when player is within 2 tiles from computer

    //Real Game Status

    //Show Status of Soldiers of player
    //Show Status of where on the board you are
    //Show Status of Attack Power of player
    //Show Scout Status when player is within 2 tiles from computer


  }
}
