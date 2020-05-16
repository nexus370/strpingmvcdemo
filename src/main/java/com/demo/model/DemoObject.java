package com.demo.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "Song")
public class DemoObject implements Serializable {
    @Id
    @Column(name = "s_id")
    private BigInteger id;

    @Column(name = "s_title")
    private String title;

    private String genreName;
    private String producerName;

    @Column(name = "s_price")
    private BigDecimal price;

    @Column(name = "s_last_modified_date")
    private String lastModifiedDate;

    @Column(name = "s_added_date")
    private String addedDate;

    @Column(name = "s_downloads")
    private BigInteger downloads;

    @Column(name = "s_sales")
    private BigInteger sales;

    @Column(name = "s_rating")
    private BigDecimal rating;

    @Column(name = "s_status")
    private int status;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public BigInteger getDownloads() {
        return downloads;
    }

    public void setDownloads(BigInteger downloads) {
        this.downloads = downloads;
    }

    public BigInteger getSales() {
        return sales;
    }

    public void setSales(BigInteger sales) {
        this.sales = sales;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DemoObject{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genreName='" + genreName + '\'' +
                ", producerName='" + producerName + '\'' +
                ", price=" + price +
                ", lastModifiedDate='" + lastModifiedDate + '\'' +
                ", addedDate='" + addedDate + '\'' +
                ", downloads=" + downloads +
                ", sales=" + sales +
                ", rating=" + rating +
                ", status=" + status +
                '}';
    }
}
