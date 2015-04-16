package ohtu;

import java.util.ArrayList;

public class Submission {

    private String student_number;
    private Integer excercisesDone;
    private String week;
    private Integer hours;
    private Boolean a1;
    private Boolean a2;
    private Boolean a3;
    private Boolean a4;
    private Boolean a5;
    private Boolean a6;
    private Boolean a7;
    private Boolean a8;
    private Boolean a9;
    private Boolean a10;
    private Boolean a11;
    private Boolean a12;
    private Boolean a13;
    private Boolean a14;
    private Boolean a15;
    private Boolean a16;
    private Boolean a17;
    private Boolean a18;
    private Boolean a19;
    private Boolean a20;
    private Boolean a21;
    private String excersices;

    public Submission() {
        this.excercisesDone = 0;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
    
    public Integer getHours(){
        return this.hours;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + updateExcercisesDone() + ", aikaa kului " + this.hours + " tuntia, tehdyt tehtävät: " + this.excersices + "\n";
    }
    
    public int getExercisesDone(){
        return this.excercisesDone;
    }

    
    public String updateExcercisesDone() {
        StringBuilder sb = new StringBuilder();
     
        if (this.a1 != null && this.a1) {
            excercisesDone++;
            sb.append("1 ");
        }
        if (this.a2 != null && this.a2) {
            excercisesDone++;
            sb.append("2 ");
        }
        if (this.a3 != null && this.a3) {
            excercisesDone++;
            sb.append("3 ");
        }
        if (this.a4 != null && this.a4) {
            excercisesDone++;
            sb.append("4 ");
        }
        if (this.a5 != null && this.a5) {
            excercisesDone++;
            sb.append("5 ");
        }
        if (this.a6 != null && this.a6) {
            excercisesDone++;
            sb.append("6 ");
        }
        if (this.a7 != null && this.a7) {
            excercisesDone++;
            sb.append("7 ");
        }
        if (this.a8 != null && this.a8) {
            excercisesDone++;
            sb.append("8 ");
        }
        if (this.a9 != null && this.a9) {
            excercisesDone++;
            sb.append("9 ");
        }
        if (this.a10 != null && this.a10) {
            excercisesDone++;
            sb.append("10 ");
        }
        if (this.a11 != null && this.a11) {
            excercisesDone++;
            sb.append("11 ");
        }
        if (this.a12 != null && this.a12) {
            excercisesDone++;
            sb.append("12 ");
        }
        if (this.a13 != null && this.a13) {
            excercisesDone++;
            sb.append("13 ");
        }
        if (this.a14 != null && this.a14) {
            excercisesDone++;
            sb.append("14 ");
        }
        if (this.a15 != null && this.a15) {
            excercisesDone++;
            sb.append("15 ");
        }
        if (this.a16 != null && this.a16) {
            excercisesDone++;
            sb.append("16 ");
        }
        if (this.a17 != null && this.a17) {
            excercisesDone++;
            sb.append("17 ");
        }
        if (this.a18 != null && this.a18) {
            excercisesDone++;
            sb.append("18 ");
        }
        if (this.a19 != null && this.a19) {
            excercisesDone++;
            sb.append("19 ");
        }
        if (this.a20 != null && this.a20) {
            excercisesDone++;
            sb.append("20 ");
        }
        if (this.a21 != null && this.a21) {
            excercisesDone++;
            sb.append("21 ");
        }
        this.excersices = sb.toString();
         return excercisesDone + "";

    }
}