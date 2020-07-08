package com.Beaver.MainService.domain.service.license;

import com.Beaver.MainService.domain.license.*;
import com.Beaver.MainService.web.dto.LicenseGenerateRequestDto;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class LicenseServiceTest {

    @Autowired
    LicenseService licenseService;

    @Autowired
    LicenseRepository licenseRepository;

    private static Logger logger = LoggerFactory.getLogger(LicenseServiceTest.class);

    @After
    public void cleanup() {

    }

   // @Test
    public void License_Generate() {
        int generateNumber = 10;
        LicenseItem licenseItem = LicenseItem.TEST;
        LicenseProduct licenseProduct = LicenseProduct.BABY_SIGN;
        LicenseType licenseType = LicenseType.DIGITAL;
        int licensePeriod = 365;

        licenseService.generate(LicenseGenerateRequestDto.builder()
                .generateNumber(generateNumber)
                .item(licenseItem)
                .product(licenseProduct)
                .type(licenseType)
                .licensePeriod(licensePeriod).build());

        //DB에서 다시 꺼내기
        List<License> licenseList = licenseRepository.findAll();

        for(License license : licenseList) {
            logger.info("Id = " + license.getId()
                    + " Code = " + license.getCode()
                    + " Type = " + license.getType()
                    + " Product = " + license.getProduct()
                    + " Period = " + license.getLicensePeriod());
            assertThat(license.getType()).isEqualTo(LicenseType.DIGITAL);
        }

    }


}
