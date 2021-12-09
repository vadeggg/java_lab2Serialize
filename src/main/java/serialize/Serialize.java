package serialize;

import java.io.IOException;

public interface Serialize {
    public <T> String serializeXml(T obj) throws IOException;
    public <T> T deserializrXml(String text, Class<T> somCLass) throws IOException;
    public <T> String serializeJson(T obj) throws IOException;
    public <T> T deserializrJson(String text, Class<T> somCLass) throws IOException;
    public <T> void serializeYaml(T obj) throws IOException;
    public <T> T deserializrYaml(String text, Class<T> somCLass) throws IOException;
}