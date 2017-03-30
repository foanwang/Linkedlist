
public abstract class LinkedList<T> {
	protected Node<T> first;
	protected Node<T> last;
	protected int count;
	
	public Node<T> getFirst(){
		return this.first;
	}
	public void setFirst(Node<T> node){
		this.first = node;
	}
	
	public Node<T> getLast(){
		return this.last;
	}
	public void setLast(Node<T> node){
		this.last = node;
	}
	
	abstract public void addFirst(T value);
	abstract public void addLast(T value);
	abstract public void removeFirst();
	abstract public void removeLast();
	abstract public void addBefore(Node<T> node, int value);
	abstract public void addAfter(Node<T> node, int value);
    abstract public void remove(Node<T> node);
}
