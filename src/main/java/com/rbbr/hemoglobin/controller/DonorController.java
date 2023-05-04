package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.service.DonorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/donor")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @GetMapping("/{id}")
    public ResponseEntity<DonorDTO> getDonor(@PathVariable Long id, HttpSession session) {
        System.out.println("Trying to send donor with id: " + id + " to frontend...");
        //String userType = (String) session.getAttribute("userType");
        //if (userType == null || !userType.equals("admin"))
            //return ResponseEntity.badRequest().build();

        DonorDTO donor = donorService.findById(id);
        if(donor == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(donor);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DonorDTO> editDonor(@RequestBody DonorDTO donor, HttpSession session) {
        System.out.println("Trying to edit donor with id: " + donor.getId() + "...");
        //String userType = (String) session.getAttribute("userType");
        //if (userType == null || !userType.equals("admin"))
        //return ResponseEntity.badRequest().build();

        donorService.update(donor);
        return ResponseEntity.ok(donor);
    }

    @PostMapping(value = {"/register"})
    public ResponseEntity<DonorDTO> register(@RequestBody DonorCreateDTO donorCreateDTO) {
        System.out.println("Trying to register user with username: " + donorCreateDTO.getUsername() + " and password: " + donorCreateDTO.getPassword() + "...");
        DonorDTO donorDTO = donorService.register(donorCreateDTO);
        //TODO email and phone number check in register method
        return ResponseEntity.ok(donorDTO);
    }

    /*
    @PostMapping(value = {"/login", ""})
    public ResponseEntity<DonorDTO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        System.out.println("Trying to log in user with username: " + userLoginDTO.getUsername() + " and password: " + userLoginDTO.getPassword() + "...");
        DonorDTO donorDTO = donorService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword(), request);
        if (donorDTO != null)
            return ResponseEntity.ok(donorDTO);
        return ResponseEntity.badRequest().build();
    }
    */

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteDonor(HttpSession session, @PathVariable Long id) {
        String userType = (String) session.getAttribute("userType");
        //if (userType == null || !userType.equals("admin"))
            //return "redirect:/admin/";
        donorService.delete(id);
        return ResponseEntity.ok().build();
        //return "redirect:/admin/dashboard";
    }

}
