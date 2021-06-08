package Tree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TreeOrNot {
    static int vertex;
    static LinkedList<Integer> adj[];

    static void Graph(int v) {
        vertex = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    static void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    static boolean isCyclic(int v, boolean visited[], int parent) {
        visited[v] = true;
        Integer i;
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                if (isCyclic(i, visited, v)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    static boolean isTree() {
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
        }
        if (isCyclic(0, visited, -1)) {
            return false;
        }
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Graph(5);
        addEdge(1,0);
        addEdge(0,2);
//        addEdge(2,1);
        addEdge(0,3);
        addEdge(3,4);
        System.out.println(isTree());
    }
}
