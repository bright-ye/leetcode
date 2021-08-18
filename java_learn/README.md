# try-with-resouce

在jdk7前，类似IO之类的资源需要手动关闭，格式如下：

```java
try{
	...
}catch()finnally{
	...
}
```

在jdk8及之后，类似IO之类的资源可以通过try-with-resouce来隐式地关闭，格式如下：

```java
try(){
	
}
```

代码案例如下，我们可以实现接口`Closeable`或者`AutoCloseable`，具体代码如下：

```java

import org.junit.Test;

import java.io.Closeable;

public class CloseMain {
    @Test
    public void test2() {
        try (Resource2 r2 = new Resource2()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        try (Resource1 r1 = new Resource1()) {

        }
    }
}

class Resource1 implements Closeable {
    @Override
    public void close() {
        System.out.println("r1 close...");
    }
}

class Resource2 implements AutoCloseable{
    @Override
    public void close() {
        System.out.println("r2 close...");
    }
}
```

打印结果：

```
r1 close...
r2 close...
```

查看了下closeable的源码：`public interface Closeable extends AutoCloseable`，一切尽知晓...

