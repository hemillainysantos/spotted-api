package com.spotted.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spotted.models.Notification;
import com.spotted.services.NotificationService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(value = "*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/notification/{id}", method = RequestMethod.PUT)
    public Notification viewNotification(@PathVariable Long id) {
        return this.notificationService.viewNotification(id);
    }
	
	@RequestMapping(value = "/notification/{email}", method = RequestMethod.GET)
	public List<Notification> findByEmail(@PathVariable String email) {
		return this.notificationService.findByEmail(email);
	}
}
