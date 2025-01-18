package com.tc.restfulAPI.service.impl;


import com.tc.restfulAPI.model.CloudVendor;
import com.tc.restfulAPI.repository.CloudVendorRepository;
import com.tc.restfulAPI.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CloudVendorImplTest {


    @Mock
    private CloudVendorRepository cloudVendorRepository;
    private CloudVendorService cloudVendorService;
    AutoCloseable autoCloseable;
    CloudVendor cloudVendor;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        //cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
        cloudVendor = new CloudVendor("1","Azamon","usa","55655");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreateCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        //when(cloudVendorRepository.save(cloudVendorRepository)).thenReturn(cloudVendor);
    }

    @Test
    void updateCloudVendor() {
    }

    @Test
    void deleteCloudVendor() {
    }

    @Test
    void getCloudVendor() {
    }

    @Test
    void getAllCloudVendor() {
    }
}