package com.company;

import java.util.*;

public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> wsyztstkieMagazyny = new TreeMap<>();

    public void addCenter(String nazwa, double pojemność)
    {
        wsyztstkieMagazyny.put(nazwa, new FulfillmentCenter(pojemność,nazwa));
    }
    public void addExsistCenter(FulfillmentCenter nazwa)
    {
        wsyztstkieMagazyny.put(nazwa.nazwaMagazynu,nazwa);
    }

    public void removeCenter(String nazwa)
    {
        wsyztstkieMagazyny.remove(nazwa);
    }

    public List<FulfillmentCenter> findEmpty()
    {
        List<FulfillmentCenter> listaPustychMagazynów = new LinkedList<>();

        for(FulfillmentCenter listaMagazynów : wsyztstkieMagazyny.values() )
        {
            if(listaMagazynów.listaProduktów.size() == 0)
            {
                listaPustychMagazynów.add(listaMagazynów);
            }
        }

        return listaPustychMagazynów;
    }

    public void summary()
    {
        for(FulfillmentCenter listaMagazynów : wsyztstkieMagazyny.values())
        {
            System.out.println(listaMagazynów.nazwaMagazynu + " " + (float)(listaMagazynów.stanMagazynu/listaMagazynów.pojemnośćMagazynu*100) + "%");
        }
    }

}
