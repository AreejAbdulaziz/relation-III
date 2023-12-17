package com.example.jparelationi.Controller;

import com.example.jparelationi.DTO.AddressDTO;
import com.example.jparelationi.Service.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body("address added to teacher");
    }
    @PutMapping("/update/{addressId}")
    public ResponseEntity updateAddress(@PathVariable Integer addressId,@RequestBody@Valid AddressDTO addressDTO){
        addressService.updateAddress( addressId,addressDTO);
        return ResponseEntity.status(200).body("address updated!");
    }
    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("address deleted!");
    }
}
