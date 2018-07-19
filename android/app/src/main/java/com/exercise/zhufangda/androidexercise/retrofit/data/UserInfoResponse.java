package com.exercise.zhufangda.androidexercise.retrofit.data;

public class UserInfoResponse {
    private int UID;
    private String Token;
    private String NickName;
    private String UserName;
    private int AuthorCode;
    private int CountryCode;
    private String Mobile;
    private String Email;
    private int VerificationStatus;
    private int AccountType;
    private int LockFlag;
    private String HeadImgURL;
    private String HeadImgThumbnailURL;
    private int DeleteFlag;
    private int FID;
    private Object FileMD5Contents;

    public UserInfoResponse() {
    }

    public int getUID() {
        return this.UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public String getToken() {
        return this.Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getNickName() {
        return this.NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public int getAuthorCode() {
        return this.AuthorCode;
    }

    public void setAuthorCode(int AuthorCode) {
        this.AuthorCode = AuthorCode;
    }

    public int getCountryCode() {
        return this.CountryCode;
    }

    public void setCountryCode(int CountryCode) {
        this.CountryCode = CountryCode;
    }

    public String getMobile() {
        return this.Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getVerificationStatus() {
        return this.VerificationStatus;
    }

    public void setVerificationStatus(int VerificationStatus) {
        this.VerificationStatus = VerificationStatus;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public int getAccountType() {
        return this.AccountType;
    }

    public void setAccountType(int AccountType) {
        this.AccountType = AccountType;
    }

    public int getLockFlag() {
        return this.LockFlag;
    }

    public void setLockFlag(int LockFlag) {
        this.LockFlag = LockFlag;
    }

    public String getHeadImgURL() {
        return this.HeadImgURL;
    }

    public void setHeadImgURL(String HeadImgURL) {
        this.HeadImgURL = HeadImgURL;
    }

    public String getHeadImgThumbnailURL() {
        return this.HeadImgThumbnailURL;
    }

    public void setHeadImgThumbnailURL(String HeadImgThumbnailURL) {
        this.HeadImgThumbnailURL = HeadImgThumbnailURL;
    }

    public int getDeleteFlag() {
        return this.DeleteFlag;
    }

    public void setDeleteFlag(int DeleteFlag) {
        this.DeleteFlag = DeleteFlag;
    }

    public int getFID() {
        return this.FID;
    }

    public void setFID(int FID) {
        this.FID = FID;
    }

    public Object getFileMD5Contents() {
        return this.FileMD5Contents;
    }

    public void setFileMD5Contents(Object FileMD5Contents) {
        this.FileMD5Contents = FileMD5Contents;
    }
}