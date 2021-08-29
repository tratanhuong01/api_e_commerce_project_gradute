package com.api.api_e_commerce_project_gradute.DTO.review_product;

public class InfoReviewProduct {
  private int sumReview;
  private int sumAll;
  private int oneStar;
  private int twoStar;
  private int threeStar;
  private int fourStar;
  private int fiveStar;
  private int images;

  public int getSumAll() {
    return sumAll;
  }

  public void setSumAll(int sumAll) {
    this.sumAll = sumAll;
  }

  public int getSumReview() {
    return sumReview;
  }

  public void setSumReview(int sumReview) {
    this.sumReview = sumReview;
  }

  public int getOneStar() {
    return oneStar;
  }

  public void setOneStar(int oneStar) {
    this.oneStar = oneStar;
  }

  public int getTwoStar() {
    return twoStar;
  }

  public void setTwoStar(int twoStar) {
    this.twoStar = twoStar;
  }

  public int getThreeStar() {
    return threeStar;
  }

  public void setThreeStar(int threeStar) {
    this.threeStar = threeStar;
  }

  public int getFourStar() {
    return fourStar;
  }

  public void setFourStar(int fourStar) {
    this.fourStar = fourStar;
  }

  public int getFiveStar() {
    return fiveStar;
  }

  public void setFiveStar(int fiveStar) {
    this.fiveStar = fiveStar;
  }

  public int getImages() {
    return images;
  }

  public void setImages(int images) {
    this.images = images;
  }
}
