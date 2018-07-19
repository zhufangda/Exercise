
package com.exercise.zhufangda.androidexercise.retrofit.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("owner")
    @Expose
    private  Owner owner;
    @SerializedName("is_accepted")
    @Expose
    private Boolean isAccepted;
    @SerializedName("score")
    @Expose
    private Long score;
    @SerializedName("last_activity_date")
    @Expose
    private Long lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Long creationDate;
    @SerializedName("answer_id")
    @Expose
    private Long answerId;
    @SerializedName("question_id")
    @Expose
    private Long questionId;
    @SerializedName("last_edit_date")
    @Expose
    private Long lastEditDate;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Long lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

}
