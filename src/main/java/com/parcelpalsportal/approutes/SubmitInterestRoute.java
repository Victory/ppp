package com.parcelpalsportal.approutes;

import com.parcelpalsportal.RouteManager;
import com.parcelpalsportal.morphs.ContactMorph;
import com.parcelpalsportal.service.AnalyticsStore;
import org.dfhu.sparkingrocks.routing.JsonResponse;
import org.dfhu.sparkingrocks.routing.JsonRoute;
import org.dfhu.sparkingrocks.routing.Route;
import org.dfhu.sparkingrocks.session.VicSession;
import org.dfhu.sparkingrocks.util.StandardRequestLog;
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
    return Route.METHOD.POST;
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
