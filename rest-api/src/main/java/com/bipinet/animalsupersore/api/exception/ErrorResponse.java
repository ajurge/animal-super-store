package com.bipinet.animalsupersore.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import org.immutables.value.Value;

@Value.Immutable
interface ErrorResponse {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  @JsonProperty
  LocalDateTime timestamp();

  @JsonProperty
  int status();

  @JsonProperty
  String error();

}
