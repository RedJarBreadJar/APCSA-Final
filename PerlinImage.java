import java.awt.image.BufferedImage;

public class PerlinImage {
    //code for perlin noise function goes in here
    private BufferedImage image;

    public PerlinImage(){
        BufferedImage image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);


        for (int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                //int red = (int) ((x / (float) img.getWidth()) * 255);
                //int green = (int) ((y / (float) img.getHeight()) * 255);
                //int blue = (int) ((y / (float) img.getHeight()) * 127) + (int)((x / (float) img.getWidth()) * 127);

                //int rgb = (red << 16) | (green << 8) | blue;

                //create seperate file to work on perlin noise function

                image.setRGB(x, y, 255); //for real do img.setRGB(x, y, rgb)
            }
        }
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }
}
