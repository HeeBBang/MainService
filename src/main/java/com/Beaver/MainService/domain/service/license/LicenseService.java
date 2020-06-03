package com.Beaver.MainService.domain.service.license;

import com.Beaver.MainService.domain.license.LicenseRepository;
import com.Beaver.MainService.web.dto.LicenseSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LicenseService {
    private LicenseRepository licenseRepository;

    @Transactional
    public Long save(LicenseSaveRequestDto requestDto) {
        return licenseRepository.save(requestDto.toEntity()).getId();
    }
}
