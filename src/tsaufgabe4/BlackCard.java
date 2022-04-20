package tsaufgabe4;

public class BlackCard extends Card
{

	public BlackCard(Farbe farbe, Wert wert)
	{
		super(farbe, wert);

		if (farbe == Card.Farbe.Herz || farbe == Card.Farbe.Karo)
			throw new IllegalArgumentException("Falsche farbe!");
	}

}
