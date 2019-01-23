public class Dec extends Suit {
    /**
     * Her bir ana Suit sadece Constructor'unda  cost,weight ve description larını belirler
     * ve getCost,getWeight,getDescription fonksiyonlarını override etmeye gerek kalmaz.
     */
    public Dec() {
        cost    = 500;
        weight  = 25;
        description = "Dec Exo Suit";
    }
}
