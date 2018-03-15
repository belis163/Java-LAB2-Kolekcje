package com.company;

import java.util.*;

public class FulfillmentCenter
{
    List<Item> listaProduktów = new ArrayList<Item>();
    final double pojemnośćMagazynu;
    String nazwaMagazynu;
    double stanMagazynu;

    public FulfillmentCenter(double pojemnośćMagazynu, String nazwaMagazynu) {
        this.pojemnośćMagazynu = pojemnośćMagazynu;
        this.nazwaMagazynu = nazwaMagazynu;
        this.stanMagazynu = 0;
    }

    public void addProductItem(Item item)
        {
            if(stanMagazynu + (item.masa*item.ilość) > pojemnośćMagazynu) System.err.println("Przekroczono maksymalny stan magazynu.");

            else
            {
                for(Item itemList : listaProduktów)
                {
                    if(itemList.compareTo(item) == 0)
                    {
                        itemList.ilość+=item.ilość;
                        stanMagazynu += item.masa*item.ilość;
                    }
                }
                listaProduktów.add(item);
                stanMagazynu += item.masa*item.ilość;;
            }

        }

        public void getProduct(Item item)
        {
            for(Item listaItemów : listaProduktów)
            {
                if(listaItemów.compareTo(item) == 0)
                {
                    stanMagazynu -= (listaItemów.ilość * listaItemów.masa);

                    if(listaItemów.ilość == 0)
                    {
                        listaProduktów.remove(listaItemów);
                    }
                }
            }
        }

        public void removeProduct(Item item)
        {
            for(Item listaItemów : listaProduktów)
            {
             if(listaItemów.compareTo(item) == 0)
             {
                 stanMagazynu -= (listaItemów.ilość*listaItemów.masa);
                 listaProduktów.remove(listaItemów);
                 return;
             }

            }
        }

        public Item search(String name)
        {
            for (Item listaItemów: listaProduktów)
            {
                if(listaItemów.nazwa == name)
                {
                    return listaItemów;
                }

            }

            //Collections.binarySearch(listaProduktów, name, );

            return new Item("brak", ItemCondition.EMPTY, 0, 0);
        }

        public List<Item> searchPartial(String nazwa)
        {
            List<Item> znalezione = new LinkedList<>();

            for(Item listaItemów : listaProduktów)
            {
                if(listaItemów.nazwa.contains(nazwa))
                {
                    znalezione.add(listaItemów);
                }
            }

            return znalezione;
        }

    public int countByCondition(ItemCondition stan)
    {
        int znalezione = 0;

        for(Item listaItemów : listaProduktów)
        {
            if(listaItemów.stan == stan)
            {
                znalezione += listaItemów.ilość;
            }
        }

        return  znalezione;
    }

    public void summary()
    {
        for(Item listaItemów : listaProduktów)
        {
            listaItemów.print();
        }
    }

    public List<Item> sortByAmount()
    {
        List<Item> sorted = new ArrayList<Item>(listaProduktów);

        sorted.sort((item1, item2) ->
                {
                    if(item1.ilość > item2.ilość)
                    {
                        return -1;
                    }
                    else if(item1.ilość > item2.ilość)
                    {
                        return 1;
                    }
                    else return 0;
                }
        );
        return sorted;
    }

    public List<Item> sortByName()
    {
        List<Item> sorted = new ArrayList<Item>(listaProduktów);


        sorted.sort(Item::compareTo);

                //Collections.sort(sorted);


        return sorted;
    }


    public Item max()
    {
        Item maxItems = Collections.max(listaProduktów, (item1, item2) ->
                        Integer.compare(item1.ilość, item2.ilość)
        );

        return maxItems;
    }

}
