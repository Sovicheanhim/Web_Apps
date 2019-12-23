package Design_Pattern;

public class Proxy_Pattern {
    public static void main(String[] args) {
        Image image = new ProxyImage("Photo.jpg");
        image.DisplayImage();
    }
}
interface Image{
    void DisplayImage();
}

class RealImage implements Image{
    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }
    private void loadFromDisk(String fileName){
        System.out.println("load"+fileName);
    }

    public void DisplayImage(){
        System.out.println("Display: "+fileName);
    }
}

class ProxyImage implements Image{
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void DisplayImage() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.DisplayImage();
    }
}
