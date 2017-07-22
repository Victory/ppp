package com.parcelpalsportal;

import com.parcelpalsportal.approutes.*;

import com.parcelpalsportal.service.AnalyticsStore;
import org.dfhu.sparkingrocks.routing.Route;
import org.mongodb.morphia.Datastore;
import org.slf4j.LoggerFactory;

class Application {
  static void init(Datastore datastore) {
    AnalyticsStore analyticsStore = new AnalyticsStore(
      datastore,
      LoggerFactory.getLogger(AnalyticsStore.class));

    // Routes
    addRoute(new HomeRoute());
    addRoute(new SubmitInterestRoute(analyticsStore));
  }

  private static void addRoute(Route route) {
    route.addRoute();
  }
}
