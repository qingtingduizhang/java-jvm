import java.util.ArrayList;

/**GC分析
 * -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
 * @author lmf
 * @version 1.0
 * @date 2022/11/8 13:48
 */
public class GCTest {
    private static final int _512KB=512*1024;
    private static final int _1MB=1024*1024;
    private static final int _6MB=6*1024*1024;
    private static final int _7MB=7*1024*1024;
    private static final int _8MB=8*1024*1024;

    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        list.add(new byte[_7MB]);
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);
    }
}
