import java.util.ArrayList;
import java.util.Scanner;
public class Bokningssystem {
    ArrayList<Integer> allBookings = new ArrayList<Integer>(); //arraylist av alla bokningar
    ArrayList<Restaurang> rests = new ArrayList<Restaurang>(); //arraylist av alla restauranger
    int people; //folk som kommer bokas/avbokas i restauranger
    Scanner val = new Scanner(System.in); //input val för användaren

    public Bokningssystem() {
        addRestaurants();
        while (true) {
                huvudMeny();

                int chooseRestaurant = userInput();
                Restaurang currentRest = rests.get(chooseRestaurant - 1);

                andraHuvudMeny();

                int chooseAction = userInput();

                if (chooseAction == 1) {
                    bokaTid(currentRest);

                } else if (chooseAction == 2) {
                   avbokaTid(currentRest);

                } else if (chooseAction == 3) {
checkMenu(currentRest);
                    System.out.println("Vad vill du göra?");
                    System.out.println("1 - Boka tid");
                    System.out.println("2 - Gå till huvudmenyn");
                    int ettVal = userInput();
                    if(ettVal == 1){
                        bokaTid(currentRest);
                    }
                }
            System.out.println();
            System.out.println("Vad vill du göra?");
            System.out.println("1 - Gå till huvudmenyn");
            System.out.println("2 - Avsluta");
            int lastChoice = userInput();
            if (lastChoice == 2) {
                break;
            }
        }
    }
    public void addRestaurants() { //Här läggs till nya restauranger i restaurang arrraylistan, med nya namn och antal platser som finns i restaurangen.
        rests.add(new Restaurang("Fed Lobster", 50));
        rests.add(new Restaurang("China Express", 80));
        rests.add(new Restaurang("Beast Borgir", 30));
    }

    public void huvudMeny(){
        System.out.println("Välj restaurang:");
        int a = 1;
        for (Restaurang i: rests) {
            System.out.println(a + ": " + i.namn);
            a++;
        }
    }

    public void andraHuvudMeny(){
        System.out.println("Vad vill du göra?");
        System.out.println("1 - Boka tid");
        System.out.println("2 - Avboka tid");
        System.out.println("3 - Kolla meny");
    }

    public void bokaTid(Restaurang currentRest){
        while (true) {
            System.out.println("Restaurangen har " + currentRest.platser + " lediga platser");
            System.out.println("Antal personer: ");
            people = userInput();
            if ((currentRest.platser - people) < 0) {
                System.out.println("Restaurangen är för full för den kapaciteten!");
                System.out.println("1 - Ändra antal");
                System.out.println("2 - Lämna");
                int action1 = userInput();
                if (action1 == 2) {
                    break;
                }
            } else {
                currentRest.bookings.add(people);
                currentRest.platser = currentRest.platser - people;
                System.out.println("Tack för din bokning!");
                break;
            }
        }
    }

    public void avbokaTid(Restaurang currentRest){
        if (currentRest.bookings.size() == 0) {
            System.out.println("Du har inga bokningar!");
        } else {
            System.out.println("Här är dina bokningar med antal personer:");
            System.out.println("______________");
            for (int i = 0; i < currentRest.bookings.size(); i++) {
                System.out.println((i + 1) + ". " + currentRest.bookings.get(i));
            }
            System.out.println("Vilken vill du avboka?");
            int removeBooking = userInput();
            int chosenBooking = removeBooking - 1;
            System.out.println("Du har tagit bort din bokning med " + currentRest.bookings.get(chosenBooking) + " personer");
            currentRest.platser = currentRest.platser + currentRest.bookings.get(chosenBooking); //Det här ser till att göra fri antal platser som nu bokades av
            currentRest.bookings.remove(chosenBooking);
        }
    }

    public void checkMenu(Restaurang currentRest){
        for (int i = 0; i < currentRest.menu.size(); i++) {
            System.out.println(currentRest.menu.get(i));
        }
        System.out.println();
    }
    public int userInput() { //den här metoden använder felhantering för att ta in ett input av användaren
        int input;
        while (true) {
            try {
input = val.nextInt(); //Ett input testas
if(input<= 0){ //inget input ska vara mindre än 0 för denna projekt, därför kommer det bli fel
                    System.out.println("ERROR! Försök igen");
                }else{
    break; //ifall det inte är över 0 och det är inget fel så kommer loopen breakas
                }
            } catch (Exception e) {
                System.out.println("ERROR! Försök igen"); //ifall det har kommit något
            }
        }
        return input; //returnar info för att kunna använda det i programmet.
    }

    }

