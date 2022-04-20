package tsaufgabe4;

public class RedCard extends Card
{

	public RedCard(Farbe farbe, Wert wert)
	{
		super(farbe, wert);

		if (farbe == Card.Farbe.Kreuz || farbe == Card.Farbe.Pique)
			throw new IllegalArgumentException("Falsche farbe!");
	}

}
