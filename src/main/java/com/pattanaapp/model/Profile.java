package com.pattanaapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "profile")
public class Profile {

    @Id
    private String id;
    private String name;
    private String email;
    private Integer age;


    @CreatedDate
    private Date createdOn;

    @LastModifiedDate
    private Date updatedOn;

}

