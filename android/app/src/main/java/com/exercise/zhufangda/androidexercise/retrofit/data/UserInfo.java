package com.exercise.zhufangda.androidexercise.retrofit.data;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by zhufa on 09/03/2018.
 */
public class UserInfo {
    final static private String TAG = "UserInfo.class";

    @NonNull
    private String uuid;
    @NonNull
    private String email;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String zipCode;
    private String city;
    private String telephone;
    private String electricityProvider;
    private String gasProvider;
    private String subscription;
    private String option;
    private String power;
    private String car;
    private String hasGas;
    private String PDL;
    private String PCE;
    @NonNull
    private long last_FETCHED;

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setHasGas(String hasGas) {
        this.hasGas = hasGas;
    }



    public UserInfo() {
        option = "HP/HC";
        power = "6";
        hasGas = "Sans";
        address1="121 Rue de tolbiac";
        address2="chambre 230";
        telephone="0658474553";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getElectricityProvider() {
        return electricityProvider;
    }

    public void setElectricityProvider(String electricityProvider) {
        this.electricityProvider = electricityProvider;
    }

    public String getGasProvider() {
        return gasProvider;
    }

    public void setGasProvider(String gasProvider) {
        this.gasProvider = gasProvider;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPower() {
        return power;
    }

    public void setPuissance(String power) {
        this.power = power;
    }

    public String getHasGas() {
        return hasGas;
    }

    public void setHasGas(Object hasGas) {

        if(hasGas instanceof Boolean){
            this.hasGas = (Boolean)hasGas ? "Avec" : "Sans";
        }else if(hasGas instanceof String){
            this.hasGas = (String) hasGas;
        }else{
            Log.e(TAG, "setHasGas: Type error" + hasGas.getClass().getSimpleName());
        }
    }


    public String getPDL() {
        return PDL;
    }

    public void setPDL(String PDL) {
        this.PDL = PDL;
    }

    public String getPCE() {
        return PCE;
    }

    public void setPCE(String PCE) {
        this.PCE = PCE;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", telephone='" + telephone + '\'' +
                ", electricityProvider='" + electricityProvider + '\'' +
                ", gasProvider='" + gasProvider + '\'' +
                ", option='" + option + '\'' +
                ", puissance='" + power + '\'' +
                ", hasGas=" + hasGas +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public long getLast_FETCHED() {
        return last_FETCHED;
    }

    public void setLast_FETCHED(long last_FETCHED) {
        this.last_FETCHED = last_FETCHED;
    }
}
