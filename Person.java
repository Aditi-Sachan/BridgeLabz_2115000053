import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {
        Person person = new Person(25);

        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);

        System.out.println("Original Age: " + field.get(person));

        field.set(person, 30);
        System.out.println("Modified Age: " + field.get(person));
    }
}
