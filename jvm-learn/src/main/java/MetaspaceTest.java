import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示元空间内存溢出 Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 *-XX:MaxMetaspaceSize=8m
 * @author lmf
 * @version 1.0
 * @date 2022/11/1 9:37
 */
public class MetaspaceTest extends ClassLoader {//可以用来加载类的二进制字节码
    public static void main(String[] args) {
        int j = 0;
        try {
            MetaspaceTest metaspaceTest = new MetaspaceTest();
            for (int i = 0; i < 10000; i++, j++) {
                //ClassWriter 作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //生成的类的版本号（是jdk1.8的），生成类的访问权限（是public），类名，包名，类的父类，接口
                cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回 byte[]
                byte[] code = cw.toByteArray();
                //执行类的机载
                metaspaceTest.defineClass("Class" + i, code, 0, code.length);
            }
        } finally {
            System.out.println(j);
        }
    }
}
