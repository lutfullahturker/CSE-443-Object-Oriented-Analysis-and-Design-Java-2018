public class CreditCardModernPayment implements ModernPayment {
    /**
     *
     * @param cardNo card no
     * @param amount amount
     * @param destination destination
     * @param installments installments
     * @return amount
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        System.out.println("Card No : "+cardNo);
        System.out.println("Amount : "+amount);
        System.out.println("Destination : "+destination);
        System.out.println("Installments : "+installments);
        return (int) amount;
    }
}
