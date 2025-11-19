public class Hash {
    // Simple hash function for demonstration
    public static int hash(int x, int y) {
    int h = 0;

    // Combine coordinates using a large prime mix
    h = x * 374761393 + y * 668265263;

    // Bit mixing (similar to MurmurHash finalizer)
    h ^= (h >>> 13);
    h *= 1274126177;
    h ^= (h >>> 16);

    // Return 0–255
    return h & 0xFF;
}

    public static void main(String[] args) {
        int x = -1;
        int y = 1;
        System.out.println("Hash of ("+x+", "+y+"): " + hash(x, y));
    }
}
