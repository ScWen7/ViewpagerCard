package com.pinxiango.studytest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 解晓辉 on 2017/9/8.
 * 作用：
 */

public class CardItem implements Parcelable {
    private String imageUrl;
    private String text;

    private String linkUrl;

    public CardItem(String imageUrl, String text, String linkUrl) {
        this.imageUrl = imageUrl;
        this.text = text;
        this.linkUrl = linkUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.text);
        dest.writeString(this.linkUrl);
    }

    protected CardItem(Parcel in) {
        this.imageUrl = in.readString();
        this.text = in.readString();
        this.linkUrl = in.readString();
    }

    public static final Parcelable.Creator<CardItem> CREATOR = new Parcelable.Creator<CardItem>() {
        @Override
        public CardItem createFromParcel(Parcel source) {
            return new CardItem(source);
        }

        @Override
        public CardItem[] newArray(int size) {
            return new CardItem[size];
        }
    };
}
