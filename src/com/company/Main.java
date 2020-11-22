package com.company;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static boolean execute = true;
    public static void main(String[] args) throws IOException {

        Menucard menuCard = new Menucard();
        OrderList orderList = new OrderList();


        while (execute) {
            System.out.println("           Vis Menukort      [1]    ");
            System.out.println("           Indtast ordre     [2]    ");
            System.out.println("           Indsæt Pizza      [2]    ");
            System.out.println("         Vis bestillinger    [3]    ");
            System.out.println("         Fjern bestilling    [4]    ");
            System.out.println("             Gem Ordre       [5]    ");
            System.out.println("           Quit  /  EXIT     [5]    ");


            Scanner scanNavn = new Scanner(System.in);
            int choose = scanNavn.nextInt();


            //switch Menu
            switch (choose) {
                case 1:
                    try{
                    // vis menu
                    menuCard.readPizzasFromFile("menucard.txt");

                    }catch (Exception e){
                        System.out.println("Menukort kunne ikke findes.");
                    }

                    menuCard.showMenuCard();
                    break;

                case 2:
                    // TILFØJ TIL PIZZAER
                    try {
                        orderList.addOrder(new Order(
                                Input.getInt("Pizza nummer: "),
                                Input.getInt("Pris: "),
                                Input.getInt("Antal: "),
                                Input.getTimeInMinutes("Hvornår skal pizzaen hentes ? / tt.mm : "),
                                Input.getString("Hvad dælen hedder? du din gavtyv?: "),
                                Input.getString("Telefon Nummer Lord hr sir.?: ")));
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
                case 3:
                    menuCard.newPizza();
                    menuCard.savePizzaToFile("menucard.txt");
                    //orderList.showOrders();
                    break;
                case 4:
                    System.out.println("Fjern Ordre");
                    break;
                case 5:
                    System.out.println("Gem ordre");
                    break;

                default:
                    System.out.println("QUIT: Farvel");
                    boolean execute = false;
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

