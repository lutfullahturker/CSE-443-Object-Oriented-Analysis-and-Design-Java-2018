public class FlameThrower extends Accessory {
    /**
     * Zircirleme şekilde eklenti ekleyebilmek için constructor parametre olarak Suit alır.
     * Constructor'da suit ataması ve cost,weight,description atamaları yapılır ve üst sınıftan gelen fonksiyonları
     * override etmeye gerek yoktur.
     * @param suit Ana Suit objesi veya bir accessory objesi
     */
    public FlameThrower(Suit suit) {
        this.suit   = suit;
        cost    = 50;
        weight  = 2;
        description = "FlameThrower";
    }
}
