public class Tor extends Suit {
    /**
     * Her bir ana Suit sadece Constructor'unda  cost,weight ve description larını belirler
     * ve getCost,getWeight,getDescription fonksiyonlarını override etmeye gerek kalmaz.
     */
    public Tor() {
        cost    = 5000;
        weight  = 50;
        description = "Tor Exo Suit";
    }
}