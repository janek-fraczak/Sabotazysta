import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stol {
    List<Karta> karty;
    char[][] plansza_f;
    void polozKarte(KartaTunel t, int x, int y){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                plansza_f[x*3+i][y*3+j]=t.kierunki[i][j];
            }
        }
    }
    int dojscieDoCelu(int x, int y){
        if(x<0||x>26||y<0||y>14) return 0;
        if(plansza_f[x*3][y*3]=='?') return y;
        if(plansza_f[x*3][y*3]==' ') return 0;
        int result=dojscieDoCelu(x+1,y);
        if(result>0) return result;
        result=dojscieDoCelu(x-1,y);
        if(result>0) return result;
        result=dojscieDoCelu(x,y-1);
        if(result>0) return result;
        return dojscieDoCelu(x,y+1);
    }
    void stworzTalie(){
        Karta tmp;
        char[][] kierunki={{'o','+','o'},{'o','+','o'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<4;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'o','+','+'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<5;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'+','+','+'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<5;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'+','+','+'},{'o','o','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<5;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'+','+','+'},{'o','o','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<3;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'o','+','+'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<4;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'+','+','o'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        for(int i=0;i<5;i++)
            karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'o','+','o'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'o','o','o'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'o','o','+'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'+','o','+'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','+','o'},{'+','o','+'},{'o','o','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'+','o','+'},{'o','o','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'o','o','+'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'+','o','o'},{'o','+','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);
        kierunki=new char[][]{{'o','o','o'},{'+','+','o'},{'o','o','o'}};
        tmp=new KartaTunel(kierunki);
        karty.add(tmp);//koniec tuneli
        kierunki=new char[][]{{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        tmp=new KartaTunel(kierunki,"tunel zniszcz");
        for(int i=0;i<6;i++)
            karty.add(tmp);
        Karta karta=new KartaAkcja("podejrzyjCel");
        for(int i=0;i<6;i++)
            karty.add(karta);
        karta=new KartaAkcja("ban Lampa");
        for(int i=0;i<3;i++)
            karty.add(karta);
        karta=new KartaAkcja("ban Wozka");
        for(int i=0;i<3;i++)
            karty.add(karta);
        karta=new KartaAkcja("ban Kilofa");
        for(int i=0;i<3;i++)
            karty.add(karta);
        karta=new KartaAkcja("Lampa");
        for(int i=0;i<2;i++)
            karty.add(karta);
        karta=new KartaAkcja("Kilof");
        for(int i=0;i<2;i++)
            karty.add(karta);
        karta=new KartaAkcja("Wozek");
        for(int i=0;i<2;i++)
            karty.add(karta);
        karta=new KartaAkcja("Wozek Kilof");
        for(int i=0;i<2;i++)
            karty.add(karta);
        karta=new KartaAkcja("Wozek Lampa");
        for(int i=0;i<2;i++)
            karty.add(karta);
        karta=new KartaAkcja("Kilof Lampa");
        for(int i=0;i<2;i++)
            karty.add(karta);



        Collections.shuffle(karty);
    }
    void rozpocznijGre(){
        char[][] kierunki=new char[][]{{'o','+','o'},{'+','+','+'},{'o','+','o'}};
        KartaTunel start=new KartaTunel(kierunki);
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++) {
                plansza_f[6+i][j]='+';
            }
        }
        for(int cel=0;cel<3;cel++){
            for(int i=0; i<3;i++){
                for(int j=0;j<3;j++) {
                    plansza_f[cel*6+j][24+i]='?';
                }
            }
            for(int i=0; i<3;i++){
                for(int j=0;j<3;j++) {
                    plansza_f[cel*6+j][24+i]='?';
                }
            }
            for(int i=0; i<3;i++){
                for(int j=0;j<3;j++) {
                    plansza_f[cel*6+j][24+i]='?';
                }
            }
        }
    }
    Stol() {
        plansza_f = new char[15][27];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 27; j++) {
                plansza_f[i][j] = ' ';
            }
        }
        karty=new ArrayList<>();
    }
    void wypisz(){
        System.out.print("  ");
        for(int i=0;i<9;i++) {
            System.out.print(" "+i+" ");
        }
        System.out.println();
        for(int i=0; i<15;i++){
            if(i%3==1)
                System.out.print(i/3);
            else
                System.out.print(" ");
            System.out.print(' ');
            for(int j=0;j<27;j++){
                System.out.print(plansza_f[i][j]);

            }
            System.out.println();

        }
    }

}
