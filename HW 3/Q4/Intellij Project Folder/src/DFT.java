import java.util.Scanner;

public class DFT extends DiscreteTransformSolver {
    private long execTime;


    public DFT(String filename) {
        this.filename = filename;
    }

    /**
     * real ve imaginer array leri ayni eleman sayisina sahip olmali
     * 'https://www.nayuki.io/page/how-to-implement-the-discrete-fourier-transform'
     * ve
     * 'https://en.wikipedia.org/wiki/Discrete_Fourier_transform'
     * adreslerindeki formül gerçeklenerek yapılmıştır.
     */
    @Override
    protected void transform() {
        execTime = System.nanoTime();
        int n = inReal.length;
        for (int i = 0; i < n; i++) {
            double sumReal = 0;
            double sumImag = 0;
            for (int j = 0; j < n; j++) {
                double angle = 2 * Math.PI * j * i / n;
                sumReal +=  inReal[j] * Math.cos(angle) + inImag[j] * Math.sin(angle);
                sumImag += -inReal[j] * Math.sin(angle) + inImag[j] * Math.cos(angle);
            }
            outReal[i] = sumReal;
            outImag[i] = sumImag;
        }
        execTime = System.nanoTime() - execTime;
    }

    /**
     * Kullaniciya runtime suresini gormek isteyip istemedigini sorar. Yanlis giris durumunda  default olarak istemedigini kabul eder.
     */
    @Override
    protected void execTimeHook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see the transform operation runtime ?\nPress 'y' or 'Y' for Yes\nPress 'n' or 'N' for No\nDifferent answers will be assume No");
        String answer = scanner.next();
        if (answer.toLowerCase().equals("y"))
            System.out.println("Discrete Fourier Transform Runtime is  "+ execTime + " NanoSeconds.");
    }
}
