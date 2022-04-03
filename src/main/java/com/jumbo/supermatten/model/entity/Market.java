package com.jumbo.supermatten.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MARKET")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "CITY")
    private String city;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "STREET")
    private String street;
    @Column(name = "STREET2")
    private String street2;
    @Column(name = "STREET3")
    private String street3;
    @Column(name = "ADDRESS_NAME")
    private String addressName;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "LONGITUDE")
    private Double longitude;
    @Column(name = "LATITUDE")
    private Double latitude;
    @Column(name = "COMPLEX_NUMBER")
    private String complexNumber;
    @Column(name = "SHOW_WARNING_MESSAGE")
    private boolean showWarningMessage;
    @Column(name = "TODAY_OPEN")
    private String todayOpen;
    @Column(name = "LOCATION_TYPE")
    private String locationType;
    @Column(name = "COLLECTION_POINT")
    private boolean collectionPoint;
    @Column(name = "SAP_STORE_ID")
    private String sapStoreID;
    @Column(name = "TODAY_CLOSE")
    private String todayClose;
}
