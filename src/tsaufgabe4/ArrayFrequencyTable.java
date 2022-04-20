package tsaufgabe4;

import tsaufgabe4.AbstractFrequencyTable;
import tsaufgabe4.Element;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 *
 * @author oliverbittel
 * @since 18.3.2019
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T>
{
	private int size;
	Element<T> fqTable[];
	private final int DefaultSize = 100;
	private int modCount = 0;

	public ArrayFrequencyTable()
	{
		clear();
		this.size = 0;
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void clear()
	{
		this.fqTable = new Element[this.DefaultSize];
		modCount++;
		this.size = 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void add(T w, int f)
	{
		for (int i = 0; i < this.size; i++)
		{
			if (fqTable[i].getContent().equals(w))
			{
				fqTable[i].addFrequency(f);
				Sort(i);
				return;
			}
		}

		if (this.size >= this.fqTable.length)
		{
			Element<T>[] temp = new Element[this.size + this.DefaultSize];
			System.arraycopy(this.fqTable, 0, temp, 0, this.size);
			this.fqTable = temp;
		}

		fqTable[this.size] = new Element<T>(w, f);
		Sort(this.size);
		modCount++;
		this.size++;
	}

	private void Sort(int i)
	{
		while (i > 0)
		{
			if (this.fqTable[i - 1].getFrequency() < this.fqTable[i].getFrequency())
			{
				Element<T> tmp = this.fqTable[i - 1];
				this.fqTable[i - 1] = this.fqTable[i];
				this.fqTable[i] = tmp;
				i--;
			}
			else
				break;
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
		if (pos <= this.size && pos >= 0)
			return fqTable[pos];

		throw new IllegalArgumentException("Index out of bounds!");
	}

	@Override
	public int get(T w)
	{
		for (int i = 0; i < this.size; i++)
		{
			if (fqTable[i].getContent().equals(w))
				return fqTable[i].getFrequency();
		}

		return 0;
	}

	@Override
	public Iterator<Element<T>> iterator()
	{
		return new ArrayFrequencyTableIterator();
	}

	private class ArrayFrequencyTableIterator implements Iterator<Element<T>>
	{
		private int index = 0;
		private int expecxtedMod = modCount;

		@Override
		public boolean hasNext()
		{
			return index < size();
		}

		@Override
		public Element<T> next()
		{
			if (expecxtedMod != modCount)
				throw new ConcurrentModificationException();

			return fqTable[index++];
		}

	}
}
