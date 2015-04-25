package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KOKO = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int uusiKoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        alkiot = new int[KOKO];
        this.taulukonAlustus();
        this.uusiKoko = OLETUSKASVATUS;
    }

    public IntJoukko(int koko) {
        if (koko < 0) {
            return;
        }
        alkiot = new int[koko];
        this.taulukonAlustus();
        this.uusiKoko = OLETUSKASVATUS;

    }

    public IntJoukko(int koko, int kasvatuskoko) {
        if (koko < 0 || kasvatuskoko < 0) {
            throw new IllegalArgumentException("Kapasitteetti väärin");
        }
        alkiot = new int[koko];
        this.taulukonAlustus();
        this.uusiKoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            alkiot[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (onkoTaynna()) {
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        boolean kuuluuJoukkoon = false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                kuuluuJoukkoon = true;
                break;
            }
        }
        return kuuluuJoukkoon;
    }

    public boolean poista(int luku) {
        int indeksi = etsiLuvunIndeksi(luku);
        if (indeksi != -1) {
            siirraAlkiotAlkuun(indeksi);
            alkioidenLkm--;
            return true;
        }
        return false;

    }

    private int etsiLuvunIndeksi(int luku) {
        int indeksi = -1;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                indeksi = i; //siis luku löytyy tuosta kohdasta :D
                alkiot[indeksi] = 0;
                break;
            }
        }
        return indeksi;
    }

    private void kasvataTaulukkoa() {
        int[] tmpArray = new int[alkiot.length];
        System.arraycopy(alkiot, 0, tmpArray, 0, alkiot.length);
        alkiot = new int[alkioidenLkm + uusiKoko];
        System.arraycopy(tmpArray, 0, alkiot, 0, tmpArray.length);
    }

    private void siirraAlkiotAlkuun(int aloitusKohta) {
        int kohta = aloitusKohta;
        int apu;

        for (int j = kohta; j < alkioidenLkm - 1; j++) {
            apu = alkiot[j];
            alkiot[j] = alkiot[j + 1];
            alkiot[j + 1] = apu;
        }
    }

    public int getAlkioidenLkm() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        String tuotos = "{";
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            tuotos += alkiot[i];
            tuotos += ", ";
        }
        tuotos += alkiot[alkioidenLkm - 1];
        tuotos += "}";
        return tuotos;

    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(alkiot, 0, taulu, 0, taulu.length);
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }

        return erotus;
    }

    private void taulukonAlustus() {
        for (int i = 0; i < alkiot.length; i++) {
            alkiot[i] = 0;
        }
        alkioidenLkm = 0;
    }

    private boolean onkoTaynna() {
        if (alkiot.length == alkioidenLkm) {
            return true;
        }
        return false;
    }
}