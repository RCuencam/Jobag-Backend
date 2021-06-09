package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.Company;
import com.example.jobagapi.domain.repository.CompanyRepository;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.repository.SectorRepository;
import com.example.jobagapi.domain.service.CompanyService;
import com.example.jobagapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private EmployeerRepository employeerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
     private SectorRepository sectorRepository;


    @Override
    public Page<Company> getAllCompanysByEmployeerId(Long employeerId, Pageable pageable) {
        if(!companyRepository.existsByEmployeerId(employeerId))
            throw new ResourceNotFoundException("EmployeerId", "Id", employeerId);
        return companyRepository.findByEmployeerId(employeerId,pageable);
    }

    @Override
    public Company getCompanyByIdAndEmployeerId(Long employeerId, Long companyId) {
        return companyRepository.findByIdAndEmployeerId(employeerId,companyId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Company not found with Id " + companyId+
                                "and EmployeerId " + employeerId));

    }

    @Override
    public Page<Company> getAllCompanysBySectorId(Long sectorId, Pageable pageable) {
        return null;
    }

    @Override
    public Company getCompanyByIdAndSectorId(Long sectorId, Long companysId) {
        return null;
    }

    @Override
    public Company createCompany(Long employeerId,Long sectorId, Company company) {

        if(!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);
            //Comprobamos que exista el employeer
        else if (!sectorRepository.existsById(sectorId))
            throw new ResourceNotFoundException("Sector","Id",sectorId);

        return employeerRepository.findById(employeerId).map(employeer -> {
            company.setEmployeer(employeer);
            sectorRepository.findById(sectorId).map(sector -> {
                company.setSector(sector);
                return  companyRepository.save(company);
            }).orElseThrow(() -> new ResourceNotFoundException("Sector", "Id", sectorId));
            return  companyRepository.save(company);
        }).orElseThrow(() -> new ResourceNotFoundException("Employeer", "Id", employeerId));

    }



    /*
    //Comprobamos que exista el postulante
        if(!postulantRepository.existsById(postulantId))
            throw new ResourceNotFoundException("Postulant","Id",postulantId);
        //Comprobamos que exista el employeer
        else if (!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return postulantRepository.findById(postulantId).map(postulant -> {
            mailMessage.setPostulant(postulant);
            employeerRepository.findById(employeerId).map(employeer -> {
                mailMessage.setEmployeer(employeer);
                return  mailMessageRepository.save(mailMessage);
            }).orElseThrow(() -> new ResourceNotFoundException("Employeer", "Id", employeerId));
            return  mailMessageRepository.save(mailMessage);
        }).orElseThrow(() -> new ResourceNotFoundException("Postulant", "Id", postulantId));




    */




    @Override
    public Company updateCompany(Long employeerId, Long companyId, Company companyDetails) {
        if(!employeerRepository.existsById(employeerId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return companyRepository.findById(companyId).map(company -> {

            company.setName(companyDetails.getName())
                   ;

            return companyRepository.save(company);

        }).orElseThrow(() -> new ResourceNotFoundException(
                "Company","Id",companyId));
    }

    @Override
    public ResponseEntity<?> deleteCompany(Long employeerId, Long companyId) {
        if (!companyRepository.existsById(companyId))
            throw new ResourceNotFoundException("Employeer","Id",employeerId);

        return companyRepository.findById(companyId).map(company -> {
            companyRepository.delete(company);
            return ResponseEntity.ok().build();


        }).orElseThrow(()-> new ResourceNotFoundException(
                "Company", "Id",companyId));

    }
}
