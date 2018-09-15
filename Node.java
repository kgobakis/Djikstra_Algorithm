public class Node implements Comparable<Node>{

    int index;
    Node parent;
    int distance;
 
    
    public int compareTo(Node other) {
    	if(other.distance > this.distance)  return -1;
    	else if (other.distance < this.distance) return 1;
    	else return 0;
    }

    public Node(int i) {
	index = i;
	
    }

}