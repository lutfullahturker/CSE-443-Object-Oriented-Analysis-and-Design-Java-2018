public abstract class Suit {
    protected double cost;
    protected double weight;
    protected String description = "Unknown Suit";

    /**
     *
     * @return Cost değerini return eder. Ve alt sınıflardan ana Suit olan tüm sınıflar bunu kullanır.
     */
    public  double getCost(){
        return cost;
    }

    /**
     *
     * @return Weight değerini return eder. Ve alt sınıflardan ana Suit olan tüm sınıflar bunu kullanır.
     */
    public double getWeight(){
        return weight;
    }

    /**
     *
     * @return Ürünün adını return eder. Ve alt sınıflardan Suit olan tüm sınıflar bunu kullanır.
     */
    public String getDescription(){
        return description;
    }

}
