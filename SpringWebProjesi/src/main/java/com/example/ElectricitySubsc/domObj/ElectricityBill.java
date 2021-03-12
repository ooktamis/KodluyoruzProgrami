package com.example.ElectricitySubsc.domObj;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Data
@Entity
@Table(name ="electricitybill")
public class ElectricityBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = false)
    private String company;

    private String amount;

    private String period;

    private String price;

    /*@OneToOne(cascade =CascadeType.ALL)// customerde değişiklilk oldugunda adress bilgisde etkilensin
    @JoinColumn(name = "address_id") //adres tablosundan id yi cekiyoruz
    private AddressDO address;*/
    


}
