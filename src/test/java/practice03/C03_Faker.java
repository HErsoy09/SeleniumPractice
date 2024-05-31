package practice03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C03_Faker {

    public static void main(String[] args) {

        Faker faker = new Faker();
        System.out.println("firstName() = " + faker.name().firstName());
        System.out.println("lastName() = " + faker.name().lastName());
        System.out.println("emailAddress() = " + faker.internet().emailAddress());
        System.out.println("fullAddress() = " + faker.address().fullAddress());
        System.out.println("country() = " + faker.address().country());
    }
}