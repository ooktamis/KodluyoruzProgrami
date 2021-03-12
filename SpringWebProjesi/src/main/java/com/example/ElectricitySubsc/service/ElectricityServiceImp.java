package com.example.ElectricitySubsc.service;

import com.example.springweb.domObj.AddressDO;
import com.example.springweb.domObj.ElectricityBill;
import com.example.springweb.domObj.ElectricitySubscDO;
import com.example.springweb.dto.AddressDTO;
import com.example.springweb.dto.ElectricityBillDTO;
import com.example.springweb.dto.ElectricitySubscDTO;
import com.example.springweb.repository.ElectricitySubscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ElectricityServiceImp implements ElectricityService {

    @Autowired
    private ElectricitySubscRepository electricityRepository;

    @Override
    public ElectricitySubscDO createElectricity(ElectricitySubscDO electricity) {
        return electricityRepository.save(electricity);
    }

    @Override
    public ElectricitySubscDTO updateElectricity(ElectricitySubscDO electricity) {

        long electricityId = electricity.getId();
        Optional<ElectricitySubscDO> currentElectricity = electricityRepository.findById(electricityId);
        if (currentElectricity.isPresent()) {
            currentElectricity.get().setName(electricity.getName());
            currentElectricity.get().setLastname(electricity.getLastname());
            currentElectricity.get().setDepartment(electricity.getDepartment());

            AddressDO electricityAddress = currentElectricity.get().getAddress();
            if (electricityAddress == null) {
                electricityAddress = new AddressDO();
            }

            /*==========================================*/


            ElectricityBill bill = currentElectricity.get().getBill();
            if (bill == null) {
                bill = new ElectricityBill();
            }



            /*==========================================*/

            electricityAddress.setCity(electricity.getAddress().getCity());
            electricityAddress.setRegion(electricity.getAddress().getRegion());
            electricityAddress.setPostCode(electricity.getAddress().getPostCode());
            currentElectricity.get().setAddress(electricityAddress);

            /*==========================================*/
            bill.setAmount(electricity.getBill().getAmount());
            bill.setCompany(electricity.getBill().getCompany());
            bill.setPeriod(electricity.getBill().getPeriod());
            bill.setPrice(electricity.getBill().getPrice());
            currentElectricity.get().setBill(bill);
            /*==========================================*/

            electricityRepository.save(currentElectricity.get()); // veritabanına kaydettik

            ElectricitySubscDTO electricityDTO = new ModelMapper().map(currentElectricity.get(), ElectricitySubscDTO.class);
            AddressDTO addressDTO = new ModelMapper().map(electricityAddress, AddressDTO.class);
            /*
            
            */
            ElectricityBillDTO billDTO = new ModelMapper().map(bill, ElectricityBillDTO.class);
            electricityDTO.setBillDTO(billDTO);
            //
            electricityDTO.setAddressDTO(addressDTO);
            return electricityDTO;
        }
        return null;

    }

    @Override
    public void deleteElectricity(Long electricityId) {
        Optional<ElectricitySubscDO> currentElectricity = electricityRepository.findById(electricityId);
        if (currentElectricity.isPresent()) {
            electricityRepository.deleteById(electricityId);  //veritabanında varsa sil
        }
    }

    @Override
    public ElectricitySubscDO getElectricity(Long electricityId) {
        Optional<ElectricitySubscDO> currentElectricity = electricityRepository.findById(electricityId);
        if (currentElectricity.isPresent()) {
            return currentElectricity.get();
        }
        return null;
    }
    @Override
    public ElectricitySubscDO getElectricity(String electricityName) {
        Optional<ElectricitySubscDO> currentElectricity = electricityRepository.findByName(electricityName);
        if (currentElectricity.isPresent()) {
            return currentElectricity.get();
        }
        return null;
    }

    @Override
    public List<ElectricitySubscDO> getAllElectricity() {
        return electricityRepository.findAll();
    }

}
