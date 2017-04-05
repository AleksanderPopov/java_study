package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_16.challenges.challenge_9;

/**
 * Created by timbuchalka on 16/08/2016.
 */
public class Challenge9 {
    public static void main(String[] args) {
        final NewTutor tutor = new NewTutor();
        final NewStudent student = new NewStudent();
        tutor.student = student;
        student.tutor = tutor;

        Thread tutorThread = new Thread(() -> tutor.studyTime());

        Thread studentThread = new Thread(() -> student.handInAssignment());

        tutorThread.start();
        studentThread.start();
    }
}

class NewTutor {
    NewStudent student;

    public void studyTime() {
        try {
            System.out.println("Tutor has arrived");
            synchronized (student) {
                student.wait();
            }
            student.startStudy();
            System.out.println("Tutor is studying with student");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getProgressReport() {
        System.out.println("Tutor gave progress report");
    }
}

class NewStudent {

    NewTutor tutor;

    public void startStudy() {
        System.out.println("Student is studying");
    }

    public void handInAssignment() {
        tutor.getProgressReport();
        System.out.println("Student handed in assignment");
        synchronized (this) {
            this.notify();
        }
    }
}