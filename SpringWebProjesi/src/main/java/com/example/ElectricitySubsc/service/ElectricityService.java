package com.example.ElectricitySubsc.service;

import com.example.springweb.domObj.ElectricitySubscDO;
import com.example.springweb.dto.ElectricitySubscDTO;

import java.util.List;

public interface ElectricityService {

     ElectricitySubscDO createElectricity(ElectricitySubscDO electricity);

     ElectricitySubscDTO updateElectricity(ElectricitySubscDO electricity);

     void deleteElectricity(Long electricityId);

     ElectricitySubscDO getElectricity(Long electricityId);

     ElectricitySubscDO getElectricity(String electricityName);

     List<ElectricitySubscDO> getAllElectricity();
}
