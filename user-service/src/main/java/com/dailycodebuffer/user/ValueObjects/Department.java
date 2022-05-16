package com.dailycodebuffer.user.ValueObjects;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getters ans setters
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
//Department class is needed here (copied from Departmen-service)
//Dont have to add @Entity