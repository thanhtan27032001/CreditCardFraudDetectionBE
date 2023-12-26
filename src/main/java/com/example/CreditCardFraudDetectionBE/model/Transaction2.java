package com.example.CreditCardFraudDetectionBE.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction2 {
    @JsonProperty
    double distanceFromHome;
    @JsonProperty
    double distanceFromLastTransaction;
    @JsonProperty()
    double ratioToMedianPurchasePrice;
    @JsonProperty()
    int repeatRetailer;
    @JsonProperty()
    int usedChip;
    @JsonProperty()
    int usedPinNumber;
    @JsonProperty()
    int onlineOrder;

    public Transaction2(double distanceFromHome, double distanceFromLastTransaction, double ratioToMedianPurchasePrice, int repeatRetailer, int usedChip, int usedPinNumber, int onlineOrder) {
        this.distanceFromHome = distanceFromHome;
        this.distanceFromLastTransaction = distanceFromLastTransaction;
        this.ratioToMedianPurchasePrice = ratioToMedianPurchasePrice;
        this.repeatRetailer = repeatRetailer;
        this.usedChip = usedChip;
        this.usedPinNumber = usedPinNumber;
        this.onlineOrder = onlineOrder;
    }
}
