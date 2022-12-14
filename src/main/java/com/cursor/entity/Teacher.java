package com.cursor.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@ToString
@RequiredArgsConstructor
@Entity
public class Teacher {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String firstName;
    String lastName;
    String gender;
    int age;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<StudentsGroup> studentsGroups = new ArrayList<>();

    public Teacher(String firstName, String lastName, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public void addStudentsGroup(StudentsGroup studentsGroup) {
        studentsGroups.add(studentsGroup);
        studentsGroup.setTeacher(this);
    }

    public void deleteStudentsGroup(StudentsGroup studentsGroup) {
        studentsGroups.remove(studentsGroup);
    }

}
