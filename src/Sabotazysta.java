import java.util.Scanner;
import java.util.Random;


public class Sabotazysta {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println("Podaj liczbe graczy");
        Scanner scan = new Scanner(System.in);
        int liczba_graczy=3;
        // int liczba_graczy=scan.nextInt();
        System.out.println("Podaj liczbe AI");
        int liczba_AI=0;
        //int liczba_AI=scan.nextInt();
        //scan.nextLine();
        Stol stol=new Stol();
        Random rand = new Random();
        int cel=rand.nextInt(3);
        stol.rozpocznijGre();
        stol.wypisz();
        String Name;
        Gracz tmp;
        int zakrytaKarta=rand.nextInt(liczba_graczy+liczba_AI+1);

        Gra gra = new Gra(liczba_AI+liczba_graczy, zakrytaKarta);
        int wiek;
        for(int i =0; i<liczba_graczy;i++){
            System.out.println("Podaj imie kolejnego gracza");
            //Name = scan.nextLine();
            Name="ja" + (char)i;
            System.out.println("Podaj wiek gracza");
            //wiek=scan.nextInt();
            //scan.nextLine();
            wiek = i*10;
            tmp=new Gracz(wiek, Name, false);
            gra.gracze.add(tmp);
        }
        for(int i =0; i<liczba_AI;i++){
            wiek = rand.nextInt(10)+10;
            tmp = new Gracz(wiek, "AI"+i,true);
            gra.gracze.add(tmp);
        }
        gra.potasuj();
        stol.stworzTalie();
        for(int i=0;i<gra.gracze.size();i++){
            System.out.println("wcisnij Enter jesli to twoje imie: " + gra.gracze.get(i).nazwa);
            scan.nextLine();
            if(gra.gracze.get(i).kopacz)
                System.out.println("kopacz");
            else
                System.out.println("sabotaz");
            for(int j =0;j<gra.liczbaKartNaRece;j++){
                gra.gracze.get(i).dobierzKarte(stol.karty);
            }
        }
        String ruchGracza;
        int ruchGraczaIdx;
        Gracz aktualny;
        Karta zagrywanaKarta;
        for(int i=0;;i++){
            aktualny=gra.gracze.get(i%(liczba_graczy+liczba_AI));
            System.out.println("Ruch gracza: "  + aktualny.nazwa);
            System.out.println("wcisnij Enter jesli to twoje imie");
            scan.nextLine();
            stol.wypisz();
            aktualny.pokazKarty();
            if(aktualny.lampa&&aktualny.kilof&& aktualny.wozek){
                System.out.println("Jestes odblokowany, mozesz grac karty tuneli");
            }
            System.out.println("wybierz karte");
            ruchGraczaIdx=scan.nextInt();
            scan.nextLine();
            zagrywanaKarta=aktualny.karty.remove(ruchGraczaIdx);
            System.out.println("czy chcesz odrzucic? T N ");
            ruchGracza=scan.nextLine();
            if(ruchGracza.equals("T")){
                if(!stol.karty.isEmpty()) {
                    aktualny.dobierzKarte(stol.karty);
                }
                continue;
            }
            int x, y;
            String[] karta=zagrywanaKarta.nazwa.split(" ");
            switch (karta[0]){
                case "tunel":
                    System.out.println("Czy chesz obrocic karte? T N");
                    ruchGracza=scan.nextLine();
                    if(ruchGracza.equals("T")){
                        zagrywanaKarta.obrocKarte();
                        zagrywanaKarta.wypisz();
                    }
                    System.out.println("Gdzie polozyc karte?");
                    x=scan.nextInt();
                    y= scan.nextInt();
                    scan.nextLine();
                    stol.polozKarte((KartaTunel)zagrywanaKarta,x,y);
                    break;
                case "podejrzyjCel":
                    System.out.println("Czy chesz odslonic karte celu? {0, 2, 4}");
                    ruchGraczaIdx=scan.nextInt();
                    scan.nextLine();
                    if(cel*2==ruchGraczaIdx) {
                        System.out.println("!!!złoto!!!");
                    }
                    else {
                        System.out.println("-- kamien --");
                    }
                    break;
                case "ban":
                    System.out.println("Mozesz zabrac "+karta[1]+ ". Podaj index gracza do zbanowania");
                    ruchGraczaIdx=scan.nextInt();
                    scan.nextLine();
                    switch (karta[1]) {
                        case "Lampa":
                            gra.gracze.get(ruchGraczaIdx).lampa = false;
                            break;
                        case "Kilof":
                            gra.gracze.get(ruchGraczaIdx).kilof = false;
                            break;
                        case "Wozek":
                            gra.gracze.get(ruchGraczaIdx).wozek = false;
                            break;
                    }
                    break;
                default:
                    System.out.println("Mozesz oddac ");
                    for(int k=0;k<karta.length;k++){
                        System.out.println(k+": "+karta[k]+" ");
                    }
                    System.out.println("dowolnemu graczowi. Podaj index artefaktu do odblokowania oraz index gracza do odblokowania");
                    x=scan.nextInt();
                    ruchGraczaIdx=scan.nextInt();
                    switch(karta[x]){
                        case "Lampa":
                            gra.gracze.get(ruchGraczaIdx).lampa = true;
                            break;
                        case "Kilof":
                            gra.gracze.get(ruchGraczaIdx).kilof = true;
                            break;
                        case "Wozek":
                            gra.gracze.get(ruchGraczaIdx).wozek = true;
                            break;
                    }
                    break;
            }
            if(!stol.karty.isEmpty())
                aktualny.dobierzKarte(stol.karty);
            //stol.czyCelOsiagniety();
            System.out.println("Czy chesz odslonic karte celu? {1, 2, 3} or 0=N");
            ruchGraczaIdx=scan.nextInt();
            scan.nextLine();
            if(ruchGraczaIdx==0)
                continue;
            if(cel==ruchGraczaIdx) {
                System.out.println("!!!złoto!!!");
                break;
            }
            else {
                System.out.println("-- kamien --");
            }
        }
        scan.close();
    }
}
