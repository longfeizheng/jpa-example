package com.ibm.crud.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "consumption_his")
public class ConsumptionHis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date consumptionDate;

    @Column
    @Length(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String description;

    @Column
    @Length(max = 12)
    @Pattern(regexp = "^[0-9]+$")
    private String amount;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @OneToOne(mappedBy = "consumptionHis")
    private BankAdvisors bankAdvisors;


    public BankAdvisors getBankAdvisors() {
        return bankAdvisors;
    }

    public void setBankAdvisors(BankAdvisors bankAdvisors) {
        this.bankAdvisors = bankAdvisors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "ConsumptionHis{" +
                "id=" + id +
                ", consumptionDate=" + consumptionDate +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", client=" + client +
                ", card=" + card +
                ", bankAdvisors=" + bankAdvisors +
                '}';
    }
}
