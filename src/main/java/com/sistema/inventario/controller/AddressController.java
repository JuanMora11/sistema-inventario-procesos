package com.sistema.inventario.controller;

import com.sistema.inventario.model.Address;
import com.sistema.inventario.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("address/{idUser}")
    public ResponseEntity<Address> create(@Valid @RequestBody Address address, @PathVariable Long idUser){
        return new ResponseEntity<>(addressService.createAddress(address, idUser), HttpStatus.CREATED);
    }
    @PutMapping("address/{id}")
    public ResponseEntity disabled(@PathVariable Long id){
        return ResponseEntity.ok(addressService.disableAddress(id));
    }
    @GetMapping("address/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddressById(id));
    }
    @GetMapping("address")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }
}