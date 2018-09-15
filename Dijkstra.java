import java.lang.Math;

public class Dijkstra {
	
    public void run(int n) {
	int[][] graph = new int[n][n];
	fillRandomGraph(graph);
	print(graph);
	
	Node[] myNodes = new Node[graph.length];
	for(int i = 0; i < graph.length; i++) {
	    myNodes[i] = new Node(i);
	}

	dijkstra(graph, myNodes);
	printPath(myNodes[2]);
    }

    public void print(int[][] graph) {
	for(int i = 0; i < graph.length; i++) {
	    for(int j = 0; j < graph.length; j++) {
		System.out.print(graph[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public void fillRandomGraph(int[][] graph) {
	for(int i = 0; i < graph.length; i++) {
	    for(int j = i+1; j < graph.length; j++) {
		double rand = Math.random();
		if(rand < 0.8) {
		    graph[i][j] = (int)(Math.random() * 10);
		    graph[j][i] = graph[i][j];
		}
		else{
		    graph[i][j] = 0;
		    graph[j][i] = 0;
		}
	    }
	}

    }

    public static void main(String [] args) {
	if(args.length > 0)  new Dijkstra().run(Integer.parseInt(args[0]));
	else new Dijkstra().run(6); 
    }
    
    public void dijkstra (int [][] adjmatrix, Node [] nodes) {
    	Heap heap = new Heap ();
    	for(Node current : nodes) {
    		current.distance = Integer.MAX_VALUE;
    		current.parent = null;
    		heap.add(current);
    	}
    	nodes[0].distance = 0;

    	while(heap.size() != 0) {
    		Node u = heap.remove(); //shortest path to u, not you
    		
    		for(int i = 0; i < adjmatrix.length; i ++) {
    			Node v = nodes[i];
    			
    			if(adjmatrix[u.index][i] != 0 ) {
    		
    				int newdistance = u.distance + adjmatrix[u.index][i];
 
    				if(newdistance < v.distance) {
    					v.distance = newdistance;
 					    v.parent = u;
 					    heap.decreaseKey(v, newdistance);
    					
    				}
    			
    				}
    			
    		}
    	}
    	}
    	
    
    
    public void printPath (Node node) {
    Node temp = node;
    
    while (temp.index != 0) {
    	System.out.print(temp.index + " -> ");
    	temp = temp.parent;	
    }System.out.print(temp.index + "");
  }

}