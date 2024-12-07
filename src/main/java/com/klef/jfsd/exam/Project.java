package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "project_table")
public class Project
{
	@Id
	@Column(name = "pid")
    private int id;
    @Column(name = "pname",nullable = false,length = 50)
    private String name;
    @Column(name = "pduration",nullable = false,length = 50)
    private String duration;
    @Column(name = "pbudget",nullable = false)
    private double budget;
    @Column(name = "pteamlead",nullable = false,length = 50)
    private String teamlead;
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", duration=" + duration + ", budget=" + budget + ", teamlead="
				+ teamlead + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public String getTeamlead() {
		return teamlead;
	}
	public void setTeamlead(String teamlead) {
		this.teamlead = teamlead;
	}
}
