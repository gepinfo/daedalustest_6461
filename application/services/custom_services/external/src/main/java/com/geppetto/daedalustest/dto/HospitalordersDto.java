package com.geppetto.daedalustest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HospitalordersDto {

    @NotBlank(message = "id cannot be null or empty")
    private String id;
     
    @NotBlank(message = "orderid cannot be null or empty")  
    private String orderid;
   
    @NotBlank(message = "specimentno cannot be null or empty")  
    private String specimentno;
   
    @NotBlank(message = "patientid cannot be null or empty")  
    private String patientid;
   
    @NotBlank(message = "facility cannot be null or empty")  
    private String facility;
   
    @NotBlank(message = "episodeid cannot be null or empty")  
    private String episodeid;
   
    @NotBlank(message = "episodetype cannot be null or empty")  
    private String episodetype;
   
    @NotBlank(message = "doctor cannot be null or empty")  
    private String doctor;
   
    @NotBlank(message = "type cannot be null or empty")  
    private String type;
   
    @NotBlank(message = "code cannot be null or empty")  
    private String code;
   
    @NotBlank(message = "ps cannot be null or empty")  
    private String ps;
  
    }
