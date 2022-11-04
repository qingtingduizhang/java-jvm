import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * 演示直接内存溢出 java.lang.OutOfMemoryError: Direct buffer memory
 * @author lmf
 * @version 1.0
 * @date 2022/11/3 13:14
 */
public class DirectBufferMemoryTest {
    static int _100Mb=1024*1024*100;

    public static void main(String[] args) {
        ArrayList<ByteBuffer> list = new ArrayList<>();
        int i=0;
        try {
            while (true){
                //NIO：ByteBuffer.allocateDirect(_100Mb);分配直接内存(多大空间的缓冲区)
                ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }
}
