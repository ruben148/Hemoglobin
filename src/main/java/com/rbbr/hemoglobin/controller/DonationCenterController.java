package com.rbbr.hemoglobin.controller;

import com.rbbr.hemoglobin.dto.DonationCenterDTO;
import com.rbbr.hemoglobin.dto.DonorCreateDTO;
import com.rbbr.hemoglobin.dto.DonorDTO;
import com.rbbr.hemoglobin.dto.UserLoginDTO;
import com.rbbr.hemoglobin.entity.DonationCenter;
import com.rbbr.hemoglobin.service.DonationCenterService;
import com.rbbr.hemoglobin.service.DonorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/donation-centers")
public class DonationCenterController {
    @Autowired
    private DonorService donorService;

    @Autowired
    DonationCenterService donationCenterService;

    @GetMapping("/{id}")
    public ResponseEntity<DonationCenterDTO> getDonationCenter(@PathVariable Long id, HttpSession session) {
        System.out.println("Trying to send donation center with id: " + id + " to frontend...");
        DonationCenterDTO donationCenterDTO = donationCenterService.findById(id);
        if(donationCenterDTO == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(donationCenterDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<DonationCenterDTO>> getAllDonationCenters(HttpSession session,
                                                                          @RequestParam(defaultValue = "0") Integer page,
                                                                          @RequestParam(defaultValue = "10") Integer size) {
        System.out.println("Trying to send page " + page + " of donation centers to frontend...");
        return new ResponseEntity<>(donationCenterService.getAllDonationCenters(page, size), HttpStatus.OK);
    }

    @GetMapping("/{donationCenterId}/availability")
    public ResponseEntity<boolean[]> getAvailability(@PathVariable Long donationCenterId) {
        System.out.println("Trying to send availability of donation center with id: " + donationCenterId + " to frontend...");
        boolean[] availability = donationCenterService.getAvailability(donationCenterId);
        return ResponseEntity.ok(availability);
    }


}
