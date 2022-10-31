/**
 * 演示栈内存溢出
 * java.lang.StackOverflowError
 * -Xss256k,VM Options测试手动调试分配栈内存256k，递归次数将会显著减少（默认栈内存JVM是根据Windows系统内存算出来的）
 * @author lmf
 * @version 1.0
 * @date 2022/10/31 14:28
 */
public class StackOverFlowTest {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("count = " + count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
