import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gra {
    int kopacze;
    int sabotaz;
    String zakrytaKarta;
    int liczbaKartNaRece;
    Gra(int liczbaGraczy, int zakrytaKarta){
        switch(liczbaGraczy){
            case 3:
                kopacze=3;
                sabotaz=1;
                break;
            case 4:
                kopacze=4;
                sabotaz=1;
                break;
            case 5:
                kopacze=4;
                sabotaz=2;
                break;
            case 6:
                kopacze=5;
                sabotaz=2;
                break;
            case 7:
                kopacze=5;
                sabotaz=3;
                break;
            case 8:
                kopacze=6;
                sabotaz=3;
                break;
            case 9:
                kopacze=7;
                sabotaz=3;
                break;
            case 10:
                kopacze=7;
                sabotaz=4;
                break;
        }
        if(zakrytaKarta<=kopacze) {
            this.zakrytaKarta = "Kopacz";
            kopacze--;
        }
        else{
            this.zakrytaKarta="Sabotaz";
            sabotaz--;
        }
        if(liczbaGraczy<6){
            liczbaKartNaRece=6;
        } else if (liczbaGraczy<8) {
            liczbaKartNaRece=5;
        } else {
            liczbaKartNaRece=4;
        }
    }
    List<Gracz> gracze=new ArrayList<>();
    void potasuj(){
        Collections.shuffle(gracze); //rozlosowanie kart krasnali
        for(int i=0; i<kopacze;i++){
            gracze.get(i).kopacz=true;
        }
        for(int i=kopacze; i<sabotaz+kopacze;i++){
            gracze.get(i).kopacz=false;
        }
        Collections.shuffle(gracze); //rozlosowanie kolejnosci
    }
}
