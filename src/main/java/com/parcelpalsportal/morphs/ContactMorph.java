package com.parcelpalsportal.morphs;

import org.dfhu.sparkingrocks.morphs.AbstractLog;
import org.mongodb.morphia.annotations.Entity;

@Entity("contact")
public class ContactMorph extends AbstractLog {
  public String email;
  public String name;
  public String comments;
  public boolean tos;
}
