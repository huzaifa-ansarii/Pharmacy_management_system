package com.project.entities;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.Table;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.NotNull;

	import org.hibernate.validator.constraints.Length;
	import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
	import com.fasterxml.jackson.annotation.JsonProperty.Access;


import lombok.AllArgsConstructor;
	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;
	import lombok.ToString;

	@Entity
	@Table(name = "t_users")
	@NoArgsConstructor
	@AllArgsConstructor
	

	public class User implements UserDetails {
		
	

		@Id
		
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private Long user_id;
		
		
		@NotNull(message = "full_name can't be blank")
		@Column(length = 50)
		private String full_name;
		
		@NotNull(message = "mobile_no can't be blank")
		@Column(length = 15)
		private String mobile_no;
		
		@NotNull(message = "email must be supplied")
		@Column(length = 30)
		private String email;
		
		@JsonProperty(access = Access.WRITE_ONLY)
		@NotNull(message = "password must be supplied")
		@Length(min=8,max=20,message = "Invalid Password!!!!!!")
		private String password;
		
		
		
		
		

		@Override
		public String toString() {
			return "User [user_id=" + user_id + ", full_name=" + full_name + ", mobile_no=" + mobile_no + ", email="
					+ email + ", password=" + password + ", address=" + address + ", gst_no=" + gst_no + ", licence_id="
					+ licence_id + ", role=" + role + ", city_id=" + city_id + "]";
		}

		@NotNull
		@Column(length = 70)
		private String address;
		
		@Column(length = 100)
		private String gst_no;
		
		@Column(length = 30)
		private String licence_id;

		@Enumerated(EnumType.STRING)
		@Column(length = 20)
		@NotNull(message = "role must be suppled")
		private Role role;
		
		@ManyToOne(cascade=CascadeType.REMOVE)
		@JoinColumn(name="city_id", nullable = false)
		private City city_id;

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}

		public String getFull_name() {
			return full_name;
		}

		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}

		public String getMobile_no() {
			return mobile_no;
		}

		public void setMobile_no(String mobile_no) {
			this.mobile_no = mobile_no;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getGst_no() {
			return gst_no;
		}

		public void setGst_no(String gst_no) {
			this.gst_no = gst_no;
		}

		public String getLicence_id() {
			return licence_id;
		}

		public void setLicence_id(String licence_id) {
			this.licence_id = licence_id;
		}

		public Role getRole() {
			return role;
		}

		public City getCity_id() {
			return city_id;
		}

		public void setCity_id(City city_id) {
			this.city_id = city_id;
		}

		public void setRole(Role role) {
			this.role = role;
		}

	
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.getRole()));

			return grantedAuthorities;
			
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return false;
		}

	
		
		
		

	}


