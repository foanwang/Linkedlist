public class SingleLinkedList<T> extends LinkedList<T >{

	@Override
	public void addFirst(T value) {
		// TODO Auto-generated method stub
		Node<T> newnode = new Node(value);
		if(count == 0){
			this.first = newnode;
			this.last = newnode;
		}else if(count == 1){
			this.first = newnode;
			newnode.setNext(this.last);
		}else{
			newnode.setNext(this.first);
			this.first = newnode;
		}
		++count;
	}

	@Override
	public void addLast(T value) {
		// TODO Auto-generated method stub
		Node<T> newnode = new Node(value);
		if (count == 0){
			this.first = newnode;
			this.last = newnode;
		}else if(count == 1){
			this.last = newnode;
			this.first.setNext(this.last);
		}else{
			this.last.setNext(newnode);
			this.last = newnode;
		}
		++count;
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		if(count==0){
			throw new ArrayIndexOutOfBoundsException();
		}else if(count == 1){
			this.first =null;
			this.last = null;
			this.count = 0;
		}else{
			this.first = this.first.getNext();
			count--;
		}
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		if(count==0){
			throw new ArrayIndexOutOfBoundsException();
		}else if(count == 1){
			this.first =null;
			this.last = null;
			this.count = 0;
		}else{
			Node<T> preiousnode = this.findPerviousNode(this.last);
			preiousnode.setNext(null);
			this.last = preiousnode;
			count--;
		}
	}

	@Override
	public void addBefore(Node<T> node, int value) {
		// TODO Auto-generated method stub
		Node<T> newnode = new Node(value);
		if(count == 0){
			throw new ArrayIndexOutOfBoundsException();
		}else if (count==1){
			this.first =  newnode;
			newnode.setNext(this.last);
		}else{
			Node<T> previousNode =  this.findPerviousNode(node);
			previousNode.setNext(newnode);
			newnode.setNext(node);
		}
		count++;
	}

	@Override
	public void addAfter(Node<T> node, int value) {
		// TODO Auto-generated method stub
		Node<T> newnode = new Node(value);
		if(count == 0){
			throw new ArrayIndexOutOfBoundsException();
		}else if (count==1){
			this.last =  newnode;
			this.first.setNext(this.last);
		}else{
			if(node.getNext()==null){
				this.last =  newnode;
			}else{
				newnode.setNext(node.getNext());
			}
			node.setNext(newnode);
		}
		count++;
	}

	@Override
	public void remove(Node<T> node) {
		// TODO Auto-generated method stub
		if(count == 0){
			throw new ArrayIndexOutOfBoundsException();
		}else if(this.first ==node){
			this.removeFirst();;
		}else if(this.last == node){
			this.removeLast();
		}else{
			Node<T> perviousNode = this.findPerviousNode(node);
			perviousNode.setNext(node.getNext());
			count--;
		}
		
	}
	
	public Node<T> findPerviousNode(Node<T> node){
		Node<T> perviosuNode = first;
		if(perviosuNode!=null){
			while(perviosuNode.getNext()!=node){
				perviosuNode = perviosuNode.getNext();
			}
		}	
		return perviosuNode;
	}
	
	
	public void printNode(){
		System.out.println("list count:"+count);		
		String linkeds= "";
		Node<T> node = null;
		if (count == 0){
			System.out.println("linked is empty");
		}else{
			node = this.first;
		}	
		
		for(int i = 1 ;i < count+1; i++){
			if(node != null){
				linkeds += "{ node i = " + i + "  value = "+ node.getValue()+" }";		
				node = node.getNext();
				if (node != null){
					linkeds += " -> ";
				}
			}
		}
		System.out.println(linkeds);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SingleLinked test starting");
		SingleLinkedList test = new SingleLinkedList(); 
		test.addFirst(1);
		test.printNode();
		test.addLast(2);
		test.printNode();
		test.addBefore(test.last, 3);
		test.printNode();
		test.addAfter(test.first, 4);
		test.printNode();
		test.removeFirst();
		test.printNode();
		test.removeLast();
		test.printNode();
		test.addFirst(5);
		test.printNode();
		test.addFirst(6);
		test.printNode();
		test.addLast(7);
		test.printNode();
		test.remove(test.first);
		test.printNode();
	}

}
