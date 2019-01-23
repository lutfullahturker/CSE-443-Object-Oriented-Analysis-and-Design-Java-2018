public abstract class Accessory extends Suit {
    protected Suit suit;

    /**
     *
     * @return Ürün adını ve içinde barındırdığı tüm eklentilerin adını birleştirerek return eder
     * ve alt sınıflarda  override yapmaya gerek yoktur.
     */
    @Override
    public String getDescription(){
        return suit.getDescription() + ", " + description;
    }

    /**
     *
     * @return İçinde barındırdığı eklentiler ile birlikte toplam Cost'u return eder ve alt sınıflarda  override yapmaya gerek yoktur.
     */
    @Override
    public double getCost(){
        return suit.getCost() + cost;
    }

    /**
     *
     * @return İçinde barındırdığı eklentiler ile birlikte toplam Weight'i return eder ve alt sınıflarda  override yapmaya gerek yoktur.
     */
    @Override
    public double getWeight() {
        return suit.getWeight() + weight;
    }
}