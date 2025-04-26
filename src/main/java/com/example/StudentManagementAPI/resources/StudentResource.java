/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StudentManagementAPI.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/students")
public class StudentResource{
    
    private static final ConcurrentHashMap<String, Student> studentStore=new ConcurrentHashMap<>();
    
    static{
        addInitialStudents();
    }
    
    private static void addInitialStudents(){
        Student student1=new Student(UUID.randomUUID().toString(), "Alice", "Smith");
        Student student2 = new Student(UUID.randomUUID().toString(), "Bob","Johnson");
        Student student3 = new Student(UUID.randomUUID().toString(), "Charlie","Brown");
        
        studentStore.put(student1.getId(), student1);
        studentStore.put(student2.getId(), student2);
        studentStore.put(student3.getId(), student3);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents(){
        return new ArrayList<>(studentStore.values()); 
    }
    
    
}