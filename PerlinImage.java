import java.awt.image.BufferedImage;

public class PerlinImage {
    //code for perlin noise function goes in here
    private BufferedImage image;

    public PerlinImage(){
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        final int cellSize = 10;
        final int xCells = image.getWidth()/cellSize;
        final int yCells = image.getHeight()/cellSize;
        int[][] randPoints = new int[xCells][yCells];

        for(int y = 0; y < randPoints.length; y++){
            for(int x = 0; x < randPoints[y].length; x++){
                
                int random =(int) (Math.random()*255);
                randPoints[y][x] = random;
            }
        }

        for (int i = 0; i < randPoints.length-1; i++)
        {
            for (int j = 0; j < randPoints[i].length-1; j++)
            {
                // Get the corner values
                double x1 = (double) randPoints[i][j];
                double x2 = (double) randPoints[i][j + 1];
                double y1 = (double) randPoints[i + 1][j];
                double y2 = (double) randPoints[i + 1][j + 1];
                double lerp1, lerp2, lerp3;
                // Interpolate within the cell
                for (double y = 0; y < 1; y+=0.01)
                {
                    for (double x = 0; x < 1; x+=0.01)
                    {
                        // Perform bilinear interpolation
                        lerp1 = Lerp.lerp(x1, x2, x);
                        lerp2 = Lerp.lerp(y1, y2, x);
                        lerp3 = Lerp.lerp(lerp1, lerp2, y);
                        int red = (int) lerp3;
                        int green = (int) lerp3;
                        int blue = (int) lerp3;

                        int rgb = red << 16 | green << 8 | blue;
                        int X = (int) (x*cellSize);
                        int Y = (int) (y*cellSize);
                        // Set the pixel color in the image
                        image.setRGB(X + j*cellSize, Y + i*cellSize, rgb);
                    }
                }
            }
        }
        this.image = image;
    }

    public BufferedImage getImage(){
        return image;
    }
}
