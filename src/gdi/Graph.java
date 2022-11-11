package gdi;

import java.util.*;

public class Graph {

    String [] vertices;
    Integer [][] adjacencymatrix;
    
    void addVertex(String label) {
        if(vertices == null) {
            vertices = new String[1];
            vertices[0]= label;
            
            adjacencymatrix = new Integer[1][1];
        }
        
        else {
            String[] oldvertices =vertices;
            
            
            
            vertices = new String[vertices.length+1];
            for(int i=0; i<oldvertices.length;i++) {
                vertices[i]=oldvertices[i];
            }
            vertices[vertices.length-1]=label;
            
            Integer[][]oldadjacencymatrix=adjacencymatrix;
            adjacencymatrix = new Integer[vertices.length][vertices.length];
            
            for(int i=0; i <oldvertices.length;i++) {
                for(int j=0; j<oldvertices.length;j++) {
                    adjacencymatrix[i][j]=oldadjacencymatrix[i][j];
                }
            }
            
        }
    }
    
    void addEdge(String a, String b, int value) {
        adjacencymatrix[getVertex(a)][getVertex(b)]=value;
    }
    
    void removeEdge(String a, String b) {
        adjacencymatrix[getVertex(a)][getVertex(b)]=null;
    }
    
    
    int getVertex(String label) {
        for(int i=0; i<vertices.length;i++) {
            if(label.equals(vertices[i])) {
                return i;
            }
        }
        return -1;
    }
    
    String depthFirstSearch(String label) {
        SinglyLinkedList used = new SinglyLinkedList();
        return depthFirstSearch(getVertex(label), used);
    }

    private String depthFirstSearch(int vertex, SinglyLinkedList used) {
        if(used.contains(vertex)) {
            return "";
        }
        else {
            used.add(vertex);
            String result = vertices[vertex];
            int[] nextVertices = getNextVertices(vertex);
            for(int i=0; i<nextVertices.length; i++) {
                result = result + depthFirstSearch(nextVertices[i], used);
            }
            return result;
        }
    }
  
    
   //Breitensuche    
    String breadthFirstSearch(String start) {
        SinglyLinkedList used = new SinglyLinkedList();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(getVertex(start));
        String result = start;
        while(!queue.isEmpty())
        {
            int vertex = queue.poll();
            if(!used.contains(vertex)) {
                used.add(vertex);
                int[] nextVertices = getNextVertices(vertex);
                for(int i=0; i<nextVertices.length; i++) {
                    result = result + vertices[nextVertices[i]];
                    queue.offer(nextVertices[i]);
                }
            }
            
        }
        return result;
    }
    
    int[] getNextVertices(int vertex) {
        int size = 0;
        for(int i=0; i<vertices.length; i++) {
            if(adjacencymatrix[vertex][i] != null) {
                size++;
            }   
        }
        
        int[] result = new int[size];
        int j = 0;
        for(int i=0; i<vertices.length; i++) {
            if(adjacencymatrix[vertex][i] != null) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }
    
    Integer[] dijkstra(String start) {
        Integer[] result = new Integer[vertices.length];
        int vertex = getVertex(start);
        Integer[][] table = new Integer[vertices.length][vertices.length];
        table[0][vertex] = 0;
        for(int i = 1; i < vertices.length; i++){
                int[] next = getNextVertices(vertex);
                for(int k = 0; k < next.length; k++){
                    int distance = adjacencymatrix[vertex][next[k]] + table[i-1][vertex];
                    if(table[i-1][next[k]] == null || table[i-1][next[k]] > distance) {
                        table[i][next[k]] = distance;
                    }
                }
                for(int j = 0; j < vertices.length; j ++){
                    if(table[i][j] == null) table[i][j] = table[i-1][j];
                }
            }
        for(int i = 0; i < vertices.length; i++) result[i] = table[table.length-1][i];
        return result;
    }
    
}
