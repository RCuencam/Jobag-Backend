package com.example.jobagapi.service;

import com.example.jobagapi.domain.model.PostulantJob;
import com.example.jobagapi.domain.repository.JobOfferRepository;
import com.example.jobagapi.domain.repository.PostulantJobRepository;
import com.example.jobagapi.domain.repository.PostulantRepository;
import com.example.jobagapi.domain.service.PostulantJobService;
import com.example.jobagapi.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostulantJobServiceImpl implements PostulantJobService {
    @Autowired
    private PostulantJobRepository postulantJobRepository;
    @Autowired
    private JobOfferRepository jobOfferRepository;
    @Autowired
    private PostulantRepository postulantRepository;
    //Creacion

    public PostulantJob createPostulantJob(Long jobOfferId, Long postulantId, PostulantJob postulantJob){
        return postulantJobRepository.findByPostulantIdAndJobOfferId(jobOfferId,postulantId).map(postulantjob-> {
            postulantJob.setPostulant(postulantjob.getPostulant()).setJobOffer(postulantjob.getJobOffer());
            return postulantJobRepository.save(postulantJob);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Postulant", "Id", postulantId));
    }
}
