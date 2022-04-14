package com.ems.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	@GeneratedValue
	private int deparId;

	private String departName;
	

	
	public Department() {}
	public Department(int deparId,String departName) {
		super();
		this.deparId = deparId;
		this.departName = departName;
	}
	
	public Department(String departName) {
		super();
//		this.deparId = deparId;
		this.departName = departName;
	}
	public int getDeparId() {
		return deparId;
	}
	public void setDeparId(int deparId) {
		this.deparId = deparId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	
	@Override
	public String toString() {
		return "Department [deparId=" + deparId + ", departName=" + departName + "]";
	}
	
	

}
