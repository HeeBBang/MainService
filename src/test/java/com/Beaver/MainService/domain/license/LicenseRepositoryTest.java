package com.Beaver.MainService.domain.license;


import org.junit.After;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LicenseRepositoryTest {

    @Autowired
    LicenseRepository licenseRepository;


    @After
    public void cleanup() {
        licenseRepository.deleteAll();
    }

    @Test
    public void License_Save_Load() {





    }



}
