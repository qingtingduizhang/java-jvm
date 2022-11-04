import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆内存溢出java.lang.OutOfMemoryError: Java heap space
 * -Xmx8m 堆内存改下次数显著降低
 * @author lmf
 * @version 1.0
 * @date 2022/11/1 9:37
 */
public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        int i=0;
        try {
            List<String> list = new ArrayList<>();
            String a="hello";
            while (true){
                list.add(a);
                a=a+a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
