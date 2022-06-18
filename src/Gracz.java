import java.util.ArrayList;
import java.util.List;

public class Gracz {

    String nazwa;
    boolean kopacz;
    boolean lampa, kilof, wozek;
    int wiek;
    boolean czyGraczToKomputer;

    List<Karta> karty;

    Gracz(int wiek, String nazwa, boolean AI){
        this.nazwa=nazwa;
        this.wiek=wiek;
        this.czyGraczToKomputer=AI;
        this.karty= new ArrayList<>();
        this.lampa=true;
        this.kilof=true;
        this.wozek=true;
    }
    void dobierzKarte(List<Karta> talia){
        Karta tmp=talia.remove(talia.size()-1);
        karty.add(tmp);
    }
    void zagrajKarte(){}

    public void pokazKarty() {
        for(int i=0; i<karty.size(); i++){
            System.out.println(i + "." + karty.get(i).nazwa);
            karty.get(i).wypisz();
        }
    }

}
