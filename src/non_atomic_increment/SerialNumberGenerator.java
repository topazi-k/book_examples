package non_atomic_increment;

public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static /*synchronized*/ int getSerialNumber(){
        return serialNumber++;
    }
}
