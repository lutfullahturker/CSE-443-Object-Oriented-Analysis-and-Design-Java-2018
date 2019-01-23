import java.io.*;
import java.util.Scanner;

public abstract class DiscreteTransformSolver {
    protected double[] outReal;
    protected double[] outImag =null;
    protected double[] inReal;
    protected double[] inImag =null;
    protected String filename;

    /**
     * TemplateMethod dur.İşlemleri sırasıyla uygular.
     */
    public final void solveTemplateMethod(){
        readFromFile();
        transform();
        writeToFile();
        execTimeHook();
    }

    /**
     * Dosyadan N adet sayıyı okur.
     */
    private void readFromFile(){
        Scanner sc =null;
        int count =0;
        try {
            File file = new File(filename);
            sc = new Scanner(file);
            while (sc.hasNextDouble()) {
                count++;
                sc.nextDouble();
            }
            sc.close();
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found !\nPlease Try Again an existing file.");
            System.exit(1);
        }
        double elem;
        int i =0;
        if (this instanceof DFT){
            outImag = new double[(int)Math.ceil((double)(count)/2.0)];
            outReal = new double[(int)Math.ceil((double)(count)/2.0)];
            inImag  = new double[(int)Math.ceil((double)(count)/2.0)];
            inReal  = new double[(int)Math.ceil((double)(count)/2.0)];

            while (sc.hasNextDouble()){
                elem = sc.nextDouble();
                inReal[i] = elem;
                if (sc.hasNextDouble()) {
                    elem = sc.nextDouble();
                    inImag[i++] = elem;
                }
                else
                    inImag[i++] = 0;
            }
        }
        else{
            outReal = new double[count];
            inReal  = new double[count];
            while (sc.hasNextDouble()) {
                elem = sc.nextDouble();
                inReal[i++] = elem;
            }
        }
        sc.close();
    }

    /**
     * transform işlemi subclass'lara bırakılır. Her class kendi yöntemitle transform işlemini gerçekleştirir.
     */
    protected abstract void transform();

    /**
     * Oluşan N sayıda output'u dosyaya yazar.
     */
    private void writeToFile(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("output.txt");
        } catch (IOException e) {
            System.out.println("Error when writing output to a file !");
            System.exit(1);
        }
        PrintWriter writer = new PrintWriter(fileWriter);
        int i;
        if (this instanceof DFT){
            for (i=0;i<outReal.length;++i) {
                if (i == outReal.length-1)
                    writer.printf("%.3f + %.3fi", outReal[i], outImag[i]);
                else
                    writer.printf("%.3f + %.3fi , ", outReal[i], outImag[i]);
            }
        }
        else{
            for (i=0;i<outReal.length;++i)
                writer.printf("%.3f  ",outReal[i]);
        }
        writer.close();
    }

    /**
     * Bu method hook method'dur.Çünkü sadece DFT buna ihtiyaç duyar. DCT'nin bu method u override etmesine de gerek olmaması için boş bırakırız.
     * Yani Metodu yalnızca  ihtiyacı olan alt sınıflar override eder.
     */
    protected void execTimeHook(){}
}
