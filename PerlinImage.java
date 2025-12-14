import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.lang.Math;

public class PerlinImage {
    //code for perlin noise function goes in here
    private BufferedImage image;
    private static ArrayList<Integer> permutation;

    //Makes an ArrayList
    public ArrayList<Integer> MakePermutation(int seed){
        
        ArrayList<Integer>  perm = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
             perm.add(i);
        } //initialize
        
        Random rand = new Random(seed);
        for (int i =  perm.size() - 1;  i > 0; i--){
            int randIndex = rand.nextInt(i);
            Collections.swap( perm, i, randIndex);
        }
        int sizeThing = perm.size();
        for (int i = 0; i < sizeThing; i++){
            perm.add(perm.get(i));
        }
        return  perm;
    }

    // Gets the vectors of each corner of the grid.
    public Vector2D GetVector(int val)
    {
        if (val % 4 == 0)
        {
            return new Vector2D(1.0, 1.0);
        }
        else if (val % 4 == 1)
        {
            return new Vector2D(-1.0, 1.0);
        }
        else if (val % 4 == 2)
        {
            return new Vector2D(1.0, -1.0);
        }
        else
        {
            return new Vector2D(-1.0, -1.0);
        }
    }

    public double Lerp(double a, double b, double t)
    {
        // t = (3 - 2*t)*t*t;
        t = ((6*t - 15)*t + 10)*t*t*t; //has to be betwen 0.0 and 1.0
        return a + t * (b - a);
    }

    public double Noise2D(double x, double y){
        //Values of which to get the values in the permutation table.
        final int X = (int)Math.floor(x) & 255;
        final int Y = (int)Math.floor(y) & 255;

        //Values used to interpolate. the value used in the lerp function
        final double xf = x - Math.floor(x); // tells you how far from the left edgge of the grid cell it is
        final double yf = y - Math.floor(y);

        final Vector2D topL = new Vector2D(xf, yf);
        final Vector2D topR = new Vector2D(xf-1.0, yf);
        final Vector2D botL = new Vector2D(xf, yf-1.0);
        final Vector2D botR =  new Vector2D(xf-1.0, yf-1.0);

        final int valTopL = permutation.get(permutation.get(X)+Y);
        final int valTopR = permutation.get(permutation.get(X+1)+Y);
        final int valBotL = permutation.get(permutation.get(X)+Y+1);
        final int valBotR = permutation.get(permutation.get(X+1)+Y+1);

        final double dotTopL = topL.dotProduct(GetVector(valTopL));
        final double dotTopR = topR.dotProduct(GetVector(valTopR));
        final double dotBotL = botL.dotProduct(GetVector(valBotL));
        final double dotBotR = botR.dotProduct(GetVector(valBotR));
        
        return Lerp(Lerp(dotTopL, dotTopR, xf), Lerp(dotBotL, dotBotR, xf), yf);
        
    }
    public double FractalBrownianMotion(int x, int y, int numOctaves){
        double result = 0.0;
        double amplitude = 1.0;
        double freq = 0.005;

        for (int octave = 0; octave < numOctaves; octave++){
            final double n = amplitude * Noise2D(x * freq, y*freq);
            result += n;

            amplitude *= 0.5;
            freq *= 2.0;
        }
        return result;
    }

    public PerlinImage(int seed){
        BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        this.permutation = MakePermutation(seed);

        for (int y= 0; y < 500; y++)
        {
            for (int x = 0; x < 500; x++)
            {
                double n = FractalBrownianMotion(x, y, 5);

                n = (n + 1.0) * 0.5;
                int c = (int) Math.round(255*n);

                c = Math.min(255, Math.max(0,c));

                int rgb;
                if (c > 240){ //snow
                    rgb = (225 << 16) | (225 << 8) | 225;
                }else if (c > 220){ //Mountains
                    rgb = (170 << 16) | (170 << 8) | 170;
                } else if(c > 170){ //Dark Land
                    rgb = (26 << 16) | (99 << 8) | 26;
                } else if(c > 120) { //Light Land
                    rgb = (21 << 16) | (153 << 8) | 21;
                } else if (c > 105){ //Beach
                    rgb = (194 << 16) | (177 << 8) | 48;
                }else if (c > 60){ //close Ocean
                    rgb = (20 << 16) | (40 << 8) | 230;
                } else {
                    rgb = (0 << 16) | (0 << 8) | 160;
                }
                image.setRGB(x, y, rgb);
                
            }
        }
        this.image = image;
    }
    
    public BufferedImage getImage(){
        return image;
    }
}