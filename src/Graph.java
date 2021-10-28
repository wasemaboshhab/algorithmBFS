import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {

    //array of LinkedList
    // s = Initial vertex
    public static void BFS(LinkedList<Integer>[]g , int s){

        ArrayList<Integer> q = new ArrayList<>();
        int n = g.length;
        int[] color = new int[n];
        int[] distance = new int[n];
        int[] pred = new int[n];

        for (int i = 0; i < n ; i++) {
            color[i] = 0;
            distance[i] = -1;
            pred[i] = -1;
        }
        ////////////////////////////
                //init
        color[s] = 1;
        q.add(s);
        distance[s] = 0;
        ////////////////////////////


        while (!q.isEmpty()) {
            int v = q.remove(0);
            System.out.print(v + " ,");
            for (int u : g[v]) {
                if (color[u] == 0) {
                    color[u] = 1;
                    q.add(u);
                    distance[u] = distance[v] + 1;
                    pred[u] = v;
                }
            }
            color[v] = 2;
        }
        System.out.println("\ncolor = " + Arrays.toString(color));
        System.out.println("distance = " + Arrays.toString(distance));
        System.out.println("pred = " + Arrays.toString(pred));
    }

    public static void main(String[] args) {


                    //init
        LinkedList<Integer>[] g = new LinkedList[7];
        for (int i = 0; i < g.length; i++) {
            g[i] = new LinkedList<>();
        }

        //init Neighbors of Vertices
        g[0].add(3);g[0].add(1);
        g[1].add(2);g[1].add(0);g[1].add(3);
        g[2].add(3);g[2].add(1);
        g[3].add(0);g[3].add(1); g[3].add(2);g[3].add(4);
        g[4].add(5); g[4].add(3);
        g[5].add(4);g[5].add(6);
        g[6].add(5);

        BFS(g, 2);



    }


}
