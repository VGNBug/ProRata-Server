/*
 * Created on 5 Mar 2016 ( Time 20:49:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.pawsey.prorata.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Persistent class for entity stored in table "pay_cheque"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="pay_cheque", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PayChequeEntity.countAll", query="SELECT COUNT(x) FROM PayChequeEntity x" )
} )
@JsonIgnoreProperties(ignoreUnknown = true) 
public class PayChequeEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="pay_cheque_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pay_cheque_pay_cheque_id_pk_seq")
    @SequenceGenerator(name = "pay_cheque_pay_cheque_id_pk_seq", sequenceName = "pay_cheque_pay_cheque_id_pk_seq")
    protected Integer    payChequeId  ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
	// "paymentId" (column "payment_id") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @JsonBackReference("PaymentEntity_PayChequeEntity")
    @ManyToOne
    @JoinColumn(name="payment_id", referencedColumnName="payment_id")
    protected PaymentEntity payment     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PayChequeEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPayChequeId( Integer payChequeId ) {
        this.payChequeId = payChequeId ;
    }
    public Integer getPayChequeId() {
        return this.payChequeId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setPayment( PaymentEntity payment ) {
        this.payment = payment;
    }
    public PaymentEntity getPayment() {
        return this.payment;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(payChequeId);
        sb.append("]:"); 
        return sb.toString(); 
    } 

}
