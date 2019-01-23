public class Main {

    public static void main(String[] args) {
        int k = 1;
        int [][] data = new int[4][];
        for (int i=0;i<4;++i) {
            data[i] = new int[4];
            for (int j = 0; j < 4; ++j, ++k)
                data[i][j] = k;
        }

        SatelliteIterator iter = new SatelliteIterator(data);
        while (iter.hasNext()) {
            System.out.print(iter.next() + "  ");
        }
    }
}
