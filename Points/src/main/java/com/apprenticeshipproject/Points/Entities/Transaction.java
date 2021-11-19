package com.apprenticeshipproject.Points.Entities;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "TRANSACTIONS")
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "payer_name")
    private String payer;

    @Column(name = "payer_points")
    private Integer points;

    @Column(name = "transaction_timestamp")
    private LocalDate timestamp;

    public Transaction() {
    }

    public Transaction(String payer, Integer points, LocalDate timestamp) {
        this.payer = payer;
        this.points = points;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "payer='" + payer + '\'' +
                ", points=" + points +
                ", timestamp=" + timestamp +
                '}';
    }
}