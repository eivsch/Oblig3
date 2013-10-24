/*

Programmering h�st 2013
Obligatorsik Oppgave 3
Oppgave 2

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

a) Programmer metoden private int erRegistrert( int nr ) { ... }.
b) Programmer metoden public void innlevering( Oblig oppg ) { ... }.
c) Programmer metoden public int ikkeGodkjent() { ... }.
d) Programmer metoden toString() { ... }.

*/

public class Student
{
  private String navn, klasse;
  private Oblig[] levert;

  public Student( String n, String k, int antObliger )
  {
    navn = n;
    klasse = k;
    levert = new Oblig[antObliger];
  }


  // get-metoder for navn og klasse
  public String getNavn()
  {
		return navn;
	}

	public String getKlasse()
	{
		return klasse;
	}


  private int erRegistrert( int nr )
  {
     //< Unders�ker om studenten allerede har registrert en oblig med
     //  nummer lik den innkomne parameteren nr. Hvis s� er tilfelle skal
     //  indeksen returneres. I motsatt fall returneres -1.  >

		for( int i = 0; i < levert.length; i++ )
		{
			if( levert[i] == null )
				return -1;
			else if( levert[i].getObligNr() == nr )
				return i;
		}
		return -1;
	}



  public void innlevering( Oblig oppg )
  {
    //< Hvis det tidligere er levert en oppgave med samme nummer som
    //  den innkomne parameteren oppg har, og som IKKE har v�rt
    //  godkjent tidligere, skal den nye oppgaven erstatte den gamle.
    //  Hvis obligen oppg ikke har v�rt levert tidligere skal den plasseres
    //  p� f�rste ledige plass. >

		for( int i = 0; i < levert.length; i++ )
		{
			if( levert[i] == null)
			{
				levert[i] = oppg;
				break;
			}

			if( levert[i].getObligNr() == oppg.getObligNr() && ( levert[i].getGodkjent() ) )
			  break;
			else if (levert[i].getObligNr() == oppg.getObligNr() && !( levert[i].getGodkjent() ) )
			{
				levert[i] = oppg;
				break;
			}
		}
  }



	public int ikkeGodkjent()
	{
   	//< Returnerer antall oppgaver som enten ikke er godkjent eller ikke er
    //  levert inn. ( Antall oppgaver som m� v�re godkjent tilsvarer lengden
    //  p� arrayen. ) >
		int antall = 0;

		for( int i = 0; i < levert.length; i++ )
		{
			if (levert[i] == null)
			{
				antall++;
			}
			else if( !( levert[i].getGodkjent() ) )
				antall++;
		}

		return antall;
	}



  public String toString()
  {
    //< Returnerer studentens navn og klasse, samt opplysninger om hvilke
    //  oppgaver som er godkjent, om vedkommende kan g� opp til eksamen, og
    //  eventuelt hvor mange oppgaver som mangler for � kunne g� opp til eksamen.  >

    String output = navn + ", klasse: " + klasse + "\n";

    for( int i =  0; i < levert.length; i++ )
    {
			if ( levert[i] == null)
				break;
			else if( levert[i].getGodkjent() )
				output+= "Obligatorisk oppgave nr. " + ( levert[i].getObligNr() ) + " er godkjent\n";
			else if( !(levert[i].getGodkjent() ) )
				output+= "Obligatorisk oppgave nr. " + ( levert[i].getObligNr() ) + " er ikke godkjent\n";
	  }

	  if ( ikkeGodkjent() > 0)
	  {
	  	output+= navn + " kan ikke g� opp til eksamen\n";
	  	output+= ikkeGodkjent() + " oppgaver mangler for � kunne g� opp til eksamen\n\n";
		}
	  else
    	output+= navn + " kan g� opp til eksamen\n\n";

    return output;
  }

}  // end of class Student