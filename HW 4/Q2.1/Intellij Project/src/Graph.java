import java.util.Arrays;

public class Graph {
    private double[][] adjMatr;
    private Edge[] edges;
    private int vertexNum;

    public Graph(Edge[] edges, int vertexNum) {
        this.adjMatr = new double[vertexNum][vertexNum];
        this.edges = edges;
        this.vertexNum = vertexNum;

        for (double[] row : adjMatr)
            Arrays.fill(row, Double.NaN);
        for (Edge e : edges) {
            adjMatr[e.getSource()][e.getDest()] = e.getWeight();
            adjMatr[e.getDest()][e.getSource()] = e.getWeight();
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public double getWeight(int source, int dest) {
        return adjMatr[source][dest];
    }

    /**
     * Graf objesini edge lerini ve  edge lerin weight lerini iceren bir string olarak dondurur.
     * @return graf verileri
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < adjMatr.length; ++i)
            for (int j = i; j < adjMatr[i].length; ++j)
                if (!Double.isNaN(adjMatr[i][j]))
                    result.append("Edge -> ").append(i).append(", ").append(j).append(" Weight -> ").append(adjMatr[i][j]).append("\n");
        return result.toString();
    }
}
