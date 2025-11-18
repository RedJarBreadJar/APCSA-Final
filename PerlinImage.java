import java.awt.image.BufferedImage;

public class PerlinImage {
    //code for perlin noise function goes in here
    private BufferedImage image;

    public PerlinImage(){
        BufferedImage image = new BufferedImage(750, 750, BufferedImage.TYPE_INT_RGB);

        // Initialize and declare cell sizes and number of random points
        final int cellSize = 10;
        final int xCells = image.getWidth()/cellSize;
        final int yCells = image.getHeight()/cellSize;
        int[][] randPoints = new int[xCells][yCells];

        // Initialize random points
        for(int y = 0; y < randPoints.length; y++){
            for(int x = 0; x < randPoints[y].length; x++){
                
                int random =(int) (Math.random()*255);
                randPoints[y][x] = random;
            }
        }

        // Generate the noise image using bilinear interpolation
        double x1, x2, y1, y2, lerp1, lerp2, lerp3;
        int red, green, blue, rgb, X, Y;
        for (int i = 0; i < randPoints.length-1; i++)
        {
            for (int j = 0; j < randPoints[i].length-1; j++)
            {
                // Get the corner values
                x1 = (double) randPoints[i][j];
                x2 = (double) randPoints[i][j + 1];
                y1 = (double) randPoints[i + 1][j];
                y2 = (double) randPoints[i + 1][j + 1];
                // Interpolate within the cell
                for (double y = 0; y < 1; y+=0.5/(double)cellSize)
                {
                    for (double x = 0; x < 1; x+=0.5/(double)cellSize)
                    {
                        // Perform bilinear interpolation
                        lerp1 = Lerp.lerp(x1, x2, x);
                        lerp2 = Lerp.lerp(y1, y2, x);
                        lerp3 = Lerp.lerp(lerp1, lerp2, y);
                        red = (int) lerp3;
                        green = (int) lerp3;
                        blue = (int) lerp3;

                        // Combine color components into a single RGB value
                        rgb = red << 16 | green << 8 | blue;

                        // Set the pixel color in the image
                        X = (int) (x*cellSize);
                        Y = (int) (y*cellSize);
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
