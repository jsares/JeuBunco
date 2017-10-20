package Generique;

import java.util.Iterator;

/**
 * Cette classe est une liste générique pour contenir des elements de type T
 */
public class Collection<T> implements Iterable<T> {
	private Node head = null;
	private Node tail = null;
	
	private class Node {
		private T item = null;
		private Node next = null;
		private Node prev = null;
		
		public Node(Node prev, Node next, T item) {
			this.setPrev(prev);
			this.setNext(next);
			this.setItem(item);
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}
	}
	
	public int count() {
		int count = 0;
		
		if (head != null) {
			Node current = head;
			do  {
				if (current.getItem() != null) {
					count++;
				}
			} while ((current = current.getNext()) != null);
		}
		
		return count;
	}
	
	public void insert(T item) {
		if (tail != null) {
			tail.setNext(new Node(tail, null, item));
			tail = tail.getNext();
		} else {
			head = new Node(null, null, item);
			tail = head;
		}
	}
	
	public void insertAfter(T specimen, T item) {
		if (head != null) {
			Node current = head;
			do  {
				if (current.getItem() == specimen) {
					Node node = new Node(current, current.getNext(), item);
					if (current.getNext() != null) {
						current.getNext().setPrev(node);
					}
					current.setNext(node);
					return;
				}
			} while ((current = current.getNext()) != null);
		}
	}
	
	public void insertBefore(T specimen, T item) {
		if (head != null) {
			Node current = head;
			do  {
				if (current.getItem() == specimen) {
					Node node = new Node(current.getPrev(), current, item);
					if (current.getPrev() != null) {
						current.getPrev().setNext(node);
					} else {
						head = node;
					}
					
					current.setPrev(node);
					return;
				}
			} while ((current = current.getNext()) != null);
		}
	}
	
	public boolean has(T specimen) {
		for (T item : this) {
			if (item == specimen) {
				return true;
			}
		}
		
		return false;
	}
	
	public T last() {
		return tail != null ? tail.getItem() : null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T> () {

			private Node current = null;
			private Node next = head;

			//retourne false vu que current.getNext = null
			@Override
			public boolean hasNext() {
				return next != null && next.getItem() != null;
			}

			@Override
			public T next() {
				current = next;
				next = current.getNext();
				return current.getItem();
			}

			@Override
			public void remove() {
				if (current != null) {
					if (current.getPrev() != null) {
						current.getPrev().setNext(current.getNext());	
					}
					
					if (current.getNext() != null) {
						current.getNext().setPrev(current.getPrev());	
					}
					
					if (head == current) {
						head = head.getNext();
					}
					
					if (tail == current) {
						tail = tail.getPrev();
					}
				}
			}
		};
	}
}
