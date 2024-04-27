package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Multisolver {

    static String sPath;
    static int sPathWt = Integer.MAX_VALUE;
    static String lPath;
    static int lPathwt = Integer.MIN_VALUE;
    static String cPath;
    static int cPathWt = Integer.MAX_VALUE;
    static String fPath;
    static int fPathWt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    private static class Edge {
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) {
            return true;
        }

        visited[src] = true;
        for (Edge a : graph[src]) {
            if (!visited[a.nbr]) {
                boolean b = hasPath(graph, a.nbr, dest, visited);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void allPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if (src == dest) {
            System.out.println(psf + " ");
            return;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) allPaths(graph, edge.nbr, dest, visited, psf + edge.nbr + " ");
        }
        visited[src] = false;
    }

    public static void multisolver(ArrayList<Edge>[] graph,
                                   int src,
                                   int dest,
                                   boolean[] visited,
                                   int criteria,
                                   int k,
                                   String psf,
                                   int wsf
    ) {
        if (src == dest) {
            if (wsf < sPathWt) {
                sPathWt = wsf;
                sPath = psf;
            }

            if (wsf > lPathwt) {
                lPathwt = wsf;
                lPath = psf;
            }

            if (wsf > criteria && wsf < cPathWt) {
                cPathWt = wsf;
                cPath = psf;
            }
            if (wsf < criteria && wsf > fPathWt) {
                fPathWt = wsf;
                fPath = psf;
            }

            if (pq.size() < k) {
                pq.add(new Pair(wsf, psf));
            } else {
                if (wsf > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(wsf, psf));
                }
            }

            return;
        }

        for (Edge edge : graph[src]) {
            if (!visited[edge.nbr]) {
                multisolver(graph,
                        edge.nbr,
                        dest,
                        visited,
                        criteria,
                        k,
                        psf + edge.nbr + " ",
                        wsf + edge.wt);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int vtces = 7;
        int edge = 8;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }
        String[] e1 = {"0 1 10", "1 2 10", "2 3 10", "0 3 10", "3 4 10", "4 5 10", "5 6 10", "4 6 10"};
        String[] e2 = {"0 1 10", "1 2 10", "2 3 10", "0 3 40", "3 4 2", "4 5 3", "5 6 3", "4 6 8", "2 5 5"};
        for (int i = 0; i < e2.length; i++) {
            String[] input = e2[i].split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int wt = Integer.parseInt(input[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        boolean[] visited = new boolean[vtces];
        allPaths(graph, 0, 6, visited, 0 + " ");
    }
}
