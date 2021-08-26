package com.iex.iexservice.DAO;

import com.iex.iexservice.entities.Company;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

@Data
public class CompanyDAO {
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

    public CompanyDAO(String symbol, String companyName, int employees, String exchange, String industry, String website, String description, String CEO, String securityName, String issueType, String sector, int primarySicCode, List<String> tags, String address, String address2, String state, String city, String zip, String country, String phone) {
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

    public CompanyDAO() {

    }

    public static CompanyDAO fromEntityToDao(Company company) {
        CompanyDAO dao = new CompanyDAO();
        dao.symbol = company.getSymbol();
        dao.companyName = company.getCompanyName();
        dao.employees = company.getEmployees();
        dao.exchange = company.getExchange();
        dao.industry = company.getIndustry();
        dao.website = company.getWebsite();
        dao.description = company.getDescription();
        dao.CEO = company.getCEO();
        dao.securityName = company.getSecurityName();
        dao.issueType = company.getIssueType();
        dao.sector = company.getSector();
        dao.primarySicCode = company.getPrimarySicCode();
        dao.tags = company.getTags();
        dao.address = company.getAddress();
        dao.address2 = company.getAddress2();
        dao.state = company.getState();
        dao.city = company.getCity();
        dao.zip = company.getZip();
        dao.country = company.getCountry();
        dao.phone = company.getPhone();
        return dao;
    }


    public Company toEntity() {
        return new Company(symbol,
                companyName,
                employees,
                exchange,
                industry,
                website,
                description,
                CEO,
                securityName,
                issueType,
                sector,
                primarySicCode,
                tags,
                address,
                address2,
                state,
                city,
                zip,
                country,
                phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDAO company = (CompanyDAO) o;
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
