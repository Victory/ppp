package com.parcelpalsportal;

import com.parcelpalsportal.approutes.*;

import com.parcelpalsportal.service.AnalyticsStore;
import com.parcelpalsportal.templateengine.BaseModel;
import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.routing.Route;
import org.mongodb.morphia.Datastore;
import org.slf4j.LoggerFactory;

class Application {
  static void init(Datastore datastore, PropertiesConfig config) {

    String analyticsTrackingId = config.getAnalyticsTrackingId();
    if (analyticsTrackingId == null) {
      throw new RuntimeException("analyticsTrackingId is required in config.properties");
    } else {
      BaseModel.setAnalyticsTrackingId(analyticsTrackingId);
    }

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
