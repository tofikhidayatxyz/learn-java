package controller;

import java.util.*;
import hook.*;
import model.*;

public class StudentController {
    // view all student
    public static void viewAllStudent(ArrayList<Student> students) {
        Util.clearConsole();
        System.out.println("========= Data Mahasiswa  =========");
        for(Student student : students){
            System.out.println("Id             : " + student.id);
            System.out.println("Nama mahasiswa : " + student.name);
            System.out.println("NIM mahasiswa  : " + student.nim);
            Util.printSimpleLine();
        }
        Util.printSpace();
    }

    // add one student
    public static void addStudent(Scanner scanner, ArrayList<Student> students) {
        Util.clearConsole();
        String name = "";
        String nim = "";
        System.out.println("========= Input Data Murid ========= ");
        System.out.print("Masukan Nama Murid : ");
        name = scanner.nextLine();
        System.out.print("Masukan NIM Murid  : ");
        nim = scanner.nextLine();
        students.add(new Student((students.size() + 1), name, nim));
        System.out.println("Bashasil menginput data");
        Util.printLine();
    }

    // remove student wieh keyword
    public static void removeStudent(Scanner scanner, ArrayList<Student>students) {
        String keyword  = "";
        Util.clearConsole();
        System.out.println("========= Hapus Data Murid ========= ");
        System.out.print("Masukan keyword [nama/nim/id] : ");
        keyword = scanner.nextLine();
        // loop and delete
        int targetId = findToId(students, keyword);
        if(targetId >= 0) {
            Student currentStudent = students.get(targetId);
            System.out.println("Deleting name : " + currentStudent.name + " nim : " + currentStudent.nim);
            students.remove(targetId);
        } else {
            System.out.println("Murid " + keyword + " tidak terdaftar");
        }
    }

    // find user
    public static int findToId(ArrayList<Student> students, String keyword) {
        for(int i = 0; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            if(currentStudent.nim.toLowerCase().equals(keyword)
                || currentStudent.name.toLowerCase().equals(keyword)
                || currentStudent.id == Integer.parseInt(keyword)
                ) {
                return i;
            }
        }
        return -1;
    }

}