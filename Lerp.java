public class Lerp {
    // Interpolation function with smoothstep function
    public static double lerp(double a, double b, double t){
        // t = (3*t*t - 2*t*t*t);
        t = 6*t*t*t*t*t - 15*t*t*t*t + 10*t*t*t;
        return a + t * (b - a);
    }
}
