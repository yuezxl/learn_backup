package lesson_lock;

import java.lang.reflect.Field;
import java.util.Arrays;

import sun.misc.Unsafe;

public class UnsafeTest {
	private static int byteArrayBaseOffset;

    public static void main(String[] args) throws SecurityException,
            NoSuchFieldException, IllegalArgumentException,
            IllegalAccessException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe UNSAFE = (Unsafe) theUnsafe.get(null);
        System.out.println(UNSAFE);

        byte[] data = new byte[10];
        System.out.println(Arrays.toString(data));
        byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);
        
        //System.out.println(UNSAFE.getAddress(1L));

        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(data, byteArrayBaseOffset, (byte) 1);
        System.out.println(Arrays.toString(data));
        UNSAFE.putByte(data, byteArrayBaseOffset + 5, (byte) 129);
        System.out.println(Arrays.toString(data));
    }
}
