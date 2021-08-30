package com.iex.iexservice.DAO;

import com.iex.iexservice.entities.CompanyDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "company")
@Data
public class CompanyEntity {
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

    public static CompanyEntity fromDtoToEntity(CompanyDto companyDto) {
        CompanyEntity entity = new CompanyEntity();
        entity.symbol = companyDto.getSymbol();
        entity.companyName = companyDto.getCompanyName();
        entity.employees = companyDto.getEmployees();
        entity.exchange = companyDto.getExchange();
        entity.industry = companyDto.getIndustry();
        entity.website = companyDto.getWebsite();
        entity.description = companyDto.getDescription();
        entity.CEO = companyDto.getCEO();
        entity.securityName = companyDto.getSecurityName();
        entity.issueType = companyDto.getIssueType();
        entity.sector = companyDto.getSector();
        entity.primarySicCode = companyDto.getPrimarySicCode();
        entity.tags = companyDto.getTags();
        entity.address = companyDto.getAddress();
        entity.address2 = companyDto.getAddress2();
        entity.state = companyDto.getState();
        entity.city = companyDto.getCity();
        entity.zip = companyDto.getZip();
        entity.country = companyDto.getCountry();
        entity.phone = companyDto.getPhone();
        return entity;
    }


    public CompanyDto toDto() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setSymbol(getSymbol());
        companyDto.setCompanyName(getCompanyName());
        companyDto.setEmployees(getEmployees());
        companyDto.setExchange(getExchange());
        companyDto.setIndustry(getIndustry());
        companyDto.setWebsite(getWebsite());
        companyDto.setDescription(getDescription());
        companyDto.setCEO(getCEO());
        companyDto.setSecurityName(getSecurityName());
        companyDto.setIssueType(getIssueType());
        companyDto.setSector(getSector());
        companyDto.setPrimarySicCode(getPrimarySicCode());
        companyDto.setTags(getTags());
        companyDto.setAddress(getAddress());
        companyDto.setAddress2(getAddress2());
        companyDto.setState(getState());
        companyDto.setCity(getCity());
        companyDto.setZip(getZip());
        companyDto.setCountry(getCountry());
        companyDto.setPhone(getPhone());
        return companyDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity company = (CompanyEntity) o;
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
