package com.nt.service;
 
import org.springframework.stereotype.Service;

import com.nt.entity.DTOManuscript;
import com.nt.entity.Manuscript;
import com.nt.entity.ManuscriptStatus;
import com.nt.entity.Publisher;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.ManuscriptRepository;
import com.nt.repository.PublisherRepository;

import java.util.List;

@Service
public class ManuscriptService {

    private final ManuscriptRepository manuscriptRepository;
    private final PublisherRepository publisherRepository;

    public ManuscriptService(ManuscriptRepository manuscriptRepository,
                             PublisherRepository publisherRepository) {
        this.manuscriptRepository = manuscriptRepository;
        this.publisherRepository = publisherRepository;
    }

    public Manuscript submitManuscript(Long publisherId, DTOManuscript dto) {

    Publisher publisher = publisherRepository.findById(publisherId)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Publisher not found"));

    Manuscript manuscript = new Manuscript();
    manuscript.setTitle(dto.getTitle());
    manuscript.setJournalName(dto.getJournalName());
    manuscript.setAuthorName(dto.getAuthorName());
    manuscript.setSubmissionDate(dto.getSubmissionDate());
    manuscript.setStatus(ManuscriptStatus.SUBMITTED);
    manuscript.setPublisher(publisher);

    return manuscriptRepository.save(manuscript);
}


    public List<Manuscript> getManuscriptsByPublisher(Long publisherId) {
        return manuscriptRepository.findByPublisherId(publisherId);
    }

    public Manuscript updateStatus(Long manuscriptId, ManuscriptStatus status) {
        Manuscript manuscript = manuscriptRepository.findById(manuscriptId)
                .orElseThrow(() -> new ResourceNotFoundException("Manuscript not found"));

        manuscript.setStatus(status);
        return manuscriptRepository.save(manuscript);
    }
}

