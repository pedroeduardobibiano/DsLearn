package com.improvement.dslearn.servicies;

import com.improvement.dslearn.dto.NotificationDTO;
import com.improvement.dslearn.entities.Notification;
import com.improvement.dslearn.entities.User;
import com.improvement.dslearn.repositories.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {


    private final NotificationRepository notificationRepository;
    private final AuthService authService;

    public NotificationService(NotificationRepository notificationRepository, AuthService authService) {
        this.notificationRepository = notificationRepository;
        this.authService = authService;
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationsForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> page = notificationRepository.findByUser(user, pageable);
        return page.map(NotificationDTO::new);
    }

}
