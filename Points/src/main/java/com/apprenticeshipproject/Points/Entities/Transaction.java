package com.apprenticeshipproject.Points.Entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

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
    private Timestamp timestamp;

    public Transaction() {
    }

    public Transaction(String payer, Integer points, Timestamp timestamp) {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
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