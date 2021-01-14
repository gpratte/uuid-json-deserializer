package org.example;

import java.util.UUID;

public class Foo {

  // Uncomment to use field annotation
  //@JsonDeserialize(using = MyUUIDDeserializer.class)
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Foo{" +
        "id=" + id +
        '}';
  }
}
