package com.parcelpalsportal.morphs.queries;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public class BaseQuery {

  protected final Datastore datastore;

  public BaseQuery(Datastore datastore) {
    this.datastore = datastore;
  }

  protected ObjectId toObjectId(String id) {
    return new ObjectId(id);
  }
}
