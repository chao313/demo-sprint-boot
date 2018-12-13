package demo.spring.boot.demospringboot.util;

import java.io.IOException;
import java.io.InputStream;

public interface CallBack<T> {

    T deal(InputStream in) throws IOException;
}
