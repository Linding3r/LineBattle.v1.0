package com.company;

import java.util.Scanner;

public class Main {

  Scanner sc = new Scanner(System.in);
    int playerPower = 2500;
    int enemyPower = 2500;
    int playerSoldier = 25;
    int enemySoldier = 25;
    int attackPower;

    //The main board

    //Attack Method
    public void attack(){
        playerAttackPowerDeduct();
        System.out.println("You have used " + attackPower + " attack power!");
        System.out.println("You have " + playerPower + " attack power left!");
    }

    //Deduct the attack power from Enemy total Power
    public int enemyAttackPowerDeduct(){
        attackPower = attackDamage();
        enemyPower = enemyPower - attackPower;
        return enemyPower;
    }

    //Deduct the attack power from Player total Power
    public int playerAttackPowerDeduct(){
        attackPower = attackDamage();
        playerPower = playerPower - attackPower;
        return playerPower;
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
    public int forward(){
        int tile = dice(2);
        return tile;
    }

    //Move backwards
    public int backwards(){
        int tile = dice(3) * (-1);
        return tile;
    }

    //Player move
    public void playerMove(){
        System.out.println("Chose one of the following moves:");
        System.out.println("1: Foward");
        System.out.println("2: Retreat");
        System.out.println("3: Attack");
        int move = sc.nextInt();
        if (move == 3) {
            attack();
            }
            else if (move == 2) {
                int steps = backwards();
                System.out.println("You have moved " + steps + " tiles back!");
            }
            else if (move == 1) {
                int steps = forward();
                System.out.println("You have moved " + steps + " tiles forward!");
            }
            else{
                System.out.println("Invalid Input, Please try again");
                playerMove();
            }
        }

    //Enemy move
    public void enemyMove(){
        int move = dice(3);
        if (move == 3) {
            System.out.println("Enemy has Attacked you with huge Dildo!!!!!!");
        }
        else if (move == 2) {
            int steps = backwards();
            System.out.println("Enemy has moved " + steps + " tiles back!");
        }
        else if (move == 1) {
            int steps = forward();
            System.out.println("Enemy has moved " + steps + " tiles forward!");
        }
    }

    //Actual game until someone is dead
    public void game(){
        do {
            playerMove();
            enemyMove();
        }while (playerPower == 0 || enemyPower == 0 );
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
