package com.improvement.dslearn.resources;

import com.improvement.dslearn.dto.NotificationDTO;
import com.improvement.dslearn.servicies.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    private final NotificationService notificationService;

    public NotificationResource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationsForCurrentUser(Pageable pageable) {
        Page<NotificationDTO> page = notificationService.notificationsForCurrentUser(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }


}
