public class Ora extends Suit {
    /**
     * Her bir ana Suit sadece Constructor'unda  cost,weight ve description larını belirler
     * ve getCost,getWeight,getDescription fonksiyonlarını override etmeye gerek kalmaz.
     */
    public Ora() {
        cost    = 1500;
        weight  = 30;
        description = "Ora Exo Suit";
    }
}
