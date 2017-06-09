package com.parcelpalsportal.approutes;

import com.fizzed.rocker.RockerModel;
import com.parcelpalsportal.RouteManager;
import com.parcelpalsportal.VicSession;
import com.parcelpalsportal.routeing.Route;
import com.parcelpalsportal.routeing.TemplateRoute;
import com.parcelpalsportal.viewmodels.HomeViewModel;
import com.parcelpalsportal.views.home.Home;
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
