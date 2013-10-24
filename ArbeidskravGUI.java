/*

Programmering høst 2013
Obligatorsik Oppgave 3
Oppgave 4

Gruppemedlemer:
Eivind Schulstad	(s198752)
Gretar Ævarsson		(s198586)
Sigurd Hølleland	(s198597)

a) Programmer metoden private Gruppemedlem[] lesGruppe(){ ... }
b) Programmer metoden public void registrer() { ... }
c) Programmer metoden public void sjekkGodkjenning() { ... }
d) Programmer metoden public void skrivListe() { ... }
e) Programmer metoden void actionPerformed( ActionEvent e ){ ... }

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ArbeidskravGUI extends JFrame implements ActionListener
{
  private JTextField person, obligNr, kl;
  private JTextField[] navn, klasse;
  private JButton reg, sjekk, status;
  private JTextArea output;
  private ObligRegister kartotek;
  private JCheckBox godkjent;

  //hjelpevariabel for antall personer i en gruppe
	private int antallPerGruppe;

  public ArbeidskravGUI(String fag, int antStudenter, int antObliger, int antPrGruppe )
  {
    super( fag + " - Arbeidskrav" );

    kartotek = new ObligRegister(antStudenter, antObliger);

    person = new JTextField( 10 );
    kl = new JTextField( 10 );
    obligNr =  new JTextField( 1 );

    navn = new JTextField[ antPrGruppe];
    klasse = new JTextField[ antPrGruppe ];

    for( int i = 0; i < navn.length; i++ )
    {
      navn[ i ] = new JTextField( 20 );
      klasse[ i ] = new JTextField( 5 );
    }

    reg = new JButton( "Innlevering" );
    sjekk =  new JButton( "Sjekk godkjenning for student: " );
    status = new JButton( "Liste over godkjente i klasse: ");
    godkjent = new JCheckBox( "Godkjent" );
    output = new JTextArea( 35, 35 );

    reg.addActionListener( this );
    sjekk.addActionListener( this );
    status.addActionListener( this );

    Container c = getContentPane();
    c.setLayout( new FlowLayout() );

    for ( int i = 0; i < navn.length; i++ )
    {
      c.add( new JLabel( "Navn: " ) );
      c.add( navn[i] );
      c.add( new JLabel( "Klasse: " ) );
      c.add( klasse[i] );
    }

    c.add( new JLabel( "Obligatorisk oppgave nr: " ) );
    c.add( obligNr );
    c.add( godkjent );
    c.add( reg );
    c.add( sjekk );
    c.add( person );
    c.add( status );
    c.add( kl );
    c.add( new JScrollPane( output) );

    setSize( 420, 800 );
    setVisible( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

    antallPerGruppe = antPrGruppe;
  }


  private Gruppemedlem[] lesGruppe()   // hjelpemetode
  {
    /*<  Metoden skal opprette og returnere en array, av typen Gruppemedlem,
       som inneholder objekter tilsvarende de personene som deltar i gruppearbeidet.
       Legg merke til at tekstfeltene det skal leses fra er lagt inn i arrayene
       navn og klasse.  >
    */

    Gruppemedlem[] gruppe = new Gruppemedlem[antallPerGruppe];

    for( int i = 0; i < gruppe.length; i++ )
    {
			if(navn[i].getText().equals(""))
			{
			  return gruppe;
			}

			Gruppemedlem g = new Gruppemedlem( navn[i].getText(), klasse[i].getText() );
			gruppe[i] = g;
		}

		return gruppe;
  }



  public void registrer()
  {
    /*<  Registrerer en innlevering av en oblig utfra  data i skjermbildets øvre halvdel.
       Hvorvidt oppgaven er godkjent eller ikke, kan avleses ved hjelp av setningen:
       boolean b = godkjent.isSelected();  >
    */
    Oblig oppgave = new Oblig( lesGruppe(), Integer.parseInt( obligNr.getText() ), godkjent.isSelected() );
    kartotek.registrer( oppgave );
  }



  public void sjekkGodkjenning()
  {
    /*<  Leser inn navn (fra tekstfeltet person) og skriver i tekstområdet output opplysninger
       om hvilke oppgaver som er godkjent, og om vedkommende kan gå opp til eksamen,
       eventuelt hvor mange oppgaver som mangler for å kunne gjøre det.  >
    */
    String navn = person.getText();
    output.setText( kartotek.godkjent(navn) );
  }

  public void skrivListe()
  {
    /*<  Skriver i tekstområdet output en liste over alle registrerte opplysninger om
       studenter i en bestemt klasse (fra tekstfeltet kl).  >
    */
    String[] liste = kartotek.statusListe( kl.getText() );
    output.setText("");
    for( int i = 0; i < liste.length; i++ )
			output.append( liste[i] );
  }



  public void actionPerformed( ActionEvent e )
  {
    //< Metoden skal sørge for at riktig oppgave utføres avhengig av knappen det er klikket på >
    if (e.getSource() == reg)
      registrer();
    else if (e.getSource() == sjekk)
      sjekkGodkjenning();
    else if (e.getSource() == status)
      skrivListe();

  }
}  // end of class ArbeidskravGUI