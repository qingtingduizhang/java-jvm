import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用演示
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * @author lmf
 * @version 1.0
 * @date 2022/11/4 9:31
 */
public class SoftReferenceTest {
    private static final int _4MB=1024*1024*4;

    public static void main(String[] args) {
        soft();
    }

    private static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB]);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        System.out.println("list.size() = " + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
