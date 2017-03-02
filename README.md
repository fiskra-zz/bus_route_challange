# bus_route_challange
This is a small application 
Hello 



```
public Node reverse(Node node){
		Node curr = node;
		Node prev = null; 
		Node next = null;
		
		while(curr!=null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
  
```
