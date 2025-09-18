import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1; // "возраст неизвестен"
    protected String address;

    public Person(String name, String surname) {
        this.name = Objects.requireNonNull(name, "Имя не может быть null");
        this.surname = Objects.requireNonNull(surname, "Фамилия не может быть null");
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (!hasAge()) {
            throw new IllegalStateException("Возраст неизвестен, нельзя увеличить");
        }
        age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder();
        builder.setSurname(this.surname);
        builder.setAge(0); // ребёнку 0 лет
        if (this.hasAddress()) {
            builder.setAddress(this.address);
        }
        return builder;
    }

    @Override
    public String toString() {
        return name + " " + surname +
                (hasAge() ? ", возраст " + age : "") +
                (hasAddress() ? ", проживает в " + address : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }
}
