package com.parcelpalsportal.templateengine;

import com.fizzed.rocker.runtime.DefaultRockerModel;
import com.google.gson.Gson;
import com.parcelpalsportal.RouteManager;
import org.dfhu.sparkingrocks.viewmodels.ViewModel;

public abstract class BaseModel extends DefaultRockerModel {

  private static final Gson gson = new Gson();

  public ViewModel vm() {
    return null;
  }

  public static String docType() {
    return "<!DOCTYPE html>";
  }

  public static RouteManager route() {
    return RouteManager.getInstance();
  }

  /**
   * Escapes an html attribute
   *
   * @param attr - string to escape
   * @return attribute to be used inside of quotes
   */
  public static String attr(String attr) {
    if (attr.contains("\"")) {
      return attr.replace("\"", "&quot;");
    }
    return attr;
  }

  /**
   * Creates javascript script tag that sets, window.vic.key = val;
   * This also initializes window.vic
   *
   * @param key - js variable name
   * @param val - js variable value
   * @return - script tags
   */
  public static String jsVar(String key, Object val) {
    if (key == null || val == null) {
      return "";
    }

    String script = "<script>" +
      "window.vic = window.vic || {};" +
      "window.vic." + key + " = " + gson.toJson(val) + ";" +
      "</script>";
    return script;
  }
}
