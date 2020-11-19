package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menucard {
    private final String NR = "NR";
    private final String NAVN = "NAVN";
    private final String INGREDIENSER = "INGREDIENSER";
    private final String PRIS = "PRIS";
    private final String START = "START";
    private final String END = "END";
    boolean choose = true;

    List<Pizza> menuCard;
    //INSTANCIERING AF MENUKORT TIL AT HOLDE EN MASSE PIZZA
    public Menucard() {
        this.menuCard = new ArrayList<Pizza>();
    }
    // TILFØJ TIL PIZZAER
    public void addPizza(Pizza pizza){
        menuCard.add(pizza);
    }
    // GEM TIL FIL
    public void savePizzaToFile(String fileName){
        try(PrintWriter writer = new PrintWriter(new File(fileName))){
            for(Pizza pizza : menuCard){
                writer.println(START);
                writer.println(NR);
                writer.println(NAVN);
                writer.println(INGREDIENSER);
                writer.println(PRIS);
                writer.println(pizza.getPris());
                writer.println(END);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    // LÆS DATA FRA FIL
    public void readPizzasFromFile(String fileName){
        String line = "";
        String token = "";
        Pizza pizza = null;

        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                switch (line) {
                    case START:
                        //CONSTRUCT NY PIZZA object
                        pizza = new Pizza();
                        break;
                    case NR:
                        token = NR;
                        break;
                    case NAVN:
                        token = NAVN;
                        break;
                    case INGREDIENSER:
                        token = INGREDIENSER;
                        break;
                    case PRIS:
                        token = PRIS;
                        break;
                    case END:
                        if (pizza != null) {
                            menuCard.add(pizza);
                        }
                        break;
                    default:
                        switch (token) {
                            case NAVN:
                                pizza.setNavn(line);
                                break;
                            case INGREDIENSER:
                                pizza.setIngredienser(line);
                                break;
                            case NR:
                                try {
                                    //pizza.setPris(Double.parseDouble(line));
                                    pizza.setNr(Integer.parseInt(line));
                                } catch (Exception e) {
                                    System.out.println("Der er ikke en double i NR: " + pizza.getNr());
                                }
                            break;
                            case PRIS:
                                try {
                                    //pizza.setPris(Double.parseDouble(line));
                                    pizza.setPris(Integer.parseInt(line));
                                } catch (Exception e) {
                                    System.out.println("Der er ikke en double i Pris for: " + pizza.getPris());
                                }
                                break;
                        }
                }

            }
        }catch (FileNotFoundException e){
            e.printStackTrace();

        }
    }
    public void removePizza(String navn){
        for (int i = 0; i < menuCard.size(); i++) {
            if (menuCard.get(i).getNavn().equalsIgnoreCase(navn)){
                menuCard.remove(i);
            }

        }
    }
    // VIS MENU
    public void showMenuCard(){
        System.out.println("***************************************");
        System.out.println("**************** PIZZA ****************");

        for (Pizza pizza : menuCard) {
            System.out.print(pizza.getNr() + ". ");
            System.out.print(pizza.getNavn() + ": ");
            System.out.print(pizza.getIngredienser() + " ...... ");
            System.out.println(pizza.getPris() + " kr.");


        }



    }
}
