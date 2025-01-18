package com.tc.restfulAPI.controller;


import com.tc.restfulAPI.customresponse.ResponseHandler;
import com.tc.restfulAPI.model.CloudVendor;
import com.tc.restfulAPI.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    //read specific cloud vendor details
    //this getCloudVenderDetails is custom-made response
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuiler("requested vender details given here", HttpStatus.OK,
                cloudVendorService.getCloudVendor(vendorId));
    }

    /*this getcloudvenderdetails  is a normal method which return genric response*/
    /*@GetMapping("{vendorId}")
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
         return cloudVendorService.getCloudVendor(vendorId));
    }*/


    //read all cloud vendors details from database
    @GetMapping() //no need to have specific vendorId buz we want all details not a specific details
    public List<CloudVendor> getAllCloudVendorDetails(){
       return cloudVendorService.getAllCloudVendor();
    }

    //to create cloud vendors entity into the database
    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "cloudVendor details created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "cloud vendor details updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor details deleted successfully";
    }

}
