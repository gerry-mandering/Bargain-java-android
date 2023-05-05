package com.example.miniproject;

import android.os.Parcel;
import android.os.Parcelable;

public class PromotionParcel implements Parcelable {
    private String businessName;
    private String promotionTitle;
    private String promotionContent;
    private String promotionStartDate;
    private String promotionEndDate;
    private String photoCount;
    private String photo1;
    private String photo2;
    private String photo3;
    private String photo4;
    private String promotionID;

    public PromotionParcel() {

    }

    public PromotionParcel(String businessName, String promotionTitle, String promotionContent, String promotionStartDate, String promotionEndDate, String photoCount, String photo1, String photo2, String photo3, String photo4, String promotionID) {
        this.businessName = businessName;
        this.promotionTitle = promotionTitle;
        this.promotionContent = promotionContent;
        this.promotionStartDate = promotionStartDate;
        this.promotionEndDate = promotionEndDate;
        this.photoCount = photoCount;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.photo3 = photo3;
        this.photo4 = photo4;
        this.promotionID = promotionID;
    }

    protected PromotionParcel(Parcel in) {
        businessName = in.readString();
        promotionTitle = in.readString();
        promotionContent = in.readString();
        promotionStartDate = in.readString();
        promotionEndDate = in.readString();
        photoCount = in.readString();
        photo1 = in.readString();
        photo2 = in.readString();
        photo3 = in.readString();
        photo4 = in.readString();
        promotionID = in.readString();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public void setPromotionTitle(String promotionTitle) {
        this.promotionTitle = promotionTitle;
    }

    public String getPromotionContent() {
        return promotionContent;
    }

    public void setPromotionContent(String promotionContent) {
        this.promotionContent = promotionContent;
    }

    public String getPromotionStartDate() {
        return promotionStartDate;
    }

    public void setPromotionStartDate(String promotionStartDate) {
        this.promotionStartDate = promotionStartDate;
    }

    public String getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(String promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public String getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(String photoCount) {
        this.photoCount = photoCount;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getPhoto3() {
        return photo3;
    }

    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    public String getPhoto4() {
        return photo4;
    }

    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    public String getPromotionID() {
        return promotionID;
    }

    public void setPromotionID(String promotionID) {
        this.promotionID = promotionID;
    }

    public static final Creator<PromotionParcel> CREATOR = new Creator<PromotionParcel>() {
        @Override
        public PromotionParcel createFromParcel(Parcel in) {
            return new PromotionParcel(in);
        }

        @Override
        public PromotionParcel[] newArray(int size) {
            return new PromotionParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;

    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(businessName);
        parcel.writeString(promotionTitle);
        parcel.writeString(promotionContent);
        parcel.writeString(promotionStartDate);
        parcel.writeString(promotionEndDate);
        parcel.writeString(photoCount);
        parcel.writeString(photo1);
        parcel.writeString(photo2);
        parcel.writeString(photo3);
        parcel.writeString(photo4);
        parcel.writeString(promotionID);
    }
}
