import java.util.ArrayList;
import java.util.List;

public class Gracz {

    String nazwa;
    boolean kopacz;
    int wiek;
    boolean czyGraczToKomputer;

    List<Karta> karty;
    List<Karta> ban;
    Gracz(int wiek, String nazwa, boolean AI){
        this.nazwa=nazwa;
        this.wiek=wiek;
        this.czyGraczToKomputer=AI;
        this.karty= new ArrayList<>();
        this.ban= new ArrayList<>();

    }
    void dobierzKarte(List<Karta> talia){
        Karta tmp=talia.remove(talia.size()-1);
        karty.add(tmp);
    }
    void zagrajKarte(){}

    public void pokazKarty() {
        for(int i=0; i<karty.size(); i++){
            System.out.println(i + "." + karty.get(i).nazwa);
            if(karty.get(i).nazwa.equals("tunel")){
                karty.get(i).wypisz();
                    }
        }
    }

}