public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст должен быть >= 0");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не указано имя");
        }
        if (surname == null) {
            throw new IllegalStateException("Не указана фамилия");
        }

        Person person;
        if (age >= 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }

        if (address != null) {
            person.setAddress(address);
        }

        return person;
    }
}
