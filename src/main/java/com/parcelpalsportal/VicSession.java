package com.parcelpalsportal;

import spark.Request;
import spark.Response;

public class VicSession {
  private final Request request;
  private final Response response;

  public VicSession(Request request, Response response) {
   this.request = request;
   this.response = response;
  }
}
