
import java.util.Scanner;

public class BasePage {
    

    public static void main(String[] args){
        Deneme deneme = new Deneme();
        System.out.println("Lütfen soru numarası girin: ");
        Scanner scn=new Scanner(System.in);
        int numara= scn.nextInt();

        if(numara==1){
            System.out.println("Lütfen bir sayı girin: ");
            int sayi= scn.nextInt();
            System.out.println(deneme.palidrom(sayi));;

        }else if(numara==2){
            System.out.println("Lütfen bir sıcaklık girin: ");
            int sicaklik = scn.nextInt();
            System.out.println(deneme.havaSicaklik(sicaklik));;

        }else if(numara==3){
            System.out.println("Lütfen bir yazı girin: ");
            String yazi= scn.nextLine();
            deneme.tersYazdirma(yazi);

        }else if(numara==4){
            deneme.minMak(deneme.diziB());
        }else if(numara==5){
            
            deneme.Setcolor("mavi");
            System.out.println("Çemberin rengi: "+deneme.getColor());
            deneme.Setyaricap(5);
            double pi=3.14;
            int degisken= deneme.getYaricap();
            double alan=pi*degisken*degisken;
            System.out.println("Çemberin alanı: "+alan);
            double yaricaphesap=(Math.sqrt(alan/pi));
            System.out.println("Yarıçap sağlaması:" + yaricaphesap);

        }else{
            System.out.println("Soru yok");
        }


    }


    
}
