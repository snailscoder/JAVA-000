import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 *
 * @author huaxin
 */
public class HelloClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            InputStream is = HelloClassLoader.class.getResourceAsStream("/Hello.xlass");
            byte[] b = new byte[is.available()];
            is.read(b);
            decode(b);
            return defineClass(name, b, 0, b.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * 转换
     * @param b
     */
    private void decode(byte[] b) {
        if (b != null && b.length > 0) {
            for (int i = 0; i < b.length; i++) {
                b[i] = (byte) (255 - b[i]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            Object obj = new HelloClassLoader().findClass("Hello").newInstance();
            Class clazz = obj.getClass();
            Method method = clazz.getMethod("hello", (Class<?>) null);
            method.invoke(obj, (Object) null);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
