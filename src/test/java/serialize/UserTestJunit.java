package serialize;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserTestJunit {
    @Test
    public void testUserForModifiers() throws IOException {

//
        SomeObj userObj = new SomeObj.UserBuilder()
                .setUserName("name")
                .setSurname("surname")
                .setUser_type("some_type")
                .build();
        System.out.println(userObj.toString());
        new User().serializeYaml(userObj);

//        String xmlText = new User().read("xml.xml");
//        new User().deserializrXml(xmlText, SerializableObj.class);
//        new User().serializeYaml(new SerializableObj());
//        String yamlText = new User().read("yaml.yaml");
//        new User().deserializrYaml(yamlText, SerializableObj.class);
//        new User().serializeJson(new SerializableObj());

    }

}