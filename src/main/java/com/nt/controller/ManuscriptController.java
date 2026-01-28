package com.nt.controller;
 
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.nt.entity.DTOManuscript;
import com.nt.entity.Manuscript;
import com.nt.entity.ManuscriptStatus;
import com.nt.service.ManuscriptService;
import com.nt.exception.BadRequestException;

import java.util.List;
import java.util.Map;

@RestController
public class ManuscriptController {

    private final ManuscriptService manuscriptService;

    public ManuscriptController(ManuscriptService manuscriptService) {
        this.manuscriptService = manuscriptService;
    }

    

    @PostMapping("/publishers/{publisherId}/manuscripts")
public Manuscript submitManuscript(
        @PathVariable Long publisherId,
        @Valid @RequestBody DTOManuscript dto) {

    return manuscriptService.submitManuscript(publisherId, dto);
}


    
    @GetMapping("/publishers/{publisherId}/manuscripts")
    public List<Manuscript> getManuscripts(@PathVariable Long publisherId) {
        return manuscriptService.getManuscriptsByPublisher(publisherId);
    }

   
    @PutMapping("/manuscripts/{manuscriptId}/status")
    public Manuscript updateStatus(@PathVariable Long manuscriptId,
                                   @RequestBody Map<String, String> request) {
        String statusStr = request.get("status");
        
        if (statusStr == null || statusStr.isBlank()) {
            throw new BadRequestException("Status cannot be blank");
        }
        
        ManuscriptStatus status;
         
        try {
            status = ManuscriptStatus.valueOf(statusStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid status: " + statusStr + 
                ". Allowed values: SUBMITTED, UNDER_REVIEW, ACCEPTED, REJECTED");
        }
        
        return manuscriptService.updateStatus(manuscriptId, status);
    }
}
