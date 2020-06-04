package com.Beaver.MainService.domain.license;


import org.junit.After;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
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
        String code = "abcdefghijkml";
        LicenseType type = LicenseType.TEST;
        LicenseProduct product = LicenseProduct.BABY_SIGN;
        int licensePriode = 365;

        licenseRepository.save(License.builder()
                .code(code)
                .type(type)
                .product(product)
                .licensePriode(licensePriode)
                .build());

        //when
        List<License> licenseList = licenseRepository.findAll();

        License license = licenseList.get(0);
        assertThat(license.getCode()).isEqualTo(code);
        assertThat(license.getType()).isEqualTo(type);
        assertThat(license.getProduct()).isEqualTo(product);
        assertThat(license.getLicensePriode()).isEqualTo(licensePriode);
    }



}
