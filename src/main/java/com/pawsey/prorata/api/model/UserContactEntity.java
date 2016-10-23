/*
 * Created on 5 Mar 2016 ( Time 20:49:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.pawsey.prorata.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

/**
 * Persistent class for entity stored in table "user_contact"
 *
 * @author Telosys Tools Generator
 * @deprecated pending review of requirement
 */
@Deprecated
@Entity
@Table(name="user_contact", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UserContactEntity.countAll", query="SELECT COUNT(x) FROM UserContactEntity x" )
} )
@JsonIgnoreProperties(ignoreUnknown = true) 
public class UserContactEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="user_contact_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_contact_user_contact_id_pk_seq")
    @SequenceGenerator(name = "user_contact_user_contact_id_pk_seq", sequenceName = "user_contact_user_contact_id_pk_seq")
    protected Integer    userContactId ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS
    //----------------------------------------------------------------------
    @Column(name="contact_name", length=100)
    protected String     contactName  ;

    @Column(name="contact_type", length=100)
    protected String     contactType  ;

    @Column(name="contact_body", length=100)
    protected String     contactBody  ;

	// "prorataUserId" (column "prorata_user_id") is not defined by itself because used as FK in a link


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @JsonBackReference("ProrataUserEntity_UserContactEntity")
    @ManyToOne
    @JoinColumn(name="prorata_user_id", referencedColumnName="prorata_user_id", insertable=false, updatable=false)
    protected ProrataUserEntity prorataUser ;

    @JsonManagedReference("UserContactEntity_UserContactEntity")
    @OneToMany(mappedBy="userContact", targetEntity= UserContactEntity.class)
    protected List<UserContactEntity> listOfUserContact;

    @JsonBackReference("UserContactEntity_UserContactEntity")
    @ManyToOne
    @JoinColumn(name="prorata_user_id", referencedColumnName="user_contact_id")
    protected UserContactEntity userContact ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UserContactEntity() {
		super();
    }

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUserContactId( Integer userContactId ) {
        this.userContactId = userContactId ;
    }
    public Integer getUserContactId() {
        return this.userContactId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : contact_name ( varchar )
    public void setContactName( String contactName ) {
        this.contactName = contactName;
    }
    public String getContactName() {
        return this.contactName;
    }

    //--- DATABASE MAPPING : contact_type ( varchar )
    public void setContactType( String contactType ) {
        this.contactType = contactType;
    }
    public String getContactType() {
        return this.contactType;
    }

    //--- DATABASE MAPPING : contact_body ( varchar )
    public void setContactBody( String contactBody ) {
        this.contactBody = contactBody;
    }
    public String getContactBody() {
        return this.contactBody;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setProrataUser( ProrataUserEntity prorataUser ) {
        this.prorataUser = prorataUser;
    }
    public ProrataUserEntity getProrataUser() {
        return this.prorataUser;
    }

    public void setListOfUserContact( List<UserContactEntity> listOfUserContact ) {
        this.listOfUserContact = listOfUserContact;
    }
    public List<UserContactEntity> getListOfUserContact() {
        return this.listOfUserContact;
    }

    public void setUserContact( UserContactEntity userContact ) {
        this.userContact = userContact;
    }
    public UserContactEntity getUserContact() {
        return this.userContact;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(userContactId);
        sb.append("]:");
        sb.append(contactName);
        sb.append("|");
        sb.append(contactType);
        sb.append("|");
        sb.append(contactBody);
        return sb.toString();
    } 

}
