import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Restaurang {
    String namn;
    int platser;
    ArrayList<String> menu = new ArrayList<String>();

    public Restaurang(String namn, int platser){
    this.namn = namn;
    this.platser = platser;
takenSeats();
createMenu();
    }

    public void createMenu() {
        if(this.namn.equals("Fed Lobster")){
            menu.add("Fiskpinnar med potatismos & gröna bönor");
            menu.add("Smörbakad hummer med citron");
            menu.add("Skaldjurssopa med musslor");
            menu.add("Vitlöksbröd");
            menu.add("Kräftcocktail med jordärtskockskräm");
            menu.add("Smörstekta pilgrimsmusslor med vitlök");
            menu.add("Skaldjursrisotto");
        }
        if(this.namn.equals("China Express")){
            menu.add("Bao steamed buns");
            menu.add("Bingchiling");
            menu.add("Peking Duck");
            menu.add("Vegetarian dumplings");
            menu.add("Porridge with egg and pork");
            menu.add("Boiled pig feet");
            menu.add("Mapo tofu");
        }
        if(this.namn.equals("Beast Borgir")){
            menu.add("Steak with grilled potato");
            menu.add("500g burger with caramelized onion and homemade chilimayonnaise sauce");
            menu.add("Mama's lasagne");
            menu.add("Hot dog with toppings and mashed potatoes");
            menu.add("Cheesy jalapeno dirty fries");
            menu.add("BBQ chicken wings");
            menu.add("Chicken waffles with syrup");
        }
    }

    public void takenSeats(){ //Den här metoden gör så att det är en random antal tagna platser redan i restaurangen, så att det är mer realistisk.
Random randomNumber = new Random();
int maxSeats = this.platser;
int randomNum = randomNumber.nextInt(maxSeats + 1); //1 läggs till så att random nummer kan också vara this.platser
int availableSeats = this.platser - randomNum; //Säten som finns är totala platser minus en random nummer som ska föreställa tagna platser.
this.platser = availableSeats;
    }
}
