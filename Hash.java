public class Hash {
    // Simple hash function for demonstration
    public static double hash(double x, double y)
    {
    long a = Double.doubleToLongBits(x);
    long b = Double.doubleToLongBits(y);

    long h = 0;

    // Mix like your original, but in 64-bit
    h = a * 374761393L + b * 668265263L;

    // Bit mixing (64-bit version)
    h ^= (h >>> 33);
    h *= 0xff51afd7ed558ccdL;
    h ^= (h >>> 33);
    h *= 0xc4ceb9fe1a85ec53L;
    h ^= (h >>> 33);

    // Return 0–255
    return (int)(h & 0xFF);
    }

    public static void main(String[] args)
    {
        double x = -1;
        double y = 1;
        System.out.println("Hash of ("+x+", "+y+"): " + hash(x, y));
    }
}
