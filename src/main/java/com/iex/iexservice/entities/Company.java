package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
public class Company {
    @Id
    private String symbol;
    private String companyName;
    private int employees;
    private String exchange;
    private String industry;
    private String website;
    private String description;
    private String CEO;
    private String securityName;
    private String issueType;
    private String sector;
    private int primarySicCode;
    private List<String> tags;
    private String address;
    private String address2;
    private String state;
    private String city;
    private String zip;
    private String country;
    private String phone;

    @JsonCreator
    public Company(@JsonProperty("symbol") String symbol,
                   @JsonProperty("companyName")String companyName,
                   @JsonProperty("employees")int employees,
                   @JsonProperty("exchange")String exchange,
                   @JsonProperty("industry")String industry,
                   @JsonProperty("website")String website,
                   @JsonProperty("description")String description,
                   @JsonProperty("CEO")String CEO,
                   @JsonProperty("securityName")String securityName,
                   @JsonProperty("issueType")String issueType,
                   @JsonProperty("sector")String sector,
                   @JsonProperty("primarySicCode")int primarySicCode,
                   @JsonProperty("tags")List<String> tags,
                   @JsonProperty("address")String address,
                   @JsonProperty("address2")String address2,
                   @JsonProperty("state")String state,
                   @JsonProperty("city")String city,
                   @JsonProperty("zip")String zip,
                   @JsonProperty("country")String country,
                   @JsonProperty("phone")String phone) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.employees = employees;
        this.exchange = exchange;
        this.industry = industry;
        this.website = website;
        this.description = description;
        this.CEO = CEO;
        this.securityName = securityName;
        this.issueType = issueType;
        this.sector = sector;
        this.primarySicCode = primarySicCode;
        this.tags = tags;
        this.address = address;
        this.address2 = address2;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.phone = phone;
    }
}
