package com.example.jparelationi.Service;

import com.example.jparelationi.Api.ApiException;
import com.example.jparelationi.DTO.AddressDTO;
import com.example.jparelationi.Model.Address;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.AddressRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
    //عشان نضبط الكونستركتر
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_Id());
        if(teacher==null){
            throw new ApiException("teacher not found you cant creat address");
        }
        Address address=new Address(null, addressDTO.getArea(), addressDTO.getStreet(),addressDTO.getBuilding_number(),teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer addressId,AddressDTO addressDTO){
        Address oldAddress=addressRepository.findAddressById(addressId);
        if (oldAddress==null){
            throw new ApiException("address not found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuilding_number(oldAddress.getBuilding_number());
        addressRepository.save(oldAddress);
    }
    public void deleteAddress(Integer id){
        Address address=addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("address not found");
        }
        Teacher teacher=teacherRepository.findTeacherById(id);
        teacher.setAddress(null);
        addressRepository.delete(address);
    }

}
