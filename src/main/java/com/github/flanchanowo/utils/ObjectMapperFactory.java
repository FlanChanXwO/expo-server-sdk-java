package com.github.flanchanowo.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public final class ObjectMapperFactory {

  private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();

  private static ObjectMapper createObjectMapper() {
    final ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(NON_NULL);
    return objectMapper;
  }

  private ObjectMapperFactory() {
    throw new UnsupportedOperationException();
  }

  public static ObjectMapper getInstance() {
    return OBJECT_MAPPER;
  }
}