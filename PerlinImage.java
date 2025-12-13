import java.awt.image.BufferedImage;

public class PerlinImage {
    //code for perlin noise function goes in here
    private BufferedImage image;

    public PerlinImage(){
        BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        
        final int cellSize = 10;
        double[] permutation = new double[256];
        for (int i = 0; i < permutation.length; i++)
        {
            permutation[i] = i;
        }
        

        this.image = image;
        // Initialize and declare cell sizes and number of random points
        // final int cellSize = 10;
        // final int xCells = image.getWidth()/cellSize;
        // final int yCells = image.getHeight()/cellSize;
        // double[][][] randPoints = new double[xCells][yCells][2];

        // // Initialize the vectors at each random point
        // double r1, r2;
        // for(int y = 0; y < randPoints.length; y++){
        //     for(int x = 0; x < randPoints[y].length; x++){
        //         r1 = (Math.random() + 1) /2;
        //         r2 = (Math.random() + 1) /2;
        //         randPoints[y][x] = new double[]{r1, r2};
        //     }
        // }

        // // Generate the noise image using bilinear interpolation
        // double col1, col2, col3, col4, prod1, prod2, prod3, prod4, lerp1, lerp2, lerp3;
        // int red, green, blue, rgb, X, Y;
        // double[] topLeft, topRight, bottomLeft, bottomRight, point;
        // for (int i = 0; i < randPoints.length-1; i++)
        // {
        //     for (int j = 0; j < randPoints[i].length-1; j++)
        //     {
        //         // Get the vector values in the corners of the cell
        //         topLeft = randPoints[i][j];
        //         topRight = randPoints[i+1][j];
        //         bottomLeft = randPoints[i][j+1];
        //         bottomRight = randPoints[i+1][j+1];

        //         // Interpolate within the cell
        //         for (double y = 0; y <= 1; y+=0.5/(double)cellSize)
        //         {
        //             for (double x = 0; x <= 1; x+=0.5/(double)cellSize)
        //             {
        //                 // X and Y pixel coordinates
        //                 X = i * cellSize + (int)(x * cellSize);
        //                 Y = j * cellSize + (int)(y * cellSize);
        //                 point = new double[]{X, Y};

        //                 // Hash the point coordinates to get pseudo-random gradients
        //                 // col1 = Hash.hash(topLeft[0], topLeft[1]);
        //                 // col2 = Hash.hash(topRight[0], topRight[1]);
        //                 // col3 = Hash.hash(bottomLeft[0], bottomLeft[1]);
        //                 // col4 = Hash.hash(bottomRight[0], bottomRight[1]);

        //                 // Calculate the dot products
        //                 prod1 = Math.abs(DotProduct.dotProduct(topLeft, point));
        //                 prod2 = Math.abs(DotProduct.dotProduct(topRight, point));
        //                 prod3 = Math.abs(DotProduct.dotProduct(bottomLeft, point));
        //                 prod4 = Math.abs(DotProduct.dotProduct(bottomRight, point));

        //                 // System.out.println(prod1 + " " + prod2 + " " + prod3 + " " + prod4);
                        
        //                 // Perform bilinear interpolation
        //                 lerp1 = Lerp.lerp(prod1, prod2, x);
        //                 lerp2 = Lerp.lerp(prod3, prod4, x);
        //                 lerp3 = Lerp.lerp(lerp1, lerp2, y);

        //                 // Combine color components into a single RGB value
        //                 red = (int)(lerp3);
        //                 green = (int)(lerp3);
        //                 blue = (int)(lerp3);
        //                 rgb = (red << 16) | (green << 8) | blue;

        //                 // Set the pixel color in the image
        //                 image.setRGB(X, Y, rgb);
        //             }
        //         }
        //     }
        // }
    }

    public BufferedImage getImage(){
        return image;
    }
}
