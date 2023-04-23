package com.project.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_password_history")
@NoArgsConstructor
@AllArgsConstructor
public class PasswordHistory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "pass_id")
	private Long PasswordId;
	

	@NotNull
	@Column(name = "old_pass")
	private String oldPassword;
	
	@Column(name = "last_modified_on")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDateTime lastModifiedOn;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id", nullable = false)
	private User userId;


	
}
