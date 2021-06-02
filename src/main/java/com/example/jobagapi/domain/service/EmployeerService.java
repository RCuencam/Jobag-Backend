

package com.example.jobagapi.domain.service;

import com.example.jobagapi.domain.model.Employeer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface EmployeerService {

    Page<Employeer> getAllEmployeers(Pageable pageable);
    Employeer getEmployeerById(Long employeerId);
    Employeer createEmployeer(Employeer employeer );
    ResponseEntity<?> deleteEmployeer(Long employeerId);
}
