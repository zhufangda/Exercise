
package com.exercise.zhufangda.androidexercise.network;

import com.exercise.zhufangda.androidexercise.retrofit.data.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SOAnswersResponse {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("has_more")
    @Expose
    private Boolean hasMore;
    @SerializedName("quota_max")
    @Expose
    private Long quotaMax;
    @SerializedName("quota_remaining")
    @Expose
    private Long quotaRemaining;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Long getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Long quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Long getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Long quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

}
