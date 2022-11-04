import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用演示+配合引用队列
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * @author lmf
 * @version 1.0
 * @date 2022/11/4 9:31
 */
public class SoftReferenceTest2 {
    private static final int _4MB=1024*1024*4;

    public static void main(String[] args) {
        soft();
    }

    private static void soft() {
        List<SoftReference<byte[]>> list = new ArrayList<>();
        //引用队列
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            //关联了引用队列，当软引用所关联的byte[]被回收时，软引用自己会加入到queue中去
            SoftReference<byte[]> ref = new SoftReference<>(new byte[_4MB],queue);
            System.out.println(ref.get());
            list.add(ref);
            System.out.println(list.size());
        }
        //释放软引用自身
        Reference<?> poll = queue.poll();
        while (poll!=null){
            list.remove(poll);
           poll = queue.poll();
        }
        System.out.println("list.size() = " + list.size());
        for (SoftReference<byte[]> ref : list) {
            System.out.println(ref.get());
        }
    }
}
