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
public class User {

@Id
private String id;

private String firstname;

private String lastname;

private String username;

private String email;

private String password;

private String signintype;

private String fbId;

private String githubId;

private String phonenumber;

private String avatar;

private String Idtoken;

private Date loggedinDate;

private Date loggedoutDate;

private { type: mongoose.Schema.Types.String, ref: &#x27;roles&#x27; } role;

private String org;

private String org_country;

private String org_sub1;

private String org_sub2;

private String org_sub3;

    
    
}

