package tsaufgabe4;

import tsaufgabe4.Element;
import tsaufgabe4.FrequencyTable;

import java.util.Iterator;

/**
 *
 * @author Tim Koehler
 * @since 15.4.2019
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T>
{
	@Override
	public boolean isEmpty()
	{
		return this.size() == 0;
	}

	@Override
	public void addAll(FrequencyTable<? extends T> fq)
	{
		for (Element<? extends T> element : fq)
		{
			this.add(element.getContent(), element.getFrequency());
		}

	}

	@Override
	public void copyMostFrequent(FrequencyTable<? super T> fq)
	{
		for (Element<T> element : this)
		{
			if (element.getFrequency() == this.get(0).getFrequency())
				fq.add(element.getContent(), element.getFrequency());
			else
				break;
		}
	}

	@Override
	public void copyLeastFrequent(FrequencyTable<? super T> fq)
	{
		Iterator<Element<T>> ite = this.iterator();

		while (ite.hasNext())
		{
			Element<T> element = ite.next();
			if (element.getFrequency() == this.get(this.size() - 1).getFrequency())
			{
				fq.add(element.getContent(), element.getFrequency());
			}
		}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * 
	 * @return String-Darstellung.
	 */
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder("");
		s.append("{");
		for (int i = 0; i < this.size(); i++)
		{
			s.append(this.get(i)).append(", ");
		}
		s.append("} size = ").append(this.size());

		return s.toString();
	}
}