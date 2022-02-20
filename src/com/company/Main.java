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
  final int dead = 0;
  final int enemyBombLocation = 0;
  final int playerBombLocation = 20;
  final int retreatPoints = 250;
  int attackPower;
  int diceNumber;

  //Game Status Display for debugging. Remove when playing
  public void gameStatus() {
    System.out.printf("\n\n\u001B[31mENEMY POWER:\t\t %5d", enemyPower);
    System.out.printf("\nENEMY SOLDIER(s):\t %5d", enemySoldier);
    System.out.printf("\nENEMY LOCATION:\t\t %5d", enemyLocation);
    System.out.printf("\n\n\u001B[32mPLAYER POWER:\t\t %5d", playerPower);
    System.out.printf("\n\u001B[32mPLAYER SOLDIER(s):\t %5d", playerSoldier);
    System.out.printf("\n\u001B[32mPLAYER LOCATION:\t %5d\u001B[0m", playerLocation);
  }

  //Enemy eliminating player solders method
  public void playerSoldierDeduct() {
    int distance = playerLocation - enemyLocation;
    switch (distance) {
      case -5:
        System.out.println("The enemy attacked and killed 1 of your soldiers");
        playerSoldier -= 1;
        break;
      case -4:
        System.out.println("The enemy attacked and killed 2 of your soldiers");
        playerSoldier -= 2;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case -3:
        System.out.println("The enemy attacked and killed 3 of your soldiers");
        playerSoldier -= 3;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case -2:
        System.out.println("The enemy attacked and killed 4 of your soldiers");
        playerSoldier -= 4;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case -1:
        System.out.println("The enemy attacked and killed 5 of your soldiers");
        playerSoldier -= 5;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case 0:
        System.out.println("The enemy attacked and killed 6 of your soldiers");
        playerSoldier -= 6;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case 1:
        System.out.println("The enemy attacked and killed 5 of your soldiers");
        playerSoldier -= 5;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case 2:
        System.out.println("The enemy attacked and killed 4 of your soldiers");
        playerSoldier -= 4;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case 3:
        System.out.println("The enemy attacked and killed 3 of your soldiers");
        playerSoldier -= 3;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case 4:
        System.out.println("The enemy attacked and killed 2 of your soldiers");
        playerSoldier -= 2;
        if (playerSoldier < 0) {
          playerSoldier = 0;
        }
        break;
      case 5:
        System.out.println("The enemy attacked and killed 1 of your soldiers");
        playerSoldier -= 1;
        break;
      default:
        System.out.println("The enemy attacked but was too far away to hit your soldiers!");
    }
  }

  //Player eliminating enemy soldiers method
  public void enemySoldierDeduct() {
    int distance = playerLocation - enemyLocation;
    switch (distance) {
      case -5:
        System.out.println("It was a hit. 1 enemy soldier was killed!");
        enemySoldier -= 1;
        break;
      case -4:
        System.out.println("It was a hit. 2 enemy soldier was killed!");
        enemySoldier -= 2;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case -3:
        System.out.println("It was a hit. 3 enemy soldier was killed!");
        enemySoldier -= 3;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case -2:
        System.out.println("It was a hit. 4 enemy soldier was killed!");
        enemySoldier -= 4;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case -1:
        System.out.println("It was a hit. 5 enemy soldier was killed!");
        enemySoldier -= 5;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case 0:
        System.out.println("It was a hit. 6 enemy soldier was killed!");
        enemySoldier -= 6;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case 1:
        System.out.println("It was a hit. 5 enemy soldier was killed!");
        enemySoldier -= 5;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case 2:
        System.out.println("It was a hit. 4 enemy soldier was killed!");
        enemySoldier -= 4;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case 3:
        System.out.println("It was a hit. 3 enemy soldier was killed!");
        enemySoldier -= 3;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case 4:
        System.out.println("It was a hit. 2 enemy soldier was killed!");
        enemySoldier -= 2;
        if (enemySoldier < 0) {
          enemySoldier = 0;
        }
        break;
      case 5:
        System.out.println("It was a hit. 1 enemy soldier was killed!");
        enemySoldier -= 1;
        break;
      default:
        System.out.println("That was a miss! You need to get closer to the enemy!");
    }
  }

  //Win by killing all soldiers
  public boolean winAllSoldiersKilled() {
    if (playerSoldier == dead || enemySoldier == dead) {
      return true;
    } else
      return false;
  }

  //Win by reaching the enemies base
  public boolean winReachEnemyBase() {
    if ((playerLocation == playerBombLocation) || (enemyLocation == enemyBombLocation)) {
      return true;
    } else
      return false;
  }

  //Player Scout
  public void scoutAlert() {
    int distance = playerLocation - enemyLocation;
    switch (distance) {
      case -2:
        System.out.println("\n\nYour scout has detected movement.\nThe enemy is 2 tiles in front of you!");
        break;
      case -1:
        System.out.println("\n\nYour scout has detected movement.\nThe enemy is right in front of you!");
        break;
      case 0:
        System.out.println("\n\nThe enemy is on the same tile as you!! You better attack now!");
        break;
      case 1:
        System.out.println("\n\nYour scout has detected movement.\nThe enemy is right behind you!");
        break;
      case 2:
        System.out.println("\n\nYour scout has detected movement.\nThe enemy is 2 tiles behind you!");
        break;
      case 3:
        System.out.println("\n\nYour scout has detected movement.\nThe enemy is 3 tiles behind you!");
        break;
      default:
    }
  }

  //Player Location on the board
  public int playerBoard(int move) {
    playerLocation += (move);
    if (playerLocation > playerBombLocation) {
      playerLocation = playerBombLocation;
    } else if (playerLocation < enemyBombLocation) {
      playerLocation = enemyBombLocation;
    }
    return playerLocation;
  }

  //Enemy Location on the board
  public int enemyBoard(int move) {
    enemyLocation -= (move);
    if (enemyLocation < enemyBombLocation) {
      enemyLocation = enemyBombLocation;
    } else if (enemyLocation > playerBombLocation) {
      enemyLocation = playerBombLocation;
    }
    return enemyLocation;
  }

  //Enemy attack Method with deducting attack power
  public int enemyAttack() {
    attackPower = attackDamage();
    enemyPower = enemyPower - attackPower;
    if (enemyPower < 0) {
      enemyPower = dead;
    }
    playerSoldierDeduct();
    return enemyPower;
  }

  //Player attack Method with deducting attack power
  public int playerAttack() {
    attackPower = attackDamage();
    playerPower = playerPower - attackPower;
    if (playerPower < dead) {
      playerPower = dead;
    }
    enemySoldierDeduct();
    System.out.println("You have used " + attackPower + " attack power!");
    System.out.println("You have " + playerPower + " attack power left!");
    return playerPower;
  }

  //Planting bomb method to win the game
  public void playerBombPlanting() {
    System.out.println("\nYou have reached the enemy's base!");
    System.out.println("Place the Bomb and detonate it to win the game.");
    pressEnter();
    sc.nextLine();
    System.out.println("The Bomb has exploded\n\u001B[32mYou have won the game!\u001B[0m");
  }

  //Randomizer where you input either 2,3,6 depending on how many outcomes you want
  public int dice(int max) {
    diceNumber = (int) (Math.random() * max + 1);
    return diceNumber;
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

  //Make a "Press Enter to Continue"
  public void pressEnter() {
    System.out.println("Press \"ENTER\" to continue.");
    sc.nextLine();

  }

  //Player move
  public void playerMove() {
    //If player is at enemy base get option to place bomb to win the game
    System.out.println("\n\nChose one of the following moves:");
    System.out.println("1: Forward");
    System.out.println("2: Retreat");
    System.out.println("3: Attack");
    int move = sc.nextInt();
    switch (move) {
      case 3:
        if (playerPower == dead) {
          System.out.println("You have no more Attack Power! You will need to retreat to gain new Attack Power!");
          System.out.println("Try with another move.");
          playerMove();
        } else {
          playerAttack();
        }
        break;
      case 2:
        if (playerLocation == enemyBombLocation) {
          System.out.println("You are can't move further back than your base!");
          System.out.println("Please chose a different move!");
          playerMove();
        } else {
          int steps = backwards();
          playerBoard(steps);
          playerPower += retreatPoints;
          System.out.println("You have moved " + -steps + " tiles back!");
          System.out.println("You are now on tile: " + playerLocation);
        }
        break;
      case 1:
        int steps = forward();
        playerBoard(steps);
        System.out.println("You have moved " + steps + " tiles forward!");
        System.out.println("You are now on tile: " + playerLocation);
        break;
      default:
        System.out.println("Invalid Input, Please try again");
        playerMove();
    }
  }

  //Enemy move
  public void enemyMove() {
    int move = dice(3);
    int steps;
    switch (move) {
      case 1:
        if (enemyPower == dead) {
          enemyMove();
        } else {
          enemyAttack();
        }
        break;
      case 2:
        if (enemyLocation == playerBombLocation) {
          enemyMove();
        } else {
          steps = backwards();
          enemyBoard(steps);
          enemyPower += retreatPoints;
          System.out.println("The enemy retreated!");
        }
        break;
      case 3:
        steps = forward();
        enemyBoard(steps);
        System.out.println("The enemy moved forward!");
    }
  }

  //Starting move where player & enemy throw dice to chose starting point on the map
  public void gameStart() {
    dice(6);
    int playerStartPoint = playerLocation + diceNumber;
    playerLocation += diceNumber;
    System.out.println("You will be starting on tile " + playerStartPoint);
    dice(6);
    enemyLocation -= diceNumber;
  }

  //Run game until someone is dead
  public void game() {
    gameStart();
    while (true) {
      scoutAlert();
      playerMove();
      enemyMove();
      winAllSoldiersKilled();
      winReachEnemyBase();
      //GAME STATUS IF NEEDED FOR DEBUGGING
      //gameStatus();
      if (winReachEnemyBase()) {
        break;
      }
      if (winAllSoldiersKilled()) {
        break;
      }
    }
    if (playerLocation == playerBombLocation) {
      playerBombPlanting();
    } else if (enemyLocation == enemyBombLocation) {
      System.out.println("\n\"\u001B[31GAME OVER\u001B[0m\nThe enemy reached your base and successfully detonated a bomb within!\nBetter luck next time");
    } else if (playerSoldier == dead) {
      System.out.println("\n\u001B[31GAME OVER\u001B[0m\nThe enemy managed to kill all your soldiers!\n Better luck next time");
    } else if (enemySoldier == dead) {
      System.out.println("\n\u001B[32mYOU WON\u001B[0m\nYou killed all enemy soldiers!\nGood job!");
    }
    System.out.println("\n\nThank you for playing LineBattle!");
  }

  public static void main(String[] args) {
    Main prg = new Main();
    System.out.println("Welcome to LineBattle");
    System.out.println("To start with you will throw a dice to decide how far from your base you will start!");
    System.out.println("The enemy will do the same but you will not know where he starts");
    System.out.println("\nGood luck!");
    prg.pressEnter();
    prg.game();
  }
}