package com.example.ElectricitySubsc.domObj;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
@Data
@Entity
@Table(name ="electricitysubs")
public class ElectricitySubscDO {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String department;//kurum mu, ev mi, sanayimi gibi gibi ... 

    private String name;

    private String lastname;

    @OneToOne(cascade =CascadeType.ALL)// customerde değişiklilk oldugunda adress bilgisde etkilensin
    @JoinColumn(name = "address_id") //adres tablosundan id yi cekiyoruz
    private AddressDO address;

    /**
     * Burdan sonrası Eklendi
     */
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "electricitybill_id") 
    private ElectricityBill bill;


}
