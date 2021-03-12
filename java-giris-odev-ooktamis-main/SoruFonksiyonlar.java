import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class SoruFonksiyonlar {

/*---------------------SORU1--------------*/


public String palidrom(int sayi){
  
    int kalan=sayi%10;
    List list = new ArrayList();
    list.add(kalan);
    while (sayi>10){
        sayi =sayi/10;
    }
    list.add(sayi);
    if (list.get(0)==list.get(1)){
        return "Palindromik sayı";
    }
    else{
        return "Palindromik değil";
    }
}
/*---------------------SORU1--------------*/

/*------------------------------------------------------------*/

/*---------------------SORU2--------------*/

public String havaSicaklik(int sicaklik){
    if (sicaklik<20){
        return "Hava soğuk";
    }
    else if (sicaklik<=30 ) {
        return "Hava ılık";
    }
    else{
        return "Hava sıcak";
    }
}

/*---------------------SORU2--------------*/

/*------------------------------------------------------------*/

/*---------------------SORU3--------------*/

public void tersYazdirma(String yazi){
    
    char[] array = yazi.toCharArray();

    for (int i=yazi.length()-1; i>=0; i--) {
        System.out.print(array[i]);
    }
}


/*---------------------SORU3--------------*/

/*------------------------------------------------------------*/

/*---------------------SORU4--------------*/



int dizi1=4;
int[] diziBoyutlari = new int[dizi1];
Random random = new Random();
public  int[][] diziB(){
    int dizi_boyutu= random.nextInt(6)+3;
    int boyutlar[][] = new int[dizi1][dizi_boyutu];

        for(int i=0;i<4;i++){
            setdiziBoyutlari(dizi_boyutu, i);
            for(int j=0; j<dizi_boyutu;j++){
                boyutlar[i][j]=random.nextInt(100);
            }
            System.out.print("\n(İ nin Değeri =>"+(i+1)+" ) "+"=> ");
            for(int j=0; j<getdiziBoyutlari()[i];j++){
                System.out.print(boyutlar[i][j]+" **");
            }
        }
        return boyutlar;
}
public void setdiziBoyutlari(int dizi_boyutu,int x){
    this.diziBoyutlari[x]=dizi_boyutu;
}
public int[] getdiziBoyutlari(){
    return diziBoyutlari;
}

public void minMak(int[][] dizi){

    for(int i=0;i<4;i++){

        int min=dizi[i][0];
        int mak=0;
        
        for(int k=0; k<getdiziBoyutlari()[i]; k++){
            if((k+1)!=getdiziBoyutlari()[i]){
                
                if(dizi[i][k+1]<min){
                    min=dizi[i][k+1];
                }
                if(mak<dizi[i][k+1]){
                    mak=dizi[i][k+1];
                }
            }else
                break; 
        }
        System.out.print("\n "+(i+1)+" inci Dizinin , En küçük Elemanı "+ (min) +" En Büyük Elemanı "+ (mak)+"\n");
    }

}


/*---------------------SORU4--------------*/

/*------------------------------------------------------------*/

/*---------------------SORU5--------------*/

    private String color;
    private int yaricap;

    public void Setcolor(String color){
        this.color=color;
    }
    public String getColor() {
        return this.color;
    }
    public void Setyaricap(int yaricap){
        this.yaricap=yaricap;
    }
    public int getYaricap(){
        return this.yaricap;
    }

/*---------------------SORU5--------------*/
}

