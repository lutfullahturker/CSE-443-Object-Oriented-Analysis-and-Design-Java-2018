import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Menüde yapılan seçimler ile uygulamayı kullanmak için menü ve çalışma döngüleri yapıldı.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To TAI.");
        int choice =0;
        boolean flag = true;
        TAIStore store = null;
        Plane plane = null;
        do {
            if (flag) {
                try {
                    System.out.println("Choose Your Market.");
                    System.out.println("Domestic => Press 1\nEurasia => Press 2\nOther => Press 3\nExit Application => Press -1");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            store = new DomesticStore();
                            System.out.println("\nDomestic Market\n");
                            break;
                        case 2:
                            store = new EurasiaStore();
                            System.out.println("\nEurasia Market\n");
                            break;
                        case 3:
                            store = new OtherStores();
                            System.out.println("\nOther Markets\n");
                            break;
                        case -1:
                            System.out.println("Thanks for using our program.");
                            continue;
                        default:
                            System.out.println("You have entered wrong character !\n\n");
                            continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("You have entered wrong character !\n\n");
                    scanner.next();
                    continue;
                }
            }
            flag = true;
            try {
                System.out.println("Please Select a Plane you want.");
                System.out.println("TPX 100 => Press 1\nTPX 200 => Press 2\nTPX 300 => Press 3\nExit Application => Press -1");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        plane = store.orderTPX("TPX 100");
                        break;
                    case 2:
                        plane = store.orderTPX("TPX 200");
                        break;
                    case 3:
                        plane = store.orderTPX("TPX 300");
                        break;
                    case -1:
                        System.out.println("Thanks for using our program.");
                        break;
                    default:
                        System.out.println("You have entered wrong character !\n\n");
                        flag = false;
                }
            } catch (InputMismatchException e){
                System.out.println("You have entered wrong character !\n\n");
                scanner.next();
                flag = false;
            }
        } while (choice != -1);
    }
}
