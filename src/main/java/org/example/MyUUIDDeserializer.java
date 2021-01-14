package org.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import java.io.IOException;
import java.util.UUID;

public class MyUUIDDeserializer extends UUIDDeserializer {

  @Override
  public UUID deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    try {
      return super.deserialize(jsonParser, deserializationContext);
    } catch (InvalidFormatException e) {
      if (e.getProcessor() != null && e.getProcessor() instanceof JsonParser) {
        throw new InvalidFormatException((JsonParser) e.getProcessor(), "must be a valid UUID",
            e.getValue(),
            e.getTargetType());
      } else {
        throw e;
      }
    }
  }
}
