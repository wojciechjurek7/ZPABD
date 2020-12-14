package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authID;
	
	@Override
	public String toString() {
		return "Author [authID=" + authID + ", authorName=" + authorName + "]";
	}
	public Long getAuthID() {
		return authID;
	}
	public void setAuthID(Long authID) {
		this.authID = authID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	private String authorName;
}
