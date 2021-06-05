package com.example.jobagapi;
import com.example.jobagapi.domain.model.Employeer;
import com.example.jobagapi.domain.repository.EmployeerRepository;
import com.example.jobagapi.domain.service.EmployeerService;
import com.example.jobagapi.service.EmployeerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EmployeerServiceImplTest {
}