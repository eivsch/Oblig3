/*

Programmering høst 2013
Obligatorsik Oppgave 3
Oppgave 1

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

Klassen Oblig representerer en enkelt obligatorisk oppgave.

*/

public class Oblig
{
  private Gruppemedlem[] gruppe;
  private int obligNr;
  boolean godkjent;

  public Oblig( Gruppemedlem[] g, int n, boolean b )
  {
    gruppe = g;
    obligNr = n;
    godkjent = b;
  }

  public Gruppemedlem[] getDeltakere()
  {
    return gruppe;
  }

  public int getObligNr()
  {
    return obligNr;
  }

  public boolean getGodkjent()
  {
    return godkjent;
  }
}  // end of class Oblig