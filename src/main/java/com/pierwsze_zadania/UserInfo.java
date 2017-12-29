package com.pierwsze_zadania;

class UserInfo {
    String name;
    double age;
    double height;

    UserInfo(String name, double age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
        validateName();
    }
    public void validateName() {
        if (this.name.length() != 0) {
            System.out.println("Username: " + this.name);
        } else {
            System.out.println("Username is not entered!!!");
            System.exit(0);
        }
    }
    public boolean isVariable() {
        if (this.age != 0 && this.height != 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validateAge() {
        if (this.age > 30) {
            return true;
        } else {
            return false;
        }
    }
    public boolean validateHeight() {
        if (this.height > 160) {
            return true;
        } else {
            return false;
        }
    }
}
class Application12 {
    public static void main(String[] args) {
        UserInfo user = new UserInfo("David", 44.5, 176);
        if (user.isVariable()) {
            if (user.validateAge() && user.validateHeight()) {
                System.out.print("User is older than 30 and higher then 160 cm\n");
            } else {
                System.out.print("User is younger than 30 or lower than 160 cm\n");
            }
        } else {
            System.out.println("The value of age or height is not entered!!!");
        }
    }
}
