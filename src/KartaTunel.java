public class KartaTunel extends Karta{
    char[][] kierunki;
    KartaTunel(char kierunki[][]){
        this.kierunki=kierunki;
        this.nazwa="tunel";
    }
    void obrocKarte(){
        char tmp;
        tmp = kierunki[1][0];
        kierunki[1][0]=kierunki[1][2];
        kierunki[1][2]=tmp;
        tmp = kierunki[2][1];
        kierunki[2][1]=kierunki[0][1];
        kierunki[0][1]=tmp;
    }
    public void wypisz() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(kierunki[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
