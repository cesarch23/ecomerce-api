package com.edu.Ecomerce.DTO;

import lombok.Getter;

public class PurchaseDate {

    @Getter
    private String $id;
    @Getter
    private String currentDateTime;
    @Getter
    private  String utcOffset;
    private  boolean isDayLightSavingsTime;
    @Getter
    private  String dayOfTheWeek;
    @Getter
    private String timeZoneName;
    @Getter
    private Long currentFileTime;
    @Getter
    private  String ordinalDate;
    @Getter
    private  String serviceResponse;

    public void set$id(String $id) {
        this.$id = $id;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public void setUtcOffset(String utcOffset) {
        this.utcOffset = utcOffset;
    }

    public boolean isDayLightSavingsTime() {
        return isDayLightSavingsTime;
    }

    public void setDayLightSavingsTime(boolean dayLightSavingsTime) {
        isDayLightSavingsTime = dayLightSavingsTime;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }

    public void setCurrentFileTime(Long currentFileTime) {
        this.currentFileTime = currentFileTime;
    }

    public void setOrdinalDate(String ordinalDate) {
        this.ordinalDate = ordinalDate;
    }

    public void setServiceResponse(String serviceResponse) {
        this.serviceResponse = serviceResponse;
    }




}
