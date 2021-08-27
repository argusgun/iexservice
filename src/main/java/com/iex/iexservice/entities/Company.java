package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class Company {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("employees")
    private int employees;
    @JsonProperty("exchange")
    private String exchange;
    @JsonProperty("industry")
    private String industry;
    @JsonProperty("website")
    private String website;
    @JsonProperty("description")
    private String description;
    @JsonProperty("CEO")
    private String CEO;
    @JsonProperty("securityName")
    private String securityName;
    @JsonProperty("issueType")
    private String issueType;
    @JsonProperty("sector")
    private String sector;
    @JsonProperty("primarySicCode")
    private int primarySicCode;
    @JsonProperty("tags")
    private List<String> tags;
    @JsonProperty("address")
    private String address;
    @JsonProperty("address2")
    private String address2;
    @JsonProperty("state")
    private String state;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("country")
    private String country;
    @JsonProperty("phone")
    private String phone;

    public Company() {
    }

    public Company(String symbol, String companyName, int employees, String exchange, String industry, String website, String description, String CEO, String securityName, String issueType, String sector, int primarySicCode, List<String> tags, String address, String address2, String state, String city, String zip, String country, String phone) {
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
