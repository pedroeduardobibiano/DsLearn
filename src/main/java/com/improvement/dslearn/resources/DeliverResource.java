package com.improvement.dslearn.resources;

import com.improvement.dslearn.dto.DeliverRevisionDTO;
import com.improvement.dslearn.servicies.DeliverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

    private final DeliverService deliverService;

    public DeliverResource(DeliverService deliverService) {
        this.deliverService = deliverService;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto) {
        deliverService.saveRevision(id, dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
