package com.mydailywork.ripan.task.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner ;
public class Subject {

    List<String > subjects = new ArrayList<>(List.of("Physics", "Mathematics", "Chemistry", "Computer-Science"));
    List<Integer> marks = new ArrayList<>(List.of());

    public void showSubjects(){
        System.out.println("Subject List : " + subjects);
    }

    public void enterMarks(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hey Students, please Enter the Marks for each subject (0-100) : ");

        for(String subject : subjects){
            System.out.print("Enter marks for "+subject+" : ");
            int score = scan.nextInt();

            if(score < 0 || score > 100){
                System.out.println("Marks should be between 0 and 100");
                score = scan.nextInt();
            }
            marks.add(score);
        }
    }

    public void subjectsMarks(){
        System.out.println("\nSubjects along with the Marks : ");
        for(int i = 0 ; i < subjects.size() ; i ++){
            System.out.println(subjects.get(i)+" Marks : "+marks.get(i));
        }
    }

    public String calculateGrade(){
        int totalMarks = marks.stream().mapToInt(i -> i).sum();
        int average = totalMarks/marks.size();

        if(average >= 90){
            return "A";
        }else if(average >= 80){
            return "B";
        }else if(average >= 70){
            return "C";
        }else if(average >= 60){
            return "D";
        }else{
            return "F";
        }
    }

    public void showGradeDetails(){
        System.out.println();
        System.out.println("Total Marks : "+marks.stream().mapToInt(i -> i).sum());
        System.out.println("Avarage Marks : "+marks.stream().mapToInt(i -> i).average().getAsDouble());
        System.out.println("Grade : "+calculateGrade());
    }
}
