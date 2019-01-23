import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Menüde yapılan seçimler ile uygulamayı kullanmak için menü ve çalışma döngüleri yapıldı.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To TAI.");
        int choice =0;
        TAIStore store = new MainStore();
        Plane plane = null;
        do {
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
                }
            } catch (InputMismatchException e){
                System.out.println("You have entered wrong character !\n\n");
                scanner.next();
            }
        } while (choice != -1);
    }
}
