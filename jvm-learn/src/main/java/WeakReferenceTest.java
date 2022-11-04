import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示弱引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * @author lmf
 * @version 1.0
 * @date 2022/11/4 11:48
 */
public class WeakReferenceTest {
    private static final int _4MB=1024*1024*4;

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            WeakReference ref = new WeakReference<>(new byte[_4MB]);;
            list.add(ref);
            for (WeakReference<byte[]> w : list) {
                System.out.println(w.get());
            }
            System.out.println();
        }
        System.out.println("list.size() = " + list.size());
    }
}
