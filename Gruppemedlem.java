/*

Programmering høst 2013
Obligatorsik Oppgave 3
Oppgave 1a

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

Klassen Gruppemedlem skal ha to datafelt for henholdsvis navn og klasse.
Videre skal den ha:
	- en konstruktør som mottar datafeltenes initialverdier via parametre.
	- get-metoder for datafeltene

Definer klassen Gruppemedlem.

*/

public class Gruppemedlem
{
	private String navn, klasse;

	public Gruppemedlem( String n, String k )
	{
		navn = n;
		klasse = k;
	}

	public String getNavn()
	{
		return navn;
	}

	public String getKlasse()
	{
		return klasse;
	}

}	// end of class Gruppemedlem