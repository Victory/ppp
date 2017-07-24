package com.parcelpalsportal;

import com.fizzed.rocker.runtime.RockerRuntime;
import org.dfhu.sparkingrocks.config.PropertiesConfig;
import org.dfhu.sparkingrocks.config.ReadSystemProperties;
import org.dfhu.sparkingrocks.model.DataProvider;
import org.mongodb.morphia.Datastore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.staticFiles;

public class ParcelPalsPortal {
  public static void main(String[] args) {

    PropertiesConfig config = ReadSystemProperties.read();

    if (config.isDevelopment()) {
      // DEBUGING
      RockerRuntime.getInstance().setReloading(true);
      String publicDir = System.getProperty("user.dir") + "/src/main/resources/public";
      staticFiles.externalLocation(publicDir);
    } else {
      // PRODUCTION
      staticFiles.location("/public");
      RockerRuntime.getInstance().setReloading(false);
    }

    Datastore datastore = DataProvider
      .create(Arrays.asList("com.parcelpalsportal.morphs"), config);


    // log queries in dev mode
    if (config.isDevelopment()) {
      Logger logger = Logger.getLogger("class org.mongodb.morphia.DatastoreImpl");
      logger.setLevel(Level.FINER);
    }

    Application.init(datastore, config);
  }
}
