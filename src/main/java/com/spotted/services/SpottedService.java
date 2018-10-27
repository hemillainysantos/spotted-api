package com.spotted.services;

import com.spotted.models.Comment;
import com.spotted.models.Spotted;
import com.spotted.repositories.SpottedRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpottedService {
	
	@Autowired
	SpottedRepository spottedRepository;
	
	@Autowired
	CommentService commentService;
	
	public Spotted save(Spotted spotted) {
		spotted.setDatetime(LocalDateTime.now());
		return this.spottedRepository.save(spotted);
	}
	
	public List<Spotted> getAll() {
		return this.spottedRepository.findAll();
	}
	
	public Optional<Spotted> get(Long id) {
		return this.spottedRepository.findById(id);
	}
	
	public Spotted addComment(Long spottedId, Comment comment) {
		this.commentService.save(comment);
		Spotted spotted = null;
		if (this.spottedRepository.existsById(spottedId)) {
			spotted = this.spottedRepository.getOne(spottedId);
			spotted.addComment(comment);
			this.spottedRepository.save(spotted);
		}
		return spotted;
	}
}
