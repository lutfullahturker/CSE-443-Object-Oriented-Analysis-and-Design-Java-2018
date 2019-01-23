import java.util.ArrayList;
import java.util.Iterator;

public class SatelliteIterator implements Iterator {
    private ArrayList<Integer> myData;
    private Iterator iter;

    /**
     * Parametre olarak gelen 2D array i saat yönünde gezecek şekilde elemanlarını veren iteratör constructor'ı
     * @param data Iterator u oluşacak array array
     */
    public SatelliteIterator(int [][] data) {
        myData = new ArrayList<>();
        fillMyData(data);
        iter = myData.iterator();
    }

    /**
     * İçerde private olarak tutulan ArrayList in elemanlarını saat yönünde  sıralı şekilde dolduran fonksiyondur.
     * @param data ArrayList doldurulurken kullanılacak 2D array
     */
    private void fillMyData(int [][] data){
        int i=0,j=0,k=0,visitedCount = 0,totalElem =0;
        boolean [][] visitedArr;
        visitedArr = new boolean[data.length][];
        for (i=0;i<data.length;++i){
            visitedArr[i] = new boolean[data[i].length];
            totalElem += data[i].length;
            for (j=0;j<data[i].length;++j)
                visitedArr[i][j] = false;
        }

        while (visitedCount < totalElem){
            for (i=k;i<data.length;++i){
                for (j=k;j<data[i].length;++j){
                    if (!visitedArr[i][j]){
                        visitedCount++;
                        visitedArr[i][j] = true;
                        myData.add(data[i][j]);
                    }
                    if (j == data[i].length - 1) {
                        if (i < data.length - 2) {
                            --j;
                            ++i;
                        } else
                            ++i;
                    }
                }
            }

            for (i = data.length-1-k;i >= 0; --i){
                for (j = data[i].length-1-k;j >= 0; --j){
                    if (!visitedArr[i][j]){
                        visitedArr[i][j] = true;
                        visitedCount++;
                        myData.add(data[i][j]);
                    }
                    if (j == 0) {
                        if (i != 0 && !visitedArr[i - 1][j]) {
                            ++j;
                            --i;
                        } else
                            i = 0;
                    }
                }
            }
            ++k;
        }

    }

    /**
     * sırada başka bir eleman var mı diye kontrol eder.
     * @return son elemana ulaşılmışsa false, ulaşılmamışsa true return eder.
     */
    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    /**
     * Sıradaki elemanı verir.
     * @return Bir sonraki eleman
     */
    @Override
    public Object next() {
        return iter.next();
    }
}
