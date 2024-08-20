package com.example.SpringAccountApplication.Entities;

public class Account {
    private Integer id;
   private String name;
   private double balance;

   // Constructors
    public Account(Integer id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }



   public Account(Integer id, String name) {
        this.id = id;
        this.name = name;

    }

   public Account() {

    }

// Setters & Getters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }



    public Double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double deposit(double amount){
        if(amount <= 0){
            System.out.println("Please enter a Dollar amount");
        }
       return this.balance += amount;
    }

    public double withdraw(double amount) {
        double newBalance = 0;
        if(amount > this.balance) {
            System.out.println("Insufficient Funds!");
        } else {

            this.balance -= amount;
            System.out.printf("Success, New Balance is: $" + this.balance);
        }
        return this.balance;

    }

    @Override
    public String toString() {
        return "Account Information{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Balance=" + balance +
                '}';
    }
