package com.company;

import java.util.Scanner;

class Account
  { Scanner sc = new Scanner(System.in);
    protected int l;
    protected String[] user = new String[4];
    protected String[] p = new String[4];
    protected double amount,money;
    protected double[] current = new double[4];

    // constructor
    public Account() {
      current[0] = 100000;	current[1] = 150000;
      current[2] = 200000;	current[3] = 250000;
      user[0] = "Safala"; p[0] = "saf";
      user[1] = "Nitin";  p[1] = "nit";
      user[2] = "Tejas";  p[2] = "tej";
      user[3] = "Aditya"; p[3] = "adi";
    }

    //checking
    public void checking() {
      System.out.println("\n\nYou will get only 4 chances if invalid.\n");
      int count;
      count = 0;
      String s1, password;
      do
      {
        System.out.println("Enter User name: ");    s1 = sc.nextLine();
        System.out.println("Enter User password: ");  password = sc.nextLine();
        if (s1.equals(user[0]) && password.equals(p[0]))
        {
          getting(user[0], 0); l = 0;  break;
        }
        else if (s1.equals(user[1])  && password.equals(p[1]))
        {
          getting(user[1], 1);  l = 1; break;
        }
        else if (s1.equals(user[2])  && password.equals(p[2]))
        {
          getting(user[2], 2);  l = 2; break;
        }
        else if (s1.equals(user[3]) && password.equals(p[3]))
        {
          getting(user[3], 3); l = 3; break;
        }
        else
        {

          System.out.println("\nInvalid Credentials !!!!\n\n");
          count = count + 1;
        }
        if (count > 3)
        {
          System.out.println("System cannot give more chances to you.Sorry!!!!\n\n");
        }
      } while (count <= 3);
    }

    //getac
    public void getac() {
      amount = sc.nextDouble();
    }

    //credit
    public void credit() {

      money = current[l] + amount;

      System.out.println("Amount Credited!");
      System.out.println("\nNew account balance is: " + money + "\n");
    }

    //debit
    public void debit() {
      if (amount > current[l])
      {
        System.out.println("Debit amount exceeded account balance. Sorry!!\n\n");
      }
      else
      {
        money = current[l] - amount;
        //system("cls");
        System.out.println("\nAmount Withdrawn! ");
        System.out.println("\nBalance Remaining is: " + money + " \n");
      }
    }

    //getting
    public void getting(String username, int len) {
      byte n;
      System.out.println("\t\t\t\t\t  Welcome: " + username + "\nUr current account balance is:" + current[len]);
      System.out.println(" \n");
      System.out.println("1.) Enter 1 to credit.\n");
      System.out.println("2.) Enter 2 to debit.\n");

      System.out.println("\nEnter option: ");   n = sc.nextByte();
      System.out.println("\nEnter Amount: "); getac();
      if (n == 1)
        credit();
      if (n == 2)
        debit();
    }

  }

public class Main {

    public static void main(String[] args) {
      Account A = new Account();
      A.checking();
    }
}
