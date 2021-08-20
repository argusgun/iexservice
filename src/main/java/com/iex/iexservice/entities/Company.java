package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return employees == company.employees &&
                primarySicCode == company.primarySicCode &&
                Objects.equals(symbol, company.symbol) &&
                Objects.equals(companyName, company.companyName) &&
                Objects.equals(exchange, company.exchange) &&
                Objects.equals(industry, company.industry) &&
                Objects.equals(website, company.website) &&
                Objects.equals(description, company.description) &&
                Objects.equals(CEO, company.CEO) &&
                Objects.equals(securityName, company.securityName) &&
                Objects.equals(issueType, company.issueType) &&
                Objects.equals(sector, company.sector) &&
                Objects.equals(tags, company.tags) &&
                Objects.equals(address, company.address) &&
                Objects.equals(address2, company.address2) &&
                Objects.equals(state, company.state) &&
                Objects.equals(city, company.city) &&
                Objects.equals(zip, company.zip) &&
                Objects.equals(country, company.country) &&
                Objects.equals(phone, company.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, companyName, employees, exchange, industry, website, description, CEO, securityName, issueType, sector, primarySicCode, tags, address, address2, state, city, zip, country, phone);
    }
}
