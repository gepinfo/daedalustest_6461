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
public class Externalpatients {

@Id
private String id;

private String extpatients;

private String patientname;

private String locpatientname;

private String gender;

private String dob;

private String source;

private String description;

private String pretix;

private String sourcepatientid;

private String idno;

    
    
}

