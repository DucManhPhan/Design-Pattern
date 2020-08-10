package com.manhpd.peple_student_builder;

public class ApplicationPeopleStudent {

    public static void main(String[] args) {
        Student student= Student.builder()
                .name("Google.com")
                .age(30)
                .school("AlphaBet")
                .build();
        System.out.println(student.toString());

        People people = People.builder()
                .name("facebook.com")
                .age(20)
                .build();
        System.out.println(people.toString());

        Pupil pupil = (Pupil) Pupil.builder()
                .something("something with Pupil")
                .name("Pupil.com")
                .age(12)
                .school("pupil school")
                .build();
        System.out.println(pupil.toString());
    }

}
