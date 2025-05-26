package com.github.flanchanowo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Status of push notification. */
public enum Status {
  @JsonProperty("ok")
  OK,

  @JsonProperty("error")
  ERROR
}