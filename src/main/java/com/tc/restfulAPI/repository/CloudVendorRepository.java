package com.tc.restfulAPI.repository;

import com.tc.restfulAPI.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
    /*this line is added for junit for testing  purpose*/
     List<CloudVendor> findByVendorName(String vendorName);
}
