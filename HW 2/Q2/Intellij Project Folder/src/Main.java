import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Menüde yapılan seçimler ile uygulamayı kullanmak için menü ve çalışma döngüleri yapıldı.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome To The Zirhsan A.S.");
        int choice = 0;
        Suit suit = null;
        do {
            try {
                System.out.println("Please Select a Suit you want.");
                System.out.println("Dec => Press 1\nOra => Press 2\nTor => Press 3\nExit Application => Press -1");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        suit = new Dec();
                        System.out.println("You Chosen Dec.");
                        break;
                    case 2:
                        suit = new Ora();
                        System.out.println("You Chosen Ora.");
                        break;
                    case 3:
                        suit = new Tor();
                        System.out.println("You Chosen Tor.");
                        break;
                    case -1:
                        System.out.println("Thanks for using our program.");
                        System.exit(0);
                    default:
                        System.out.println("You have entered wrong character !\n\n");
                        continue;
                }
            } catch (InputMismatchException e){
                System.out.println("You have entered wrong character !\n\n");
                scanner.next();
                continue;
            }

            boolean flag = true;
            do {
                try {
                    System.out.println("Please Select an accessory for your Suit.");
                    System.out.println("FlameThrower => Press 1\nAutoRifle => Press 2\nRocketLauncher => Press 3\nLaser => Press 4\nFinish the Purchase and Print the Cost And Weight of your Suit => Press 0\nReturn to Menu => Press -1");
                    int choice2 = scanner.nextInt();
                    switch (choice2) {
                        case 1:
                            suit = new FlameThrower(suit);
                            break;
                        case 2:
                            suit = new AutoRifle(suit);
                            break;
                        case 3:
                            suit = new RocketLauncher(suit);
                            break;
                        case 4:
                            suit = new Laser(suit);
                            break;
                        case 0:
                            System.out.println("Your Cost and Weight :");
                            System.out.println(suit.getDescription() + "  =  " + suit.getCost() + "K ₺ ,  " + suit.getWeight() + " KG");
                            System.out.println("Your Order is Ready. Redirecting to Main Menu ...\n\n");
                        case -1:
                            flag = false;
                            break;
                        default:
                            System.out.println("You have entered wrong character !\n\n");
                    }
                } catch (InputMismatchException e){
                    System.out.println("You have entered wrong character !\n\n");
                    scanner.next();
                }
            } while (flag);

        } while (choice != -1);
    }
}
