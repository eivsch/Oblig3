/*

Programmering h�st 2013
Obligatorsik Oppgave 3
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar �varsson		(s198586)
Sigurd H�lleland	(s198597)

a) Programmer metoden public void nyStudent( Student s ) { ... }.
b) Programmer metoden private int posisjon( String navn) { ... }
c) Programmer metoden public void registrer( Oppgave oppg ) { ... }
d) Programmer metoden public String godkjent( String navn) { ... }
e) Programmer metoden public String[] statusListe(String klasse) { ... }

*/

public class ObligRegister
{
  private Student[] studenter;
  private int antallObliger;




	public ObligRegister(int antStud, int antOblig)
  {
    //<  Foretar n�dvendig initialisering av datafeltene. >
    studenter = new Student[antStud];
    antallObliger = antOblig;
  }




  public void nyStudent( Student s )
  {
   	//< Setter objektet s, som metoden mottar som parameter, inn i arrayen
    //  studenter. Du kan forutsette at det er plass i arrayen.  >
		for( int i = 0; i < studenter.length; i++ )
		{
			if( studenter[i] == null )
				studenter[i] = s;
		}
	}



  private int posisjon( String navn )
  {
    //<  Returnerer array-indeksen for student med navn lik parameterverdien,
    //   i tilfelle en slik finnes. Returnerer -1 ellers.  >

    for( int i = 0; i < studenter.length; i++ )
    {
			//Gretar commit:
			if( studenter[i] == null )
				return -1;
			else if( studenter[i].getNavn().equals(navn) )
				return i;


			//Old version:
			/*
			if( studenter[i].getNavn().equals(navn) )
			return i;
			*/
		}

		return -1;
  }



  public void registrer( Oblig oppg )
  {
    //<  Registrerer oppgaven oppg p� ALLE studentene i gruppen som har levert oppgaven.
    //   Dersom noen av disse ikke p� forh�nd finnes i arrayen studenter, m� de tilf�yes
    //   i arrayen som nye studenter.  >

    //henter deltakere for oppg
    Gruppemedlem[] deltakere = new Gruppemedlem[ ( oppg.getDeltakere() ).length ];
    deltakere = oppg.getDeltakere();



    for( int i = 0; i < deltakere.length; i++ )
    {
			//dersom noen av deltakerne ikke eksisterer i student-arrayet, m� det opprettes et nytt Student objekt


			if( posisjon( deltakere[i].getNavn() ) == -1 )
			{
				Student s = new Student( deltakere[i].getNavn(), deltakere[i].getKlasse(), antallObliger );
				nyStudent( s );

				// Gretar commit:
				s.innlevering(oppg);


			}
    }

    //Old version:
    /*

    //n� vil alle studentene i oppg v�re registrert, og ha en indeks. Vi finner indeksen og registrerer obligen p� indeksen
    for(int j = 0; j < deltakere.length; j++)
    {
        studenter[posisjon( deltakere[j].getNavn() )].innlevering(oppg);

    }

    */

  }



  public String godkjent( String navn )
  {
    /*<  Returnerer opplysninger om studenten med navn lik parameterverdien,
       dvs. navn og klasse, samt opplysninger om hvilke oppgaver som er godkjent,
       og om vedkommende kan g� opp til eksamen, eventuelt hvor mange oppgaver som
       mangler for � kunne gj�re det.  >
    */

		//Gretar commit: vi m� ha en for-l�kke for hele studenter arrayen
		for( int i = 0; i < studenter.length; i++ )
		{
			if( studenter[i].getNavn().equals(navn) )
				return studenter[i].toString();
		}

		return studenter[ posisjon( navn )].toString();




		//old version:
		/*
    return studenter[ posisjon( navn )].toString();
		*/

  }

  //hjelpemetode
  private int antKlasse( String klasse )
  {
		int antall = 0;

				for( int i = 0; i < studenter.length; i++ )
				 if( (studenter[i].getKlasse()).equals(klasse) )
			antall++;

			return antall;
	}


  public String[] statusListe(String klasse)
  {
		/* <  Returner en ny array som, for hver student i klasse, inneholder opplysninger
			 om navn og klasse, samt opplysninger om hvilke oppgaver som er godkjent, og om
			 vedkommende kan g� opp til eksamen, eventuelt hvor mange oppgaver som mangler
			 for � kunne gj�re det.  >
		*/

		String[] output = new String[antKlasse(klasse)];

		for( int j = 0; j < studenter.length; j++ )
		  if( (studenter[j].getKlasse()).equals(klasse) )
				output[j] = studenter[j].toString();

		return output;
  }


}  // end of class ObligRegister