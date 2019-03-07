package com.ibm.crud.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bank_advisors")
public class BankAdvisors implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Length(max = 50)
    private String name;

    @Column
    @Length(max = 50)
    private String specialty;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "consumption_his_id")
    private ConsumptionHis consumptionHis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ConsumptionHis getConsumptionHis() {
        return consumptionHis;
    }

    public void setConsumptionHis(ConsumptionHis consumptionHis) {
        this.consumptionHis = consumptionHis;
    }
}
