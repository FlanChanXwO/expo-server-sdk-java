package com.github.flanchanowo.exception;

import com.github.flanchanowo.response.BaseResponse;

import java.util.List;

public final class ErrorResponseException extends RuntimeException {

  public ErrorResponseException(int code, String phrase, List<BaseResponse.Error> errors) {
    super(createMessage(code, phrase, errors));
  }

  private static String createMessage(int code, String phrase, List<BaseResponse.Error> errors) {
    final StringBuilder sb = new StringBuilder();
    sb.append(String.format("Return code: %d%n", code));
    sb.append(String.format("Phrase: %s%n", phrase));
    sb.append(String.format("Errors:%n"));
    if (errors != null && !errors.isEmpty()) {
      for (BaseResponse.Error error : errors) {
        sb.append(String.format("%s%n", error.toString()));
      }
    } else {
      sb.append("");
    }

    return sb.toString();
  }
}