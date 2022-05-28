import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Vertex>> map = new HashMap<>();

    public MyGraph() {
        this.undirected = true;
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    public int getVerticesCount() {
        return map.keySet().size();
    }

    public int getEdgesCount() {
        var temp = 0;
        for(Vertex v: map.keySet()) {
            temp+= map.get(v).size();
        }
        return temp/2;
    }

    public boolean hasVertex(Vertex v) {
        if (!map.containsKey(v)) {
            return false;
        } else return true;
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if(!hasVertex(source)) {
            return false;
        }
        if(!map.get(source).contains(dest)) {
            return false;
        }
        return  true;
    }

    public MyGraph<Vertex> adj() {
        for (Vertex v : map.keySet()) {
            System.out.println("Vertex: " + v + " ");
            System.out.println("Edge(s): " + map.get(v) + " ");
        }
        return null;
    }
    public MyGraph<Vertex> adj(Vertex v) {
        if(map.containsKey(v)) {
            System.out.println("Vertex: " + v);
            System.out.println("Edge(s): " + map.get(v));
        } else {
            System.out.println("Empty bitch! Have not " + v + " in this Graph.");
        }
        return null;
    }

    public void removeVertex(Vertex v) {
        for (Vertex vertex : map.keySet()) {
            if(map.get(vertex).contains(v)) {
                List<Vertex> temp =  map.get(vertex);
                temp.remove(v);
            }
        }
        map.remove(v);
    }
}
