package com.iex.iexservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class CompanyDto {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDto companyDto = (CompanyDto) o;
        return employees == companyDto.employees &&
                primarySicCode == companyDto.primarySicCode &&
                Objects.equals(symbol, companyDto.symbol) &&
                Objects.equals(companyName, companyDto.companyName) &&
                Objects.equals(exchange, companyDto.exchange) &&
                Objects.equals(industry, companyDto.industry) &&
                Objects.equals(website, companyDto.website) &&
                Objects.equals(description, companyDto.description) &&
                Objects.equals(CEO, companyDto.CEO) &&
                Objects.equals(securityName, companyDto.securityName) &&
                Objects.equals(issueType, companyDto.issueType) &&
                Objects.equals(sector, companyDto.sector) &&
                Objects.equals(tags, companyDto.tags) &&
                Objects.equals(address, companyDto.address) &&
                Objects.equals(address2, companyDto.address2) &&
                Objects.equals(state, companyDto.state) &&
                Objects.equals(city, companyDto.city) &&
                Objects.equals(zip, companyDto.zip) &&
                Objects.equals(country, companyDto.country) &&
                Objects.equals(phone, companyDto.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, companyName, employees, exchange, industry, website, description, CEO, securityName, issueType, sector, primarySicCode, tags, address, address2, state, city, zip, country, phone);
    }
}
