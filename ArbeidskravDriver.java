/*

Programmering høst 2013
Obligatorsik Oppgave 3
Oppgave 4

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

f) Programmer klassen ArbeidskravDriver som inneholder programmets main-metode.

*/

public class ArbeidskravDriver
{
  //Deklarerer nødvendige konstanter
	public static final int ANTSTUDENTER = 20;
	public static final int ANTOBLIGER = 4;
  public static final int ANTPRGRUPPE = 3;
  public static final String FAG = "Programmering";

	public static void main (String[]args)
	{
		new ArbeidskravGUI(FAG, ANTSTUDENTER, ANTOBLIGER, ANTPRGRUPPE);
	}
}//end of class ArbeidskravDriver