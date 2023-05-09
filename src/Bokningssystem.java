import java.util.ArrayList;
import java.util.Scanner;
public class Bokningssystem {
    ArrayList<Restaurang> rests = new ArrayList<Restaurang>(); //arraylist av alla restauranger
    int people; //folk som kommer bokas/avbokas i restauranger
    Scanner val = new Scanner(System.in); //input val för användaren

    public Bokningssystem() {
        addRestaurants();
        while (true) { //while loop så att programmet fortsätter att köras tills användaren själv avslutar det
                huvudMeny();

                int chooseRestaurant = userInput();
                Restaurang currentRest = rests.get(chooseRestaurant - 1); //minus 1 så att det kopplas till rätt position i array, så att användaren kan bekvämt skriva siffror från 1+ istället för 0

                andraHuvudMeny();

                int chooseAction = userInput();

                if (chooseAction == 1) {
                    bokaTid(currentRest);

                } else if (chooseAction == 2) {
                   avbokaTid(currentRest);

                } else if (chooseAction == 3) {
checkMenu(currentRest);
                    System.out.println("Vad vill du göra?"); //Vad användaren vill göra efter ha kollat på menyn, ifall de vill boka tid eller lämna
                    System.out.println("1 - Boka tid");
                    System.out.println("2 - Lämna");
                    int ettVal = userInput();
                    if(ettVal == 1){
                        bokaTid(currentRest);
                    }
                }
            System.out.println();
            System.out.println("Vad vill du göra?"); //sista frågan för att fråga om användaren vill fortsätta eller avsluta
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

    public void bokaTid(Restaurang currentRest){ //metoden låter användaren att boka en tid på en restaurang.
        while (true) {
            System.out.println("Restaurangen har " + currentRest.platser + " lediga platser"); //skriver hur många lediga platser som restaurangen har
            System.out.println("Antal personer: ");
            people = userInput();
            if ((currentRest.platser - people) < 0) { //om användaren försöker boka plats för folk som inte får plats i restaurangen så tillåter inte programmet det
                System.out.println("Restaurangen är för full för den kapaciteten!");
                System.out.println("1 - Ändra antal");
                System.out.println("2 - Lämna");
                int action1 = userInput();
                if (action1 == 2) {
                    break;
                }
            } else {
                currentRest.bookings.add(people); //Om användaren bokar plats för ett antal personer som får plats i restaurangen, så läggs de till i restaurangens bokningsarray
                currentRest.platser = currentRest.platser - people; //nu när användaren har bokat för ett antal personer så kommer restaurangens antal lediga platser att dras ner
                System.out.println("Tack för din bokning!");
                break;
            }
        }
    }

    public void avbokaTid(Restaurang currentRest){ //metoden låter användaren avboka en tid i restaurangen
        if (currentRest.bookings.size() == 0) { //ifall bokningsarray är 0 aka det finns inga bokningar så kan inget avbokas
            System.out.println("Du har inga bokningar!");
        } else {
            System.out.println("Här är dina bokningar med antal personer:");
            System.out.println("______________");
            for (int i = 0; i < currentRest.bookings.size(); i++) { //skriver ut alla bokningar och antal personer i varje bokning
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

    public void checkMenu(Restaurang currentRest){ //kollar menyn på restauranger, en loop skriver ut all innehåll
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
    val.next();
                }else{
    break; //ifall det inte är över 0 och det är inget fel så kommer loopen breakas
                }
            } catch (Exception e) {
                System.out.println("ERROR! Försök igen"); //ifall det har kommit något
                val.next();
            }
        }
        return input; //returnar info för att kunna använda det i programmet.
    }

    }

