package com.parcelpalsportal.approutes;

import org.junit.Test;
import spark.Request;
import spark.Response;

import static org.powermock.api.mockito.PowerMockito.mock;

public class HomeRouteTest {
  @Test
  public void testSessionNotNeeded() {
    HomeRoute homeRoute = new HomeRoute();
    Request req = mock(Request.class);
    Response res = mock(Response.class);
    homeRoute.getRockerModel(req, res, null);
  }
}
