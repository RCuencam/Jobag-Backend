package com.example.jobagapi;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.model.Sector;
import com.example.jobagapi.domain.model.User;
import com.example.jobagapi.domain.repository.CompanyRepository;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.SectorRepository;
import com.example.jobagapi.domain.service.CompanyService;
import com.example.jobagapi.domain.service.EmployeerService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import com.example.jobagapi.service.CompanyServiceImpl;
import com.example.jobagapi.service.EmployeerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.constraints.NotNull;
import java.util.EnumMap;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CompanyServiceImplTest {

    @MockBean
    private CompanyRepository companyRepository;

    @MockBean
    private EmployeerRepository employeerRepository;

    @MockBean
    private SectorRepository sectorRepository;


    @Autowired
    private CompanyService companyService;

    @TestConfiguration
    static class CompanyServiceImplTestConfiguration {
        @Bean
        public CompanyService CompanyService() {
            return new CompanyServiceImpl();
        }
    }

    @Test
    @DisplayName("When get companys by Id and employeerId With Valid employeerId Then Returns Company")
    public void WhengetcompanysbyIdAndEmployeerIdWithValidemployeerIdThenReturnsCompany() {
        // Arrange
        Long employeerId = 1L;

        User user = new User().setId(employeerId);
        Employeer employeer = new Employeer(employeerId, "firstname", "lastname", "email", 98212L, "password", "document", " posicion");
        Sector sector = new Sector();
        Company company = new Company(1L, "name", "description", "logo", 123L, "dirección", employeer, sector);

        when(companyRepository.findByIdAndEmployeerId(company.getId(), employeer.getId()))
                .thenReturn(Optional.of(company));
        // Act
        Company foundCompany = companyService.getCompanyByIdAndEmployeerId(employeerId, company.getId());

        // Assert
        assertThat(foundCompany.getId()).isEqualTo(company.getId());

    }

    @Test
    @DisplayName("When get companys by Id and employeerId With Invalid employeerId Then ResourceNotFoundException")
    public void WhengetcompanysbyIdAndEmployeerIdWithInvalidemployeerIdThenResourceNotFoundException() {
        // Arrange
        Long employeerId = 1L;

        User user = new User().setId(employeerId);
        Employeer employeer = new Employeer(employeerId, "firstname", "lastname", "email", 98212L, "password", "document", " posicion");
        Sector sector = new Sector();
        Company company = new Company(1L, "name", "description", "logo", 123L, "dirección", employeer, sector);

        when(companyRepository.findByIdAndEmployeerId(company.getId(), employeer.getId()))
                .thenReturn(Optional.empty());



        String expectedMessage = String.format("Company not found with Id " + company.getId()+
                        "and EmployeerId " + employeerId);

        // Act
        Throwable exception = catchThrowable(() -> {

        Company foundCompany = companyService.getCompanyByIdAndEmployeerId(employeerId, company.getId());
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }



    @Test
    @DisplayName("When get all companys by employeerId With Valid employeerId Then Returns Company")
    public void WhengetallcompanysbyemployeerIdWithValidemployeerIdThenReturnsResourceNotFoundException() {
        // Arrange
        Long employeerId = 1L;

        User user = new User().setId(employeerId);
        Employeer employeer = new Employeer(employeerId, "firstname", "lastname", "email", 98212L, "password", "document", " posicion");
        Sector sector = new Sector();
        Company company = new Company(1L, "name", "description", "logo", 123L, "dirección", employeer, sector);

        Page<Company> companyPage = Page.empty();
        when(companyRepository.findByEmployeerId(employeer.getId(),Pageable.unpaged()))
                .thenReturn(companyPage);

        String template = "Resource %s not found for %s with value %s";
        String expectedMessage = String.format(template,"EmployeerId", "Id", employeerId);

        // Act
        Throwable exception = catchThrowable(() -> {
            Page<Company> foundCompany = companyService.getAllCompanysByEmployeerId(employeer.getId(),Pageable.unpaged());
        });

        // Assert
        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);

    }


    @Test
    @DisplayName("When create all companys by employeerId With Valid employeerId Then Returns Company")
    public void WhencreatecompanysbyemployeerIdWithValidemployeerIdThenReturnsResourceNotFoundException() {
        // Arrange
        Long employeerId = 1L;


        Employeer employeer = new Employeer(employeerId, "firstname", "lastname", "email", 98212L, "password", "document", " posicion");
        Sector sector = new Sector().setId(1L);
        Company company = new Company(1L, "name", "description", "logo", 123L, "dirección", employeer, sector);

        Company companynew= new Company();






    }

}


