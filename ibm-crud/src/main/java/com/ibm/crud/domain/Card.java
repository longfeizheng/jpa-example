package com.ibm.crud.domain;

import com.ibm.crud.common.NumberUtils;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "card")
public class Card implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Length(min = 16, max = 16)
    @Pattern(regexp = "^[0-9]+$")
    private String number;

    @Length(min = 3, max = 4)
    private String ccv;

    @Length(max = 50)
    private String type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private Set<ConsumptionHis> consumptionHis;

    public String getNumber() {
        return NumberUtils.formatCard(number);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
                "Card[id=%d, number='%s', ccv='%s', type='%s']%n",
                id, number, ccv, type);

        if (consumptionHis != null) {
            for (ConsumptionHis his : consumptionHis) {
                result += String.format(
                        "ConsumptionHis[id=%d, consumption_date='%s', description='%s', amount='%s']%n",
                        his.getId(), his.getConsumptionDate(), his.getDescription(), his.getAmount());
            }
        }

        return result;
    }
}
