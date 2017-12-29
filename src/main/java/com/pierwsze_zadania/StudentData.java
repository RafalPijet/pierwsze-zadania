package com.pierwsze_zadania;

import java.util.*;

class StudentData {
    private String firstName;
    private String lastName;
    private String idPesel;
    private char sex;

    public StudentData(String firstName, String lastName, String idPesel, char sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idPesel = idPesel;
        this.sex = sex;
    }
    public String toString() {
        return firstName + " " + lastName + ", plec: " + sex + ", data urodz.: 19" + idPesel.substring(0, 2) + "-" + idPesel.substring(2, 4) + "-" + idPesel.substring(4, 6);
    }
}
class StudentEvaluation {
    private ArrayList<Integer> maths = new ArrayList<Integer>();
    private ArrayList<Integer> informatics = new ArrayList<Integer>();
    private ArrayList<Integer> polishLanguage = new ArrayList<Integer>();
    private ArrayList<Integer> englishLanguage = new ArrayList<Integer>();
    private ArrayList<Integer> germanLanguage = new ArrayList<Integer>();
    private ArrayList<Integer> chemistry = new ArrayList<Integer>();
    private ArrayList<Integer> physics = new ArrayList<Integer>();
    private ArrayList<Integer> biology = new ArrayList<Integer>();
    private ArrayList<Integer> history = new ArrayList<Integer>();
    private ArrayList<Integer> physicalEducation = new ArrayList<Integer>();
    private double averageEvaluation;

    public StudentEvaluation (int evaluationQuantity) {
        this.averageEvaluation = createStudentEvaluation(evaluationQuantity);
    }

    public double createStudentEvaluation(int evaluationQuantity) {
        Random rand = new Random();
        int counter = 0;
        for (int i = 0; i < evaluationQuantity; i++) {
            maths.add(rand.nextInt(6) + 1);
            counter += maths.get(i);
            informatics.add(rand.nextInt(6) + 1);
            counter += informatics.get(i);
            polishLanguage.add(rand.nextInt(6) + 1);
            counter += polishLanguage.get(i);
            englishLanguage.add(rand.nextInt(6) + 1);
            counter += englishLanguage.get(i);
            germanLanguage.add(rand.nextInt(6) + 1);
            counter += germanLanguage.get(i);
            chemistry.add(rand.nextInt(6) + 1);
            counter += chemistry.get(i);
            physics.add(rand.nextInt(6) + 1);
            counter += physics.get(i);
            biology.add(rand.nextInt(6) + 1);
            counter += biology.get(i);
            history.add(rand.nextInt(6) + 1);
            counter += history.get(i);
            physicalEducation.add(rand.nextInt(6) + 1);
            counter += physicalEducation.get(i);
        }
        return (double) counter / (evaluationQuantity * 10);
    }
    public double getMaths() {
        Integer counter = 0;
        for (Integer i : this.maths) {
            counter += i;
        }
        return (double) counter / this.maths.size();
    }
    public double getInformatics() {
        Integer counter = 0;
        for (Integer i : this.informatics) {
            counter += i;
        }
        return (double) counter / this.informatics.size();
    }
    public double getAverage() {
        return this.averageEvaluation;
    }
    public String toString() {
        return "---> " + getAverage();
    }
}
class Application4 {
    public static void main(String[] args) {
        StudentData student1 = new StudentData("John", "Travolta", "54021874521", 'm');
        StudentData student2 = new StudentData("Cindy", "Crawford", "66022085124", 'f');
        StudentData student3 = new StudentData("Robert", "De Niro", "43081798752", 'm');
        StudentData student4 = new StudentData("Janifer", "Connelly", "70121236545", 'f');
        StudentEvaluation evaluation1 = new StudentEvaluation(20);
        StudentEvaluation evaluation2 = new StudentEvaluation(17);
        StudentEvaluation evaluation3 = new StudentEvaluation(10);
        StudentEvaluation evaluation4 = new StudentEvaluation(25);
        HashMap<StudentData, StudentEvaluation> schoolRecords = new HashMap<StudentData, StudentEvaluation>();
        schoolRecords.put(student1, evaluation1);
        schoolRecords.put(student2, evaluation2);
        schoolRecords.put(student3, evaluation3);
        schoolRecords.put(student4, evaluation4);
        System.out.println("Wykaz sredniej wszystkich ocen dla kazdego ucznia:");
        for (Map.Entry<StudentData, StudentEvaluation> entry : schoolRecords.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("\nWykaz sredniej ocen z matematyki oraz informatyki dla każdego ucznia:");
        for (Map.Entry<StudentData, StudentEvaluation> entry : schoolRecords.entrySet()) {
            System.out.println(entry.getKey() + ", srednia z matematyki --> " + entry.getValue().getMaths());
            System.out.println(entry.getKey() + ", srednia z informatyki --> " + entry.getValue().getInformatics());
        }
        System.out.println("\nWykaz sredniej wszystkich ocen dla jednego ucznia:");
        System.out.println(student4.toString() + " ---> " + schoolRecords.get(student4).getAverage());
    }
}
