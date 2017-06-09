package com.parcelpalsportal.model;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class DataProvider {
  public static Datastore get(String packageMap) {
    Morphia morphia = new Morphia();
    // tell Morphia where to find your classes
    // can be called multiple times with different packages or classes
    try {
      morphia.mapPackage(packageMap);
    } catch (Throwable t) {
      throw new RuntimeException("Could not find packages: " + t.getMessage());
    }

    String mongohostname = System.getProperty("mongohostname");

    // create the Datastore connecting to the default port on the local host
    Datastore datastore = morphia.createDatastore(
      new MongoClient(mongohostname), "parcelpalsportal");
    datastore.ensureIndexes();

    return datastore;
  }

}
