package system;

public class Person {

    private final String name;
    private final String surname;
    private final String PESEL;
    private final String phoneNumber;

    public Person(String name, String surname, String PESEL, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


    public String getPESEL() {
        return PESEL;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFullData() {
        return
                "i: " + name +
                        ", n: " + surname +
                        ", PESEL: " + PESEL +
                        ", tel: " + phoneNumber
                ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

