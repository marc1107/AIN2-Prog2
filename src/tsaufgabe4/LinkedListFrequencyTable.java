package tsaufgabe4;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	private int modCount;

	public LinkedListFrequencyTable()
	{
		modCount = 0;
		clear();
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public void clear()
	{
		this.head = new Node<T>(new Element<T>(null, 0), null, null);
		this.tail = new Node<T>(new Element<T>(null, 0), this.head, null);
		this.head.next = this.tail;
		this.modCount++;
		this.size = 0;
	}

	@Override
	public void add(T w, int f)
	{
		Node<T> n = this.head.next;
		while (n != this.tail)
		{
			if (n.data.getContent().equals(w))
			{
				n.data.addFrequency(f);
				Sort(n);
				return;
			}
			n = n.next;
		}

		n = n.prev;

		Node<T> newNode = new Node<T>(new Element<T>(w, f), n, this.tail);
		n.next = newNode;
		this.tail.prev = newNode;

		Sort(newNode);

		this.modCount++;
		this.size++;
	}

	private void Sort(Node<T> n)
	{
		if (n.prev == head)
			return;

		while (n.prev != this.head && n.prev.data.getFrequency() < n.data.getFrequency())
		{
			if (n.next != null)
			{
				// Aushaengen
				n.prev.next = n.next;
				n.next.prev = n.prev;
			}
			else
			{
				// Aushaengen
				n.prev.next = null;
			}

			// Einhaengen
			Node<T> nPre = n.prev;

			n.prev = nPre.prev;
			n.next = nPre;

			nPre.prev.next = n;
			nPre.prev = n;
		}
	}

	@Override
	public void add(T w)
	{
		this.add(w, 1);
	}

	@Override
	public Element<T> get(int pos)
	{
		if (pos < 0 || pos > this.size)
			throw new IndexOutOfBoundsException();

		Node<T> current = this.head.next;
		for (int i = 0; i < pos; i++)
		{
			current = current.next;
		}
		return current.data;
	}

	@Override
	public int get(T w)
	{
		Node<T> current = this.head.next;

		while (!current.data.getContent().equals(w))
		{
			current = current.next;

			if (current == this.tail)
				return 0;

		}
		return current.data.getFrequency();
	}

	static class Node<T>
	{
		Element<T> data;
		Node<T> prev;
		Node<T> next;

		public Node(Element<T> data, Node<T> prev, Node<T> next)
		{
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	@Override
	public Iterator<Element<T>> iterator()
	{
		return new LinkedListFrequencyTableIterator();
	}

	private class LinkedListFrequencyTableIterator implements Iterator<Element<T>>
	{
		private Node<T> current = head;
		private int expectedMod = modCount;

		@Override
		public boolean hasNext()
		{
			return current.next != tail;
		}

		@Override
		public Element<T> next()
		{
			if (expectedMod != modCount)
				throw new ConcurrentModificationException();

			current = current.next;
			return current.data;
		}

	}
}
