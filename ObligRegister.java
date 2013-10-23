/*

Programmering høst 2013
Obligatorsik Oppgave 3
Oppgave 3

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

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
    //<  Foretar nødvendig initialisering av datafeltene. >
    studenter = new Student[antStud];
    antallObliger = antOblig;
  }




  public void nyStudent( Student s )
  {
   	//< Setter objektet s, som metoden mottar som parameter, inn i arrayen
    //  studenter. Du kan forutsette at det er plass i arrayen.  >
       //Eivind commit
		for( int i = 0; i < studenter.length; i++ )
		{
			if (studenter[i] == null)
			{
			  studenter[i] = s;
              break;
		    }
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
    //<  Registrerer oppgaven oppg på ALLE studentene i gruppen som har levert oppgaven.
    //   Dersom noen av disse ikke på forhånd finnes i arrayen studenter, må de tilføyes
    //   i arrayen som nye studenter.  >

    //henter deltakere for oppg
    Gruppemedlem[] deltakere = new Gruppemedlem[ ( oppg.getDeltakere() ).length ];
    deltakere = oppg.getDeltakere();



    for( int i = 0; i < deltakere.length; i++ )
    {
			//dersom noen av deltakerne ikke eksisterer i student-arrayet, må det opprettes et nytt Student objekt


			if( posisjon( deltakere[i].getNavn() ) == -1 )
			{
				Student s = new Student( deltakere[i].getNavn(), deltakere[i].getKlasse(), antallObliger );
				nyStudent( s );

				// Gretar commit:
				s.innlevering(oppg);
			}

            //eivind commit - hvis studenten finnes så levers oppg
			else if ( posisjon( deltakere[i].getNavn() ) != -1 )
			{
               studenter[posisjon( deltakere[i].getNavn() )].innlevering(oppg);
			}

    }

    //Old version:
    /*

    //nå vil alle studentene i oppg være registrert, og ha en indeks. Vi finner indeksen og registrerer obligen på indeksen
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
       og om vedkommende kan gå opp til eksamen, eventuelt hvor mange oppgaver som
       mangler for å kunne gjøre det.  >
    */

		//Gretar commit: vi må ha en for-løkke for hele studenter arrayen
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
			 vedkommende kan gå opp til eksamen, eventuelt hvor mange oppgaver som mangler
			 for å kunne gjøre det.  >
		*/

		String[] output = new String[antKlasse(klasse)];

		for( int j = 0; j < studenter.length; j++ )
		  if( (studenter[j].getKlasse()).equals(klasse) )
				output[j] = studenter[j].toString();

		return output;
  }


}  // end of class ObligRegister
