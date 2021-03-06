/*
 * Created on 5 Mar 2016 ( Time 20:49:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.pawsey.prorata.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Persistent class for entity stored in table "bank"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="bank", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="BankEntity.countAll", query="SELECT COUNT(x) FROM BankEntity x" )
} )
@JsonIgnoreProperties(ignoreUnknown = true) 
public class BankEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="bank_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_bank_id_pk_seq")
    @SequenceGenerator(name = "bank_bank_id_pk_seq", sequenceName = "bank_bank_id_pk_seq")
    protected Integer    bankId       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="name", length=10)
    protected String     name         ;

    @Column(name="address", length=10)
    protected String     address      ;

    @Column(name="postcode", length=10)
    protected String     postcode     ;

    @Column(name="telphone", length=10)
    protected String     telphone     ;

    @Column(name="email", length=10)
    protected String     email        ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @JsonManagedReference("BankEntity_AccountEntity")
    @OneToMany(mappedBy="bank", targetEntity=AccountEntity.class)
    protected List<AccountEntity> listOfAccount;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public BankEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setBankId( Integer bankId ) {
        this.bankId = bankId ;
    }
    public Integer getBankId() {
        return this.bankId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : name ( varchar ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : address ( varchar ) 
    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    //--- DATABASE MAPPING : postcode ( varchar ) 
    public void setPostcode( String postcode ) {
        this.postcode = postcode;
    }
    public String getPostcode() {
        return this.postcode;
    }

    //--- DATABASE MAPPING : telphone ( varchar ) 
    public void setTelphone( String telphone ) {
        this.telphone = telphone;
    }
    public String getTelphone() {
        return this.telphone;
    }

    //--- DATABASE MAPPING : email ( varchar ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfAccount( List<AccountEntity> listOfAccount ) {
        this.listOfAccount = listOfAccount;
    }
    public List<AccountEntity> getListOfAccount() {
        return this.listOfAccount;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(bankId);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(address);
        sb.append("|");
        sb.append(postcode);
        sb.append("|");
        sb.append(telphone);
        sb.append("|");
        sb.append(email);
        return sb.toString(); 
    } 

}
