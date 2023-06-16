public class powerOfTwo {
    public static boolean isPowerOfTwo(int value) {
        if(Integer.bitCount(Math.abs(value))==1) {
            return true;
        } else {
            return false;
        }
    }
}
