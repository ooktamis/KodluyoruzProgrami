package com.example.ElectricitySubsc.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ElectricityBillDTO implements Serializable {
 
    private static final long serialVersionUID = 1L;

    private String company;

    private String amount;

    private String period;

    private String price;
    
}
