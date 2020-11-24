package com.company;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static boolean execute = true;
    public static void main(String[] args) throws IOException {

        Menucard menuCard = new Menucard();
        OrderList orderList = new OrderList();
        menuCard.readPizzasFromFile("menucard.txt");


        while (execute) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");


            System.out.print(" Vis Menukort   [1] | ");
            System.out.print(" Indsæt Pizza   [2] | ");
            System.out.print(" Indtast ordre   [3] | ");
            System.out.print(" Vis bestillinger   [4] | ");
            System.out.print(" Fjern bestilling   [5] | ");
            System.out.print(" Gem Ordre   [6] | ");
            System.out.print(" Quit/EXIT   [7]  ");

            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");


            Scanner scanNavn = new Scanner(System.in);
            int choose = scanNavn.nextInt();


            //Switch Menu
            switch (choose) {
                case 1:
                    menuCard.showMenuCard();
                    break;

                case 2:
                    menuCard.newPizza();
                    menuCard.savePizzaToFile("menucard.txt");
                    break;
                    // Tilføj Pizza
                case 3:
                    // Bestil TIL PIZZAER
                    try {
                        orderList.addOrder(new Order(
                                Input.getInt("Pizza nummer: "),
                                Input.getInt("Pris: "),
                                Input.getInt("Antal: "),
                                Input.getTimeInMinutes("Hvornår skal pizzaen hentes ? / tt.mm : "),
                                Input.getString("Hvad dælen hedder? du din gavtyv?: "),
                                Input.getString("Telefon Nummer Lord hr sir.?: ")
                        ));
                        orderList.sortOrderList();
                    }catch (Exception e){
                        System.out.println("Fejl i indskrivningen, prøv igen");

                    }

                    //Pizza gringo = new Pizza(3, "Gringo", "Ost og Tomat bøf", 100);
                    //Pizza gringo = new Pizza(3, "Gringo", "Ost og Tomat bøf", 100);
                    //menuCard.savePizzaToFile("Bestilling.txt");
                    //menuCard.addPizza(gringo);

//                    System.out.println(Input.getString("Hvad tid?"));
//                    int tid = Input.getTimeInMinutes("Afhentingstid: ");
//                    Order o1 = new Order(3, 2, tid, "Jon", "22755844");
//                    System.out.println(o1.toString());
                    break;
                case 4:
                    System.out.println("Vis Bestillinger");
                    orderList.showOrders(menuCard);
                    //orderList.sortOrderList();
                    break;
                case 5:
                    System.out.println("Fjern Bestilling");
                    break;
                case 6:
                    System.out.println("Gem ordre");
                    break;
                case 7:
                    System.out.println("QUIT: Farvel");
                    boolean execute = false;

                default:
                    return;
            }

        }
        //Menucard menuCard = new Menucard();

                // Vis: Program menu
                // indsæt pizza
                //Pizza vesuvio = new Pizza(1, "Vesuvio", "Ost og Tomat", 57);


                 //menuCard.addPizza(vesuvio);
                //menuCard.removePizza("Vesuvio");
                //menuCard.removePizza("First blood 1");
                 /*
                     public void removePizza(int pizzaNumber) {
                     for (int i = 0; i < menuCard.size(); i++) {
                     if (menuCard.get(i).getNumber() == pizzaNumber) {
                        menuCard.remove(i);
                            }
                        }
                  }
        */
                // TIDS BEREGNING!!!!!
                //int tid = Input.getTimeInMinutes("Afhentingstid: ");

                //Order o1 = new Order(1, 2, tid, "Jon", "22755844");

                //System.out.println(o1.toString());



    }
}

