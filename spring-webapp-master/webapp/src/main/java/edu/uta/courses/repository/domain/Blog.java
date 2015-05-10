package edu.uta.courses.repository.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Blog database 
 * Author Joni Laurila
 * Spring 2015 for Course www-programming
 */

@Entity
@Table (name = "blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false, updatable=false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdOn;

    @Column(nullable=true, updatable=true)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime modifiedOn;

    @Column(nullable=false, updatable=true, length=512)
    private String post;
    
    @Column(nullable=false, updatable=true)
    private Date title;

    @Column(nullable=true, updatable=true)
	private String fileName;

    @ManyToOne(optional = false)
    User user;

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(DateTime createdOn) {
        this.createdOn = createdOn;
    }

    public DateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(DateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTitle() {
    	return new SimpleDateFormat("MM-dd-yyyy").format(title);
    }
    
	public void setTitle(Date title) {
		this.title = title;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String file) {
		this.fileName = file;
	}

}