package com.parcelpalsportal;

import com.fizzed.rocker.runtime.RockerRuntime;
import com.parcelpalsportal.model.DataProvider;
import org.mongodb.morphia.Datastore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static spark.Spark.staticFiles;

public class ParcelPalsPortal {
  public static void main(String[] args) {
    try {
      System.getProperties().load(new FileInputStream("config.properties"));
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException("Could not find config file config.properties");
    }
    boolean dev = System.getProperty("dev").equals("true");

    if (dev) {
      // DEBUGING
      RockerRuntime.getInstance().setReloading(true);
      String publicDir = System.getProperty("user.dir") + "/src/main/resources/public";
      staticFiles.externalLocation(publicDir);
    } else {
      // PRODUCTION
      staticFiles.location("/public");
      RockerRuntime.getInstance().setReloading(false);
    }

    Datastore datastore = DataProvider.get("com.parcelpalsportal.morphs");

    // log queries in dev mode
    if (dev) {
      Logger logger = Logger.getLogger("class org.mongodb.morphia.DatastoreImpl");
      logger.setLevel(Level.FINER);
    }

    Application.init(datastore);
  }
}
