/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.StudentManagementAPI.resources;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.ws.rs.Path;

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
}