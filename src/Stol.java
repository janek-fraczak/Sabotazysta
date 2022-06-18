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
        //Karta karta=new Akcja("zniszczTunel");
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
