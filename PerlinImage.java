import java.awt.image.BufferedImage;

public class PerlinImage {
    //code for perlin noise function goes in here
    private BufferedImage image;

    public PerlinImage(){
        BufferedImage image = new BufferedImage(400, 300, BufferedImage.TYPE_INT_RGB);

        int[][] randPoints = new int[30][40];

        for(int y = 0; y < randPoints.length; y++){
            for(int x = 0; x < randPoints[y].length; x++){
                
                int random =(int) (Math.random()*255);
                randPoints[y][x] = random;
            }
        }

        for (int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                
                int random =(int) (Math.random()*255);
                
                int red = random;
                int green = random;
                int blue = random;

                int rgb = (red << 16) | (green << 8) | blue;

                image.setRGB(x, y, rgb); //for real do img.setRGB(x, y, rgb)
            }
        }
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }
}
