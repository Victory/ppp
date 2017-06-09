package com.parcelpalsportal.approutes;

import com.parcelpalsportal.service.AnalyticsStore;
import org.junit.Test;
import spark.Request;
import spark.Response;
import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;

public class SubmitInterestRouteTest {
  @Test
  public void submitsToAnalyticsStore() {
    AnalyticsStore analyticsStore = mock(AnalyticsStore.class);
    SubmitInterestRoute submitInterestRoute = new SubmitInterestRoute(analyticsStore);

    Request req = mock(Request.class);
    Response res = mock(Response.class);

    submitInterestRoute.getJsonResponse(req, res, null);
  }

}