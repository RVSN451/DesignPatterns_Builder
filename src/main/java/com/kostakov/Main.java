package com.kostakov;

public class Main
{
    public static void main( String[] args ) throws IllegalStateException, IllegalArgumentException
    {
        Person dad = Person.newBuilder()
                .setName("Ivan")
                .setSurname("Ivanov")
                .setAge(40)
                .setResidenceCity("Moscow")
                .buildPerson();

        Person mom = Person.newBuilder()
                .setName("Ivanessa")
                .setSurname("Ivanova")
                .buildPerson();


        Person son = dad.newChildBuilder()
                .setName("Ivanushka")
                .buildPerson();

        System.out.println("Папа, мама, сын: " + "\n\t\t" + dad + "\n\t\t" + mom + "\n\t\t" + son);

        System.out.println("\n\nПРОВЕРКА РАБОТЫ ИСКЛЮЧЕНИЙ:");

        try {
            Person grMom = Person.newBuilder()
                    .buildPerson();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person grDad = Person.newBuilder()
                    .setName("Petr")
                    .setSurname("Ivanov")
                    .setAge(150)
                    .setResidenceCity("Moscow")
                    .buildPerson();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        dad.happyBirthday();
        System.out.println("У ПАПЫ ДЕНЬ РОЖДЕНИЯ: " + dad);

        mom.setAge(33);
        System.out.println("ПРИСВОИМ МАМЕ ВОЗРАСТ: " + mom);

        mom.setAge(40);
        System.out.println("ПОПЫТКА ИЗМЕНИТЬ МАМИН ВОЗРАСТ (!= null) ЧЕРЕЗ setAge НЕ УДАЛАСЬ: " + mom);
    }
}
