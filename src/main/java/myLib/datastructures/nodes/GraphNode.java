package myLib.datastructures.nodes;

import java.util.ArrayList;

public class GraphNode {
    public int val;
    public ArrayList<GraphNode> neighbors;
    
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}