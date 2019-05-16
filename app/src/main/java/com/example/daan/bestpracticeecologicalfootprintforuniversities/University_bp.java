package com.example.daan.bestpracticeecologicalfootprintforuniversities;

public class University_bp implements Comparable<University_bp> {
    String university, value;

    public University_bp(String university, String value) {
        this.university = university;
        this.value = value;
    }

    @Override
    public int compareTo(University_bp o) {
        return this.value.compareToIgnoreCase(o.value);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
