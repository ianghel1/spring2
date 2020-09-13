package com.sda.spring.service.impl;

import com.sda.spring.dto.CompanyCreateDto;
import com.sda.spring.dto.CompanyInfoDto;
import com.sda.spring.model.Company;
import com.sda.spring.repository.CompanyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
class CompanyServiceImplTest {

    private static final String NAME = "Google";
    private static final String ADDRESS = "Bucuresti";
    private static final String EMAIL = "G@MAIL.COM";
    private static final String PHONE = "071234567";
    private static final Long REGISTRATION_NR = 123456789L;
    private static final Integer ID = 1;
    private static final LocalDateTime UPDATED_AT = LocalDateTime.now();
    private static final LocalDateTime CREATED_AT = LocalDateTime.now();
    private static final Long PERSONAL_NUMBER = 123456722L;


    private Company company;
    private CompanyCreateDto companyCreateDto;
    private CompanyInfoDto companyInfoDto;


    @InjectMocks
    private CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private ModelMapper modelMapper;


    @BeforeEach
    void setUp() {

        companyCreateDto = new CompanyCreateDto();
        companyCreateDto.setName(NAME);
        companyCreateDto.setAddress(ADDRESS);
        companyCreateDto.setEmail(EMAIL);
        companyCreateDto.setPhoneNumberCompany(PHONE);
        companyCreateDto.setRegistrationNumber(REGISTRATION_NR);

        company = new Company();
        company.setName(NAME);
        company.setAddress(ADDRESS);
        company.setEmail(EMAIL);
        company.setPhoneNumberCompany(PHONE);
        company.setRegistrationNumber(REGISTRATION_NR);

        companyInfoDto = new CompanyInfoDto();
        companyInfoDto.setName(NAME);
        companyInfoDto.setAddress(ADDRESS);
        companyInfoDto.setEmail(EMAIL);
        companyInfoDto.setPhoneNumberCompany(PHONE);
        companyInfoDto.setRegistrationNumber(REGISTRATION_NR);
        companyInfoDto.setId(ID);
        companyInfoDto.setUpdatedAt(UPDATED_AT);
        companyInfoDto.setCreatedAt(CREATED_AT);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {

        //facem mock repository-ului
        Mockito.when(companyRepository.save(company)).thenReturn(company);

        //facem mock pentru modelMapper
        Mockito.when(modelMapper.map(companyCreateDto, Company.class)).thenReturn(company);
        Mockito.when(modelMapper.map(company, CompanyInfoDto.class)).thenReturn(companyInfoDto);

        CompanyInfoDto result = companyService.create(companyCreateDto, "test");

        Mockito.verify(companyRepository, Mockito.times(1)).save(company);

        Assertions.assertEquals(result, companyInfoDto);
    }

    @Test
    void saveAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void findByPersonalNumericCode() {

        Mockito.when(companyRepository.findCompanyByPersonalNumericCode(PERSONAL_NUMBER)).thenReturn(java.util.Optional.ofNullable(company));
        Mockito.when(modelMapper.map(company, CompanyInfoDto.class)).thenReturn(companyInfoDto);

        CompanyInfoDto result = companyService.findByPersonalNumericCode(PERSONAL_NUMBER);
        Mockito.verify(companyRepository, Mockito.times(1)).findCompanyByPersonalNumericCode(PERSONAL_NUMBER);

        Assertions.assertEquals(result, companyInfoDto);
    }

    @Test
    void findByEmployeeId() {
    }

    @Test
    void getAll() {
    }
}