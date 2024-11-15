package com.geppetto.daedalustest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospitalorders {

@Id
private String id;

private String orderid;

private String specimentno;

private String patientid;

private String facility;

private String episodeid;

private String episodetype;

private String doctor;

private String type;

private String code;

private String ps;

    
    
}

