package org.example.entity;

public class FileEntity {

    private String article;

    private String type;

    private String saleDate;

    private Double salePrice;

    private Double derivedCosts;

    private Double productionCosts;

    private Double taxes;

    private Double benefit;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getDerivedCosts() {
        return derivedCosts;
    }

    public void setDerivedCosts(Double derivedCosts) {
        this.derivedCosts = derivedCosts;
    }

    public Double getProductionCosts() {
        return productionCosts;
    }

    public void setProductionCosts(Double productionCosts) {
        this.productionCosts = productionCosts;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getBenefit() {
        return benefit;
    }

    public void setBenefit(Double benefit) {
        this.benefit = benefit;
    }

    public FileEntity(String article, String type, String saleDate, Double salePrice, Double derivedCosts, Double productionCosts, Double taxes, Double benefit) {
        this.article = article;
        this.type = type;
        this.saleDate = saleDate;
        this.salePrice = salePrice;
        this.derivedCosts = derivedCosts;
        this.productionCosts = productionCosts;
        this.taxes = taxes;
        this.benefit = benefit;



    }


}

