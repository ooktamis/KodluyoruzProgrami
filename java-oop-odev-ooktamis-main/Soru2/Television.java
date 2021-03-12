package Soru2;

public class Television {
    private int width;
    private int height;
    private int screenSize;
    private int maxVolume=100;
    private int volume;
    private boolean power=true;

    public int getMaxVolume() {
        return maxVolume;
    }

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        
        if(power==true){
            this.power=false;
        }else
            this.power=true;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if(volume>0 & volume<maxVolume ){
            this.volume = volume;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public static void main(String[] args) {
        Television television = new Television();
        television.setVolume(50);
        System.out.println("Ses : "+television.getVolume());
        television.setPower(false);
        System.out.println("Televizyon : "+television.isPower());
    }
    

}
