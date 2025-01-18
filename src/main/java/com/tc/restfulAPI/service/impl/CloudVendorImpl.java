package com.tc.restfulAPI.service.impl;

import com.tc.restfulAPI.exception.CloudVendorCreationException;
import com.tc.restfulAPI.exception.CloudVendorNotFoundException;
import com.tc.restfulAPI.model.CloudVendor;
import com.tc.restfulAPI.repository.CloudVendorRepository;
import com.tc.restfulAPI.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


//    @Override
//    public String createCloudVendor(CloudVendor cloudVendor) {
//        cloudVendorRepository.save(cloudVendor);
//        return "SUCCESS";
//    }
@Override
public String createCloudVendor(CloudVendor cloudVendor) {
    try {
        // Simulating a condition where creation could fail
        if (cloudVendor == null || cloudVendor.getVendorName() == null) {
            throw new CloudVendorCreationException("Cloud Vendor creation failed: Invalid data.");
        }

        // Attempt to save the cloud vendor
        cloudVendorRepository.save(cloudVendor);
        return "SUCCESS";
    } catch (Exception e) {
        // Wrap the exception and throw a more meaningful custom exception
        throw new CloudVendorCreationException("Cloud Vendor creation failed due to an internal error.", e);
    }
}


    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success to update";
    }

//    @Override
//    public String deleteCloudVendor(String cloudVendorId) {
//        cloudVendorRepository.deleteById(cloudVendorId);
//        return "cloud vendor id deleted successfully";
//    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        // Check if the Cloud Vendor exists in the repository
        if (!cloudVendorRepository.existsById(cloudVendorId)) {
            throw new CloudVendorNotFoundException(
                    "Cloud Vendor with ID " + cloudVendorId + " does not exist or has already been deleted."
            );
        }
        // Proceed to delete if it exists
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Cloud Vendor with ID " + cloudVendorId + " deleted successfully.";
    }


    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("requested cloud vendor does not exist");
        return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
