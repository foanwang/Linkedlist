public class Node<T> {
	
	protected T value;
	protected Node<T> previous;
	protected Node<T> next;
	
	public Node(T value){
		this.value = value;
	};
	
	public T getValue(){
		return this.value;
	}
	public void setValue(T value){
		this.value = value;
	}
	public Node<T> getPervious(){
		return this.previous;
	}
	public void setPervious(Node<T> node){
		this.previous = node;
	}
	public Node<T> getNext(){
		return this.next;
	}
	public void setNext(Node<T> node){
		this.next= node;
	}
}
