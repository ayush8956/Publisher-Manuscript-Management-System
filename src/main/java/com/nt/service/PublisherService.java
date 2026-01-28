package com.nt.service;

  
import org.springframework.stereotype.Service;
import java.util.List;
import com.nt.entity.Publisher;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.PublisherRepository;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher createPublisher(Publisher publisher) {
        if (publisherRepository.existsByEmail(publisher.getEmail())) {
            throw new RuntimeException("Publisher email already exists");
        }
        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Publisher not found"));
    }
}

