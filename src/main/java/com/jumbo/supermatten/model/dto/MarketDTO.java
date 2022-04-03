package com.jumbo.supermatten.model.dto;

import lombok.Data;
@Data
public class MarketDTO {
    private long id;
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private String uuid;
    private Double longitude;
    private Double latitude;
    private String complexNumber;
    private boolean showWarningMessage;
    private String todayOpen;
    private String locationType;
    private boolean collectionPoint;
    private String sapStoreID;
    private String todayClose;
}
