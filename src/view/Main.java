package view;

import controler.ConvertVieToEng;
import controler.FileController;
import controler.PersonManager;
import model.Person;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static String FileName = "file.dat";
    public static void menu() {
        System.out.println("1. Thêm mới");
        System.out.println("2. Xem danh sach");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
        System.out.println("8. Thoát");
        System.out.println("Xin mời bạn chọn chức năng");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("-------------------");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                scanner.nextLine();
                System.out.println("Enter numberPhone: ");
                String numberPhone = scanner.nextLine();
                System.out.println("Enter address: ");
                String address = scanner.nextLine();
                System.out.println("Enter email");
                String email = scanner.nextLine();

                Person person = new Person(name, numberPhone, address, email);
                PersonManager.addPerson(person);
                break;

            case 2:
                PersonManager.display();
                break;
            case 3:

            case 4:
                System.out.println("Enter book name to delete: ");
                String personName = scanner.nextLine();
                LinkedList<Person> personList = new LinkedList<>();
                boolean isSearchPersonName = false;
                for (Person person1: personList ) {
                    if (person1.getName().equalsIgnoreCase(personName)) {
                        isSearchPersonName = true;
                        PersonManager.deletePerson(personName);
                        System.out.println("Deleted!");
                    }
                }
                System.out.println(isSearchPersonName == false);
                System.out.println(" Ten nay khong ton tai");
                break;

            case 5:
                System.out.println("Enter person name to search: ");
                String nameperson = scanner.nextLine();
                String personSearchName = ConvertVieToEng.removeAccent(nameperson).toLowerCase();
                PersonManager.searchByName(personSearchName);
            case 6:
                FileController.writePerson(PersonManager.personList, FileName);
            case 7:
                FileController.readPersonToFile(FileName);
            case 8:
                System.out.println("Thank kou");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
//        PersonManager.personList = FileController.readPersonToFile(FileName);
        while (true) {
            menu();
        }
    }




}
