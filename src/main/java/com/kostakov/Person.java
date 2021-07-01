package com.kostakov;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String residenceCity;

    public Person(String name, String surname, Integer age, String residenceCity) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.residenceCity = residenceCity;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    boolean hasAge() {
       return this.age != null;
    }

    public void happyBirthday () {
        if (this.hasAge() ) age = age + 1;
    }

    public void setAge(Integer age) {
        if (!this.hasAge()) this.age = age;
    }

    public boolean hasResidenceCity() {
        return this.residenceCity != null;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    @Override
    public String toString(){
        return "Имя: " + name
                + ", фамилия: " + surname
                + (hasAge() ? ", возраст: " + age : "")
                + (hasResidenceCity() ? ",  место жительства: " + residenceCity + "." : ".");
    }


    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder newChildBuilder() {
        Builder childBuilder = newBuilder();
        childBuilder.surname = this.surname;
        childBuilder.age = 0;
        childBuilder.residenceCity = this.residenceCity;
        return childBuilder;
    }

    public static class Builder {
        private String name;
        private String surname;
        protected Integer age;
        protected String residenceCity;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setResidenceCity(String residenceCity) {
            this.residenceCity = residenceCity;
            return this;
        }

        public Person buildPerson() throws IllegalStateException, IllegalArgumentException {
            Person person = new Person(name, surname, age, residenceCity);
            if (person.name == null) {
                throw new IllegalStateException("ИМЯ");
            }

            if (person.surname == null) {
                throw new IllegalStateException("ФАМИЛИЯ");
            }

            if (person.age != null) {
                if (person.age < 0 || person.age > 140) {
                    throw new IllegalArgumentException("ВОЗРАСТ");
                }
            }
            return person;
        }
    }

}
