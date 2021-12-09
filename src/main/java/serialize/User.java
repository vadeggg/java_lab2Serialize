package serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.*;


public class User implements Serialize, Orders{
    @Override
    public <T> String serializeXml(T obj) throws IOException {

        String xmltext =  new XmlMapper().enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(obj);
        System.out.println(xmltext);
        return xmltext;
    }

    public <T> T deserializrXml(String text, Class<T> T) throws IOException {
        T ser = new XmlMapper().readValue(text, T);
        System.out.println("DESIR"+ser);
        return ser;
    }

    @Override
    public <T> String serializeJson(T obj) throws IOException{
        String jsonText =  new ObjectMapper().enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(obj);
        System.out.println(jsonText);
        return jsonText;
    }

    public <T> T deserializrJson(String text, Class<T> T) throws IOException{
        T ser = new ObjectMapper().readValue(text, T);
        System.out.println("DESIR"+ser);
        return ser;
    }

    @Override
    public <T> void serializeYaml(T obj) throws IOException{
        ObjectMapper mapper  = new ObjectMapper(new YAMLFactory());
        SerializableObj p =  new SerializableObj();

        mapper.writeValue(new File("yaml.yaml"), obj);
    }

    @Override
    public <T> T deserializrYaml(String text, Class<T> T) throws IOException{
        T ser = new ObjectMapper(new YAMLFactory()).readValue(new File("yaml.yaml"), T);
        return ser;

    }

    @Override
    public String read(String filename) {
        String str = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line = bufferedReader.readLine();
            while(line != null) {
                str+=line;
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            // Exception handling
        } catch (IOException e) {
            // Exception handling
        }
        return str;
    }

    @Override
    public void write(String text, String filename) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {
            String fileContent = text;
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            // Exception handling
        }
    }


}


