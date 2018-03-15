package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        FulfillmentCenterContainer posiadaneMagazyny = new FulfillmentCenterContainer();

        System.out.printf("\nStan magazynów: \n");

        FulfillmentCenter mag1 = new FulfillmentCenter(1000, "Alkohole");
        FulfillmentCenter mag2 = new FulfillmentCenter(1000, "Owoce");
        FulfillmentCenter mag3 = new FulfillmentCenter(10, "Warzywa");
        FulfillmentCenter mag4 = new FulfillmentCenter(10, "Elektronika");
        FulfillmentCenter mag5 = new FulfillmentCenter(10, "RTV");
        FulfillmentCenter mag6 = new FulfillmentCenter(10, "Art. Szkolne");

        posiadaneMagazyny.addExsistCenter(mag1);
        posiadaneMagazyny.addExsistCenter(mag2);
        posiadaneMagazyny.addExsistCenter(mag3);
        posiadaneMagazyny.addExsistCenter(mag4);
        posiadaneMagazyny.addExsistCenter(mag5);
        posiadaneMagazyny.addExsistCenter(mag6);

        posiadaneMagazyny.summary();

        System.out.println("\nUsuwam magazyn Warzywa: ");
        posiadaneMagazyny.removeCenter("Elektronika");

        System.out.println();
        posiadaneMagazyny.summary();

        Item bols = new Item("fbols", ItemCondition.NEW, 4, 13);
        Item stock = new Item("zstock", ItemCondition.USED, 4, 3);
        Item finlandia = new Item("afinlandia", ItemCondition.REFURBISHED, 4, 4);

        mag1.addProductItem(bols);
        mag1.addProductItem(stock);
        mag1.addProductItem(finlandia);

        Item jabłka = new Item("jabłka", ItemCondition.NEW, 6, 13);
        Item gruszki = new Item("gruszki", ItemCondition.USED, 4, 16);
        Item wiśnie = new Item("wiśnie", ItemCondition.REFURBISHED, 4, 4);

        mag2.addProductItem(jabłka);
        mag2.addProductItem(gruszki);
        mag2.addProductItem(wiśnie);

        System.out.println("\n Po dodaniu itemów");
        mag1.summary();
        System.out.println();
        mag2.summary();
        System.out.println();
        posiadaneMagazyny.summary();

        System.out.println("\nUsuwam wiśnie: \n");
        mag2.removeProduct(wiśnie);
        System.out.println("\n Magazyn Owoce: ");
        mag2.summary();
        System.out.println();

        System.out.println("\nPobieramy jabłka z magazynu i szukamy jakiegoś itemu(np bols): ");
        mag1.getProduct(jabłka);
        Item szukany = mag1.search("bols");
        System.out.println("Dane znalezionego: ");
        szukany.print();

        Item szukany1 = mag2.max();
        System.out.println("\nNajwięcej w magazynie z owocami: ");
        szukany1.print();

        System.out.println("\nPuste magazyny: ");
        List<FulfillmentCenter> puste = posiadaneMagazyny.findEmpty();
        for(FulfillmentCenter pusteMagazyny: puste)
        {
            System.out.println(pusteMagazyny.nazwaMagazynu + "\n");
        }


        System.out.println("\nMagazyn z owocami posortowany po ilości: ");
        List<Item> owoceSorted = new ArrayList<>();
        owoceSorted = mag2.sortByAmount();

        for(Item pr : owoceSorted)
        {
            pr.print();
        }


        System.out.println("\nMagazyn z Alkooloami posortowany po nazwie: ");
        List<Item> alkoSorted = new ArrayList<>();
        alkoSorted = mag1.sortByName();

        for (Item pr : alkoSorted) {
            pr.print();
        }

    }
}
