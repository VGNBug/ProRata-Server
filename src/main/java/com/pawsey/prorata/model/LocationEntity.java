/*
 * Created on 13 Mar 2016 ( Time 11:28:45 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.pawsey.prorata.model;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

/**
 * Persistent class for entity stored in table "location"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="location", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="LocationEntity.countAll", query="SELECT COUNT(x) FROM LocationEntity x" )
} )
@JsonIgnoreProperties(ignoreUnknown = true) 
public class LocationEntity implements Serializable {

    protected static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="location_id", nullable=false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_location_id_pk_seq")
    @SequenceGenerator(name = "location_location_id_pk_seq", sequenceName = "location_location_id_pk_seq")
    protected Integer    locationId   ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="x_coordinate", nullable=false)
    protected BigDecimal xCoordinate  ;

    @Column(name="y_coordinate", nullable=false)
    protected BigDecimal yCoordinate  ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @JsonManagedReference("LocationEntity_EmploymentSessionEntity")
    @OneToMany(mappedBy="location", targetEntity=EmploymentSessionEntity.class)
    protected List<EmploymentSessionEntity> listOfEmploymentSession;

    @JsonBackReference("ProrataUserEntity_LocationEntity")
    @ManyToOne
    @JoinColumn(name="prorata_user_id", referencedColumnName="prorata_user_id")
    protected ProrataUserEntity prorataUser ;

    @JsonBackReference("EmploymentEntity_LocationEntity")
    @ManyToOne
    @JoinColumn(name="employment_id", referencedColumnName="employment_id")
    protected EmploymentEntity employment ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LocationEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLocationId( Integer locationId ) {
        this.locationId = locationId ;
    }
    public Integer getLocationId() {
        return this.locationId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : x_coordinate ( numeric ) 
    public void setXCoordinate( BigDecimal xCoordinate ) {
        this.xCoordinate = xCoordinate;
    }
    public BigDecimal getXCoordinate() {
        return this.xCoordinate;
    }

    //--- DATABASE MAPPING : y_coordinate ( numeric ) 
    public void setYCoordinate( BigDecimal yCoordinate ) {
        this.yCoordinate = yCoordinate;
    }
    public BigDecimal getYCoordinate() {
        return this.yCoordinate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfEmploymentSession( List<EmploymentSessionEntity> listOfEmploymentSession ) {
        this.listOfEmploymentSession = listOfEmploymentSession;
    }
    public List<EmploymentSessionEntity> getListOfEmploymentSession() {
        return this.listOfEmploymentSession;
    }

    public ProrataUserEntity getProrataUser() { return this.prorataUser; }
    public void setProrataUser(ProrataUserEntity prorataUser) { this.prorataUser = prorataUser; }

    public EmploymentEntity getEmployment() { return this.employment; }
    public void setEmployment(EmploymentEntity employment) { this.employment = employment; }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(locationId);
        sb.append("]:"); 
        sb.append(xCoordinate);
        sb.append("|");
        sb.append(yCoordinate);
        return sb.toString(); 
    } 

}
