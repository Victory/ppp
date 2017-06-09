package com.parcelpalsportal;

import com.parcelpalsportal.approutes.*;

import com.parcelpalsportal.routeing.Route;
import com.parcelpalsportal.service.AnalyticsStore;
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
