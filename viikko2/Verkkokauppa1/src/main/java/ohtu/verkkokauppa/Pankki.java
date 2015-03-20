package ohtu.verkkokauppa;

public class Pankki implements PankkiInterface {

    private Kirjanpito kirjanpito;

    public Pankki(Kirjanpito kirjanpito1) {
        kirjanpito = kirjanpito1;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tililta + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
