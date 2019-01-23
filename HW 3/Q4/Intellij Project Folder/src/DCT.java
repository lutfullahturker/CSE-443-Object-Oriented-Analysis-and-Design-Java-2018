public class DCT extends DiscreteTransformSolver {

    public DCT(String filename) {
        this.filename = filename;
    }

    /**
     * 'https://en.wikipedia.org/wiki/Discrete_cosine_transform'
     * adresindeki DCT II formülünü uygulayarak dönüşüm yapar ve output array ini doldurur.
     */
    @Override
    protected void transform() {
        for (int i = 0; i < inReal.length; i++) {
            double total = 0;
            for (int j = 0; j < inReal.length; j++)
                total += inReal[j] * Math.cos((j + 0.5) * i * (Math.PI / inReal.length));
            outReal[i] = total;
        }

    }
}
