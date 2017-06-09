package com.parcelpalsportal.approutes;

import com.parcelpalsportal.RouteManager;
import com.parcelpalsportal.VicSession;
import com.parcelpalsportal.morphs.ContactMorph;
import com.parcelpalsportal.routeing.JsonResponse;
import com.parcelpalsportal.routeing.JsonRoute;
import com.parcelpalsportal.routeing.Route;
import com.parcelpalsportal.service.AnalyticsStore;
import com.parcelpalsportal.util.StandardRequestLog;
import spark.Request;
import spark.Response;

public class SubmitInterestRoute extends JsonRoute implements Route {

  private final AnalyticsStore analyticsStore;

  public SubmitInterestRoute(AnalyticsStore analyticsStore) {
    this.analyticsStore = analyticsStore;
  }

  @Override
  public String getPath() {
    return RouteManager.submitInterest();
  }

  @Override
  public METHOD getMethod() {
    return METHOD.POST;
  }

  @Override
  public JsonResponse getJsonResponse(Request req, Response res, VicSession vicSession) {
    String email = req.queryParams("email");
    String comments = req.queryParams("comments");
    String name = req.queryParams("name");
    boolean tos = req.queryParams("tos").equals("true");

    ContactMorph contactMorph = StandardRequestLog.build(
      ContactMorph.class,
      req,
      req.pathInfo());

    contactMorph.comments = comments;
    contactMorph.email = email;
    contactMorph.name = name;
    contactMorph.tos = tos;
    analyticsStore.submit(contactMorph);

    return new JsonResponse(true, "Message Submitted");
  }
}
