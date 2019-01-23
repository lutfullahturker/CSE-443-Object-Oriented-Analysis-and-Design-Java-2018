import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GraphAlgorithms {

    /**
     * verilen grafin incidence  matrix ini bulur ve  2 boyutlu double array olarak return eder.
     * @param graph  incidence matrix i bulunacak graf
     * @return matrix
     */
    public double[][] getIncidenceMatrix(Graph graph) {
        double[][] retVal;
        Edge[] edges = graph.getEdges();
        retVal = new double[graph.getVertexNum()][edges.length];

        for (double[] row : retVal)
            Arrays.fill(row, 0.0);
        for (int i = 0; i < edges.length; ++i) {
            double weight = Double.isNaN(edges[i].getWeight()) ? 0 : edges[i].getWeight();
            retVal[edges[i].getDest()][i] += weight;
            retVal[edges[i].getSource()][i] += weight;
        }
        return retVal;
    }

    /**
     * Kruskal MST Algoritmasinin implementasyonu
     *
     */
    public Graph getMinimumSpanningTree(Graph graph) {
        Edge[] edges = Arrays.copyOf(graph.getEdges(), graph.getEdges().length);
        Arrays.sort(edges, Comparator.comparingDouble(Edge::getWeight));
        ArrayList<Edge> newEdges = new ArrayList<>();
        for (Edge e : edges) {
            newEdges.add(e);
            if (isCyclic(newEdges, graph.getVertexNum()))
                newEdges.remove(e);
        }
        return new Graph(newEdges.toArray(new Edge[0]), graph.getVertexNum());
    }

    /**
     * https://www.geeksforgeeks.org/union-find
     * adresinden yararlanilmistir.
     */
    private boolean isCyclic(ArrayList<Edge> edges, int V) {
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        for (Edge edge : edges) {
            int x = find(parent, edge.getSource());
            int y = find(parent, edge.getDest());
            if (x == y)
                return true;
            union(parent, x, y);
        }
        return false;
    }

    /**
     * https://www.geeksforgeeks.org/union-find
     * adresinden yararlanilmistir.
     */
    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    /**
     * https://www.geeksforgeeks.org/union-find
     * adresinden yararlanilmistir.
     */
    private void union(int[] parent, int x, int y) {
        int xx = find(parent,x);
        int yy = find(parent,y);
        parent[xx] = yy;
    }
}
