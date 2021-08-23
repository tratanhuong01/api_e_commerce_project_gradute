package com.api.api_e_commerce_project_gradute.DTO;

public class LimitOffset {
  private String id;
  private int limit;
  private int offset;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getOffset() {
    return offset;
  }

  public void setOffset(int offset) {
    this.offset = offset;
  }
}
