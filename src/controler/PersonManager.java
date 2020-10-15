package controler;

import model.Person;
import view.Main;


import java.io.Serializable;
import java.util.LinkedList;

public class PersonManager implements Serializable {
    public static LinkedList<Person> personList = new LinkedList();


    public static void addPerson(Person person) {
        personList.add(person);
        FileController.writePerson(PersonManager.personList, Main.FileName);
    }
    public static void display() {
        personList = FileController.readPersonToFile(Main.FileName);
        for (Person person: personList) {
            person.toString();
        }
    }
    public static void deletePerson(String Name) {
        personList.remove(Name);
        FileController.writePerson(PersonManager.personList, Main.FileName);
    }
    public static void searchByName(String Name) {
        boolean isPersonSearchExits = false;
        for (Person person: personList) {
        String namePerson = person.getName();
        String toSearchName = ConvertVieToEng.removeAccent(namePerson).toLowerCase();
        if (toSearchName.equalsIgnoreCase(Name) || toSearchName.contains(Name)){
            isPersonSearchExits = true;
            person.toString();
        }
        }
        if (isPersonSearchExits == false) {
            System.out.println(" ten nay khong ton tai");
        }
    }




}
