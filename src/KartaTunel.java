public class KartaTunel extends Karta{
    char[][] kierunki;
    KartaTunel(char kierunki[][]){
        this.kierunki=kierunki;
        this.nazwa="tunel";
    }
    KartaTunel(char kierunki[][], String nazwa){
        this.kierunki=kierunki;
        this.nazwa=nazwa;
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
        System.out.print(" ___");
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(kierunki[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.print(" ---");
        System.out.println();
    }
}
