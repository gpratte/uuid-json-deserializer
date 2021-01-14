package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.IOException;
import java.util.UUID;

public class Main {

  public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();

    // Comment out next three lines to use field annotation
    SimpleModule module = new SimpleModule();
    module.addDeserializer(UUID.class, new MyUUIDDeserializer());
    mapper.registerModule(module);

    Foo foo = mapper.readValue("{\"id\":\"bad\"}", Foo.class);
    System.out.println(foo);
  }
}
