package com.kostakov;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class PersonTest {


    @Test
    void hasResidenceCity() {
    }

    @Test
    void newBuilderClass_isCorrect()  {
        Person.Builder expected = new Person.Builder();
        Person.Builder actual = Person.newBuilder();
        Assertions.assertEquals(actual.getClass(), expected.getClass());
    }

    @Test
    void newChildBuilderName_isCorrect() throws IllegalStateException, IllegalArgumentException {

        Person perent = new Person("Sergey", "Petrov", 45,
                "Moscow");

        Person child = perent.newChildBuilder()
                .setName("Ivanushka")
                .buildPerson();

        assertThat(child, Matchers.hasProperty("name", equalTo("Ivanushka")));
    }

    @Test
    void newChildBuilderAge_isCorrect() throws IllegalStateException, IllegalArgumentException {

        Person perent = new Person("Sergey", "Petrov", 45,
                "Moscow");

        Person child = perent.newChildBuilder()
                .setName("Ivanushka")
                .buildPerson();

        assertThat(child, Matchers.hasProperty("age", equalTo(0)));
    }

    @Test
    void newChildBuilderResidenceCity_isCorrect() throws IllegalStateException, IllegalArgumentException {

        Person perent = new Person("Sergey", "Petrov", 45,
                "Moscow");

        Person child = perent.newChildBuilder()
                .setName("Ivanushka")
                .buildPerson();

        assertThat(child, Matchers.hasProperty("residenceCity", equalTo("Moscow")));
    }


    @Test
    public void giveValueName_thenCorrect() {
        Person person = new Person("Sergey", "Petrov", 45,
                "Moscow");

        assertThat(person, Matchers.hasProperty("name", equalTo("Sergey")));
    }
}