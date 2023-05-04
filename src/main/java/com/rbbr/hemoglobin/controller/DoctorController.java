package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.DoctorCreateDTO;
import com.rbbr.hemoglobin.dto.DoctorDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.service.DoctorService;
import com.rbbr.hemoglobin.service.DoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<Page<DoctorDTO>> getDoctors(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "") String search)
    {
        System.out.println("Trying to send doctors to frontend...");
        Page<DoctorDTO> doctors = doctorService.findAll(search, page);
        return ResponseEntity.ok(doctors);
    }



    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctor(@PathVariable Long id, HttpSession session) {
        System.out.println("Trying to send doctor with id: " + id + " to frontend...");
        DoctorDTO doctor = doctorService.findById(id);
        if(doctor == null)
            return ResponseEntity.notFound().build();
        System.out.println("Doctor with id: " + id + " sent to frontend.");
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DoctorDTO> editDoctor(@RequestBody DoctorDTO doctor, HttpSession session) {
        System.out.println("Trying to edit doctor with id: " + doctor.getId() + "...");
        DoctorDTO d = doctorService.update(doctor);
        return ResponseEntity.ok(d);
    }

    /*
    @PostMapping(value = {"/register"})
    public ResponseEntity<DoctorDTO> register(@RequestBody DoctorCreateDTO doctorCreateDTO) {
        DoctorDTO doctorDTO = doctorService.register(doctorCreateDTO);
        //TODO email and phone number check in register method
        return ResponseEntity.ok(doctorDTO);
    }*/


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteDoctor(HttpSession session, @PathVariable Long id) {
        String userType = (String) session.getAttribute("userType");
        //if (userType == null || !userType.equals("admin"))
        //return "redirect:/admin/";
        doctorService.delete(id);
        return ResponseEntity.ok().build();
        //return "redirect:/admin/dashboard";
    }
}
