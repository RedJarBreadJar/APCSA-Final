public class Vector2D {
    private double[] vector = new double[2];

    public Vector2D(double v1, double v2)
    {
        vector[0] = v1;
        vector[1] = v2;
    }

    public double[] getVector()
    {
        return vector;
    }

    // doubleerpolation function with smoothstep function
    

    public double dotProduct(Vector2D other) {
        double[] otherVector = other.getVector(); 
        if (vector.length != otherVector.length)
        {
            throw new IllegalArgumentException("Vectors must be of the same length");
        }
        double sum = 0;
        for (int i = 0; i < vector.length; i++)
        {
            sum += vector[i] * otherVector[i];
        }
        return sum;
    }
}


