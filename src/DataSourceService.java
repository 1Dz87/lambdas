import java.io.IOException;

public class DataSourceService {

    private final String source;

    public DataSourceService(String source) {
        this.source = source;
    }

    public void getString(MyConsumer i) throws IOException {
        // Some logic before
        i.consume(source);
        // Some logic after
    }
}
