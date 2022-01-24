package com.company;

import java.util.Objects;

enum Gender {
    MALE,
    FEMALE
}

class AgeGroup {
    private int minAge;
    private int maxAge;
    public AgeGroup(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }
    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgeGroup ageGroup = (AgeGroup) o;

        if (minAge != ageGroup.minAge) return false;
        return maxAge == ageGroup.maxAge;
    }

    @Override
    public int hashCode() {
        int result = minAge;
        result = 31 * result + maxAge;
        return result;
    }
}

class People {

    private String name;
    private Gender gender;
    private AgeGroup ageGroup;

    public People(String name, Gender gender, AgeGroup ageGroup) {
        this.name = name;
        this.gender = gender;
        this.ageGroup = ageGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return name.equals(people.name) && gender == people.gender && ageGroup.equals(people.ageGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, ageGroup);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }
}

class Men extends People {

    public Men(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }

}

class Boy extends Men {

    public Boy(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

class AdultMen extends Men {

    public AdultMen(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

class SeniorMen extends Men {

    public SeniorMen(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

class Women extends People {

    public Women(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

class Girl extends Women {

    public Girl(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

class AdultWomen extends Women {

    public AdultWomen(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

class SeniorWomen extends Men {

    public SeniorWomen(String name, Gender gender, AgeGroup ageGroup) {
        super(name, gender, ageGroup);
    }
}

public class PeopleFactory {
    private PeopleFactory() {}

    public static People createPeople(String name, Gender gender, int age) {
        People people;
        final AgeGroup kid = new AgeGroup(0, 17);
        final AgeGroup adult = new AgeGroup(18, 60);
        final AgeGroup senior = new AgeGroup(60, 100);
        if(gender.equals(Gender.MALE)) {
            if(age < 18) {
                people = new Boy(name, gender, kid);
            } else if(age < 50) {
                people = new AdultMen(name, gender, adult);
            } else {
                people = new SeniorMen(name, gender, senior);
            }
        } else {
            if(age < 18) {
                people = new Girl(name, gender, kid);
            } else if(age < 60) {
                people = new AdultWomen(name, gender, adult);
            } else {
                people = new SeniorWomen(name, gender, senior);
            }
        }
        return people;
    }

}