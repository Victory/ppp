package com.parcelpalsportal.approutes;

import com.fizzed.rocker.RockerModel;
import com.parcelpalsportal.RouteManager;
import com.parcelpalsportal.viewmodels.HomeViewModel;
import com.parcelpalsportal.views.home.Home;
import org.dfhu.sparkingrocks.routing.Route;
import org.dfhu.sparkingrocks.routing.TemplateRoute;
import org.dfhu.sparkingrocks.session.VicSession;
import spark.Request;
import spark.Response;

public class HomeRoute extends TemplateRoute implements Route {

  @Override
  public String getPath() {
    return RouteManager.home();
  }

  @Override
  public Route.METHOD getMethod() {
    return METHOD.GET;
  }

  @Override
  public RockerModel getRockerModel(Request req, Response res, VicSession vicSession) {
    HomeViewModel vm = new HomeViewModel(vicSession);
    return Home.template(vm);
  }
}
