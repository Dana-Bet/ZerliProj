package Entities;

import java.io.Serializable;

public class Complaint implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	private String name,id,time,status,reason;
	
	public Complaint(String name, String id, String time,String status, String reason) {
		this.name = name;
		this.id = id;
		this.time = time;
		this.status = status;
		this.reason = reason;
	
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
