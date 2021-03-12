package com.example.ElectricitySubsc.controller;

import com.example.springweb.domObj.ElectricitySubscDO;
import com.example.springweb.dto.ElectricitySubscDTO;
import com.example.springweb.service.ElectricityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ElectricitySubscController {

    @Autowired
    private ElectricityService electricityService;

    @PostMapping(path = "/electric", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ElectricitySubscDO> createElectric(@RequestBody ElectricitySubscDO electricDO){
        ElectricitySubscDO createdElectricity = electricityService.createElectricity(electricDO);
        return new ResponseEntity<>(createdElectricity, HttpStatus.CREATED);
    }

    @PutMapping(path = "/electric", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ElectricitySubscDTO> updateElectric(@RequestBody ElectricitySubscDO electricDO){
        ElectricitySubscDTO updatedElectricity = electricityService.updateElectricity(electricDO);
        return new ResponseEntity<>(updatedElectricity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/electrics/{electricId}")
    public ResponseEntity<ElectricitySubscDO> getElectric(@PathVariable(value="electricId") Long electricId){
        ElectricitySubscDO Electricity = electricityService.getElectricity(electricId);
        return new ResponseEntity<>(Electricity, HttpStatus.OK);
    }

    @GetMapping(path = "/electrics-by-name/{electricName}")
    public ResponseEntity<ElectricitySubscDO> getElectric(@PathVariable(value="electricName") String electricName){
        ElectricitySubscDO Electricity = electricityService.getElectricity(electricName);
        return new ResponseEntity<>(Electricity, HttpStatus.OK);
    }

    @GetMapping(path = "/electrics")
    public ResponseEntity<List<ElectricitySubscDO>> getAllElectrics(){
        List<ElectricitySubscDO> allElectricities = electricityService.getAllElectricity();
        return new ResponseEntity<>(allElectricities, HttpStatus.OK);
    }
    @DeleteMapping(path = "/electrics-delete/{electricId}")
    public ResponseEntity<String> deleteElectric(@PathVariable(value="electricId") Long electricId){
        electricityService.deleteElectricity(electricId);
        return new ResponseEntity<>("Electric with id: " +electricId+ "is deleted.", HttpStatus.OK);
    }


    @GetMapping("/hello")
    String student(){
        return "hello";
    }

}
