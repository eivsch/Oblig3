public class ArbeidskravDriver
{
	public static void main (String[]args)
	{
		//String fag, int antStudenter, int antObliger, int antPrGruppe
		String fag = "Programmering";
		int antStudenter = 20;
		int antObliger = 4;
		int antPrGruppe = 3;

		new ArbeidskravGUI(fag, antStudenter, antObliger, antPrGruppe);
	}
}