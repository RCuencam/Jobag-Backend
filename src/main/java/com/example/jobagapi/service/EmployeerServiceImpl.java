package com.example.jobagapi.service;
import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.service.EmployeerService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeerServiceImpl implements EmployeerService {
    @Autowired
    private EmployeerRepository employeerRepository;


    @Override
    public Page<Employeer> getAllEmployeers(Pageable pageable) {
        return employeerRepository.findAll(pageable);
    }

    @Override
    public Employeer getEmployeerById(Long employeerId) {
        return employeerRepository.findById(employeerId)
                .orElseThrow(()->new ResourceNotFoundException("Employeer","Id",employeerId));
    }

    @Override
    public Employeer createEmployeer(Employeer employeer) {
        return employeerRepository.save(employeer);
    }

    

    @Override
    public ResponseEntity<?> deleteEmployeer(Long employeerId) {
        Employeer employeer=employeerRepository.findById(employeerId)
                .orElseThrow(() -> new ResourceNotFoundException("Employeer", "Id", employeerId));
        employeerRepository.delete(employeer);
        return ResponseEntity.ok().build();
    }


}
