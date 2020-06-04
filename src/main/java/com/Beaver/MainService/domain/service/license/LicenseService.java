package com.Beaver.MainService.domain.service.license;

import com.Beaver.MainService.domain.license.License;
import com.Beaver.MainService.domain.license.LicenseRepository;
import com.Beaver.MainService.domain.license.LicenseType;
import com.Beaver.MainService.web.dto.LicenseGenerateRequestDto;
import com.Beaver.MainService.web.dto.LicenseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;

    @Transactional
    public Long save(LicenseSaveRequestDto requestDto) {
        return licenseRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public List<License> getAllData() {
        return licenseRepository.findAll();
    }

    public Long generate(LicenseGenerateRequestDto requestDto) {
        List<License> licenseList;

        licenseList = getAllData();

        HashSet<String> duplicateCheckSet = new HashSet<>();

        for(License license : licenseList) {
            duplicateCheckSet.add(license.getCode());
        }

        int couponSize = requestDto.getGenerateNumber();

        final char[] possibleCharacters = {'1','2','3','4','5','6','7','8','9','0',
                'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q',
                'R','S','T','U','V','W','X','Y','Z'};

        final int possibleCharacterCount = possibleCharacters.length;

        List<String> couponList = new ArrayList<>();
        List<License> generateLicenseList = new ArrayList<>();

        Random rnd = new Random();

        StringBuilder buf = new StringBuilder(20);
        for(int i = 0 ; i < couponSize ;)
        {
            buf.setLength(0);

            for(int j = 0 ; j < 20 ; j++)
            {
                buf.append(possibleCharacters[rnd.nextInt(possibleCharacterCount)]);
            }

            if(!duplicateCheckSet.contains(buf.toString())) {

                duplicateCheckSet.add(buf.toString());
                couponList.add(buf.toString());

                generateLicenseList.add(License.builder()
                        .code(buf.toString())
                        .type(requestDto.getType())
                        .product(requestDto.getProduct())
                        .licensePeriod(requestDto.getLicensePeriod())
                        .build());
                i++;
            }
        }

        for(License license : generateLicenseList) {
            licenseRepository.save(license);
        }

        return 0L;
    }



}
