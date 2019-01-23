public class TurboPaymentAdaptor implements ModernPayment {
    private TurboPayment turboPayment ;

    /**
     * Adaptor constructor gets old library object to adapt it to modernPayment
     * @param turboPayment TurboPayment object
     */
    public TurboPaymentAdaptor(TurboPayment turboPayment) {
        this.turboPayment = turboPayment;
    }

    /**
     * Adaptor Function
     * @param cardNo card no
     * @param amount amount
     * @param destination destination
     * @param installments installments
     * @return amount
     */
    @Override
    public int pay(String cardNo, float amount, String destination, String installments) {
        return turboPayment.payInTurbo(cardNo, amount, destination, installments);
    }
}
