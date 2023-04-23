package com.project.dto;

public class OtpDto {

	private int otp;
	private String status;
	
	public OtpDto(int otp, String status) {
		super();
		this.otp = otp;
		this.status = status;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OtpDto [otp=" + otp + ", status=" + status + "]";
	}
	
}
