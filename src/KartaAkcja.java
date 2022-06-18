public class KartaAkcja extends Karta{
    String opis;
    KartaAkcja(String opis){
        this.nazwa="akcja";
        this.opis=opis;
    }
    public void wypisz(){
        System.out.println(opis);
    }
}
