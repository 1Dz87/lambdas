import java.io.IOException;

@FunctionalInterface
public interface MyConsumer {

    void consume(String arg) throws IOException;
}
