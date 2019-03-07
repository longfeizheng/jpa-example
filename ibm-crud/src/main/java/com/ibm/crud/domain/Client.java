package com.ibm.crud.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Length(max = 50)
    private String name;

    @Length(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String address;

    @Length(max = 30)
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String city;

    @Length(max = 20)
    @Pattern(regexp = "^[0-9]+$")
    private String telephone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Card> cards;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<ConsumptionHis> consumptionHis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    public Set<ConsumptionHis> getConsumptionHis() {
        return consumptionHis;
    }

    public void setConsumptionHis(Set<ConsumptionHis> consumptionHis) {
        this.consumptionHis = consumptionHis;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Client[id=%d, name='%s', address='%s', city='%s', telephone='%s']%n",
                id, name, address, city, telephone);
        if (cards != null) {
            for (Card card : cards) {
                result += String.format(
                        "Card[id=%d, number='%s', ccv='%s', type='%s']%n",
                        card.getId(), card.getNumber(), card.getCcv(), card.getType());
            }
        }
        if (consumptionHis != null) {
            for(ConsumptionHis his: consumptionHis){
                result += String.format(
                        "ConsumptionHis[id=%d, consumption_date='%s', description='%s', amount='%s']%n",
                        his.getId(), his.getConsumptionDate(), his.getDescription(), his.getAmount());
            }
        }

        return result;
    }
}
