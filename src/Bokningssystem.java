import java.util.ArrayList;
import java.util.Scanner;
public class Bokningssystem {
    ArrayList<Integer> Bookings = new ArrayList<Integer>();
    ArrayList<Restaurang> rests = new ArrayList<Restaurang>();
    int people;
    Scanner val = new Scanner(System.in);

    public Bokningssystem() {
        addRestaurants();
        while (true) {
            while (true) {
                System.out.println("Välj restaurang:");
                System.out.println("1 - Fed Lobster");
                System.out.println("2 - China Express");
                System.out.println("3 - Beast Borgir");
                int chooseRestaurant = val.nextInt();
                Restaurang currentRest = rests.get(chooseRestaurant - 1);
                System.out.println("Vad vill du göra?");
                System.out.println("1 - Boka tid");
                System.out.println("2 - Avboka tid");
                System.out.println("3 - Kolla meny");
                int chooseAction = val.nextInt();
                if (chooseAction == 1) {
                    while (true) {
                        System.out.println("Restaurangen har " + currentRest.platser + " lediga platser");
                        System.out.println("Antal personer: ");
                        people = val.nextInt();
                        if ((currentRest.platser - people) < 0) {
                            System.out.println("Restaurangen är för full för den kapaciteten!");
                            System.out.println("1 - Ändra antal");
                            System.out.println("2 - Lämna");
                            int action1 = val.nextInt();
                            if (action1 == 2) {
                                break;
                            }

                        } else {
                            Bookings.add(people);
                            currentRest.platser = currentRest.platser - people;
                            System.out.println("Tack för din bokning!");
                            break;
                        }
                    }
                } else if (chooseAction == 2) {
                    if (Bookings.size() == 0) {
                        System.out.println("Du har inga bokningar!");
                    } else {
                        System.out.println("Här är dina bokningar med antal personer:");
                        System.out.println("______________");
                        for (int i = 0; i < Bookings.size(); i++) {
                            System.out.println((i + 1) + ". " + Bookings.get(i));
                        }
                        System.out.println("Vilken vill du avboka?");
                        int removeBooking = val.nextInt();
                        int chosenBooking = removeBooking - 1;
                        System.out.println("Du har tagit bort din bokning med " + Bookings.get(chosenBooking) + " personer");
                        currentRest.platser = currentRest.platser + Bookings.get(chosenBooking); //Det här ser till att göra fri antal platser som nu bokades av
                        Bookings.remove(chosenBooking);
                    }
                } else if (chooseAction == 3) {
                    for (int i = 0; i < currentRest.menu.size(); i++) {
                        System.out.println(currentRest.menu.get(i));
                    }
                }
            }
            System.out.println();
            System.out.println("Vad vill du göra?");
            System.out.println("1 - Gå till menyn");
            System.out.println("2 - Avsluta");
            int lastChoice = val.nextInt();
            if (lastChoice == 2) {
                break;
            }
        }
    }
    public void addRestaurants() {
        rests.add(new Restaurang("Fed Lobster", 50));
        rests.add(new Restaurang("China Express", 80));
        rests.add(new Restaurang("Beast Borgir", 30));
    }
}
