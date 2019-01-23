public class RocketLauncher extends Accessory {
    /**
     * Zircirleme şekilde eklenti ekleyebilmek için constructor parametre olarak Suit alır.
     * Constructor'da suit ataması ve cost,weight,description atamaları yapılır ve üst sınıftan gelen fonksiyonları
     * override etmeye gerek yoktur.
     * @param suit Ana Suit objesi veya bir accessory objesi
     */
    public RocketLauncher(Suit suit) {
        this.suit   = suit;
        cost    = 150;
        weight  = 7.5;
        description = "RocketLauncher";
    }
}
