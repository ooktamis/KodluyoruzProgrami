package Soru1;

public class AdvancedCalculator extends BasicCalculator implements Scientific {

    @Override
    public int kareal(int a) {
        return a*a;
    }

    @Override
    public int kupal(int a) {
        return a*a*a;
    }

    public static void main(String[] args) {

        AdvancedCalculator ad = new AdvancedCalculator();

        System.out.println(ad.kareal(5));
        System.out.println(ad.kupal(3));
        ad.carpma(3, 5);
        ad.bolme(8, 4);

        
    }
    
}
