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
        double[][][] randPoints = new double[xCells][yCells][2];

        // Initialize the vectors at each random point
        double r1, r2;
        for(int y = 0; y < randPoints.length; y++){
            for(int x = 0; x < randPoints[y].length; x++){
                r1 = Math.random() * 2 - 1;
                r2 = Math.random() * 2 - 1;
                randPoints[y][x] = new double[]{r1, r2};
            }
        }

        // Generate the noise image using bilinear interpolation
        for (int i = 0; i < randPoints.length-1; i++)
        {
            for (int j = 0; j < randPoints[i].length-1; j++)
            {
                // Get the vector values in the corners of the cell
                double[] v1 = randPoints[i][j];
                double[] v2 = randPoints[i+1][j];
                double[] v3 = randPoints[i][j+1];
                double[] v4 = randPoints[i+1][j+1];

                // Interpolate within the cell
                for (double y = 0; y < 1; y+=1.0/(double)cellSize)
                {
                    for (double x = 0; x < 1; x+=1.0/(double)cellSize)
                    {
                        // Perform bilinear interpolation
                        Lerp.lerp(Hash.hash())
                        // Combine color components into a single RGB value

                        // Set the pixel color in the image
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
