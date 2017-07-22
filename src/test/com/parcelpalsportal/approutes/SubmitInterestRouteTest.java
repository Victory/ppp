package com.parcelpalsportal.approutes;

import com.parcelpalsportal.service.AnalyticsStore;
import org.junit.Test;
import spark.Request;
import spark.Response;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class SubmitInterestRouteTest {
  @Test
  public void submitsToAnalyticsStore() {
    AnalyticsStore analyticsStore = mock(AnalyticsStore.class);
    SubmitInterestRoute submitInterestRoute = new SubmitInterestRoute(analyticsStore);

    Request req = mock(Request.class);
    Response res = mock(Response.class);
    when(req.queryParams("tos")).thenReturn("true");

    submitInterestRoute.getJsonResponse(req, res, null);
  }

  @Test
  public void submitsToAnalyticsStoreRequiresTosTrue() {
    AnalyticsStore analyticsStore = mock(AnalyticsStore.class);
    SubmitInterestRoute submitInterestRoute = new SubmitInterestRoute(analyticsStore);

    Request req = mock(Request.class);
    Response res = mock(Response.class);
    when(req.queryParams("tos")).thenReturn("false");

    submitInterestRoute.getJsonResponse(req, res, null);
  }

}