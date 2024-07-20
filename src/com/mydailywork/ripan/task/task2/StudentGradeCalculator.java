package com.mydailywork.ripan.task.task2;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Subject subject = new Subject();

        subject.showSubjects(); // this will show the subject list

        subject.enterMarks(); // this will ask the user to enter the marks

        subject.subjectsMarks(); // this will show the marks entered by the user for each subject

        subject.showGradeDetails(); // this will give the total, average and grade of the student according to the marks

    }
}
