package com.company;

public class Item implements Comparable<Item> {

    public Item(String nazwa, ItemCondition stan, double masa, int ilość) {
        this.nazwa = nazwa;
        this.stan = stan;
        this.masa = masa;
        this.ilość = ilość;
    }

    public void print()
    {
        System.out.println("Nazwa: " + this.nazwa + "\nStan: " + this.stan + "\nMasa: "+ this.masa+ "\nIlosć: " + this.ilość);
    }

    String nazwa;
    ItemCondition stan;
    double masa;
    int ilość;

    @Override
    public int compareTo(Item item) {
        return nazwa.compareTo(item.nazwa);
    }
}
