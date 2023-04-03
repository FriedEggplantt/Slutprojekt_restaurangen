import java.util.ArrayList;
import java.util.Scanner;
public class Bokningssystem {
    ArrayList<Integer> Bookings = new ArrayList<Integer>();
    int people;
    Scanner val = new Scanner(System.in);

    Restaurang FedLobster = new Restaurang("Fed Lobster", 50);
    Restaurang ChinaExpress = new Restaurang("China Express", 80);
    Restaurang BeastBorgir = new Restaurang("Beast Borgir", 30);

    public Bokningssystem() {
        while (true) {
            System.out.println(FedLobster.platser);
            System.out.println("Välj restaurang:");
            System.out.println("1 - Fed Lobster");
            System.out.println("2 - China Express");
            System.out.println("3 - Beast Borgir");
            int chooseRestaurant = val.nextInt();
            System.out.println("Vad vill du göra?");
            System.out.println("1 - Boka tid");
            System.out.println("2 - Avboka tid");
            System.out.println("3 - Kolla meny");
            int chooseAction = val.nextInt();
            if (chooseRestaurant == 1) {
                if (chooseAction == 1) {
                    while (true) {
                        System.out.println("Antal personer: ");
                        people = val.nextInt();
                        if ((FedLobster.platser - people) < 0) {
                            System.out.println("Restaurangen är för full för den kapaciteten!");
                            System.out.println("1 - Ändra antal");
                            System.out.println("2 - Lämna");
                            int action1 = val.nextInt();
                            if (action1 == 2) {
                                break;
                            }

                        } else {
                            Bookings.add(people);
                            FedLobster.platser = FedLobster.platser - people;
                            System.out.println("Tack för din bokning!");
                            System.out.println(FedLobster.platser);
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
                            System.out.println((i+1) + ". " +  Bookings.get(i));
                        }
                        System.out.println("Vilken vill du avboka?");
                        int removeBooking = val.nextInt();
                        int chosenBooking = removeBooking -1;
                        System.out.println("Du har tagit bort din bokning med " + Bookings.get(chosenBooking) + " personer");
                        FedLobster.platser = FedLobster.platser + Bookings.get(chosenBooking); //Det här ser till att göra fri antal platser som nu bokades av
                        Bookings.remove(chosenBooking);
                    }
                }
            }
            System.out.println();
            System.out.println("Vad vill du göra?");
            System.out.println("1 - Gå till menyn");
            System.out.println("2 - Avsluta");
            int lastChoice = val.nextInt();
            if (lastChoice ==2){
break;
            }
        }
    }
}
