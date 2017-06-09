package com.parcelpalsportal;

/**
 * Organizes Routes
 */
public class RouteManager {
  private static RouteManager INSTANCE = new RouteManager();

  private RouteManager() {
  }

  public static RouteManager getInstance() {
    return INSTANCE;
  }

  public static String home() {
    return "/";
  }

  public static String submitInterest() {
    return "/api/submit-interest";
  }
}
