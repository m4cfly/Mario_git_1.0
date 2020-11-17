package com.company;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private final static boolean execute = true;

    public static void main(String[] args) {
        Menucard menuCard = new Menucard();
        System.out.println("************************************");
        System.out.println("******* VELKOMMEN TIL MARIO's ******");
        System.out.println("************ PIZZA BAR *************");
        System.out.println("           Vis Menukort      [1]    ");
        System.out.println("           Indtast ordre     [2]    ");
        System.out.println("         Vis bestillinger    [3]    ");
        System.out.println("         Fjern bestilling    [4]    ");
        System.out.println("            Gem Ordre        [5]    ");




        while (execute) {
            Scanner scanNavn = new Scanner(System.in);
            int navn = scanNavn.nextInt();


            //switch
            switch (navn) {
                case 1:
                    // vis menu
                    menuCard.readPizzasFromFile("menucard.txt");
                    menuCard.showMenuCard();
                    System.out.println(Input.getString("Opret en pizza: "));
                    Pizza gringo = new Pizza(3, "Gringo", "Ost og Tomat bøf", 100);
                    menuCard.addPizza(gringo);

                    System.out.println(Input.getString("Hvad tid?"));
                    int tid = Input.getTimeInMinutes("Afhentingstid: ");
                    Order o1 = new Order(3, 2, tid, "Jon", "22755844");
                    System.out.println(o1.toString());

                    try{

                    }catch (Exception e){
                        System.out.println("Pizza kunne ikke findes");
                    }
                    break;
                case 2:
                    // TILFØJ TIL PIZZAER
                    System.out.println(Input.getString("Indtast Ordre: "));

                    break;
                case 3:
                    System.out.println(Input.getString(""));

                    break;
                case 4:
                    System.out.println("Revisor");

                    break;
                case 5:
                    System.out.println("Revisor");
                    System.out.println("MASSER af DOLLARS $$$$$$$$$$$$");
                    break;
                //menuCard.savePizzaToFile("Bestilling.txt");
                default:
                    System.out.println("Ingen bruger valgt. Farvel");
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

