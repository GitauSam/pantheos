package com.phosphor.jumiaex;

import com.phosphor.jumiaex.entities.Customer;
import com.phosphor.jumiaex.entities.CustomerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class CustomerEntityTest {
    @Test
    void givenMoroccanPhoneNumber_WhenPhoneNumberIsInvalid_ReturnsFalse() {
        Customer customer = new CustomerEntity("Walid Hammadi", "(212) 6007989253");

        assertThat(customer.isPhoneNumberValid()).isFalse();
    }

    @Test
    void givenMoroccanPhoneNumber_WhenPhoneNumberIsValid_ReturnsTrue() {
        Customer customer = new CustomerEntity("Yosaf Karrouch", "(212) 698054317");

        assertThat(customer.isPhoneNumberValid()).isTrue();
    }

    @Test
    void givenMozambicanPhoneNumber_WhenPhoneNumberIsInvalid_ReturnsFalse() {
        Customer customer = new CustomerEntity("Tanvi Sachdeva", "(258) 84330678235");

        assertThat(customer.isPhoneNumberValid()).isFalse();
    }

    @Test
    void givenMozambicanPhoneNumber_WhenPhoneNumberIsValid_ReturnsTrue() {
        Customer customer = new CustomerEntity("Pedro B 173", "(258) 823747618");

        assertThat(customer.isPhoneNumberValid()).isTrue();
    }

    @Test
    void givenUgandanPhoneNumber_WhenPhoneNumberIsInvalid_ReturnsFalse() {
        Customer customer = new CustomerEntity("Jokkene Richard", "(256) 7734127498");

        assertThat(customer.isPhoneNumberValid()).isFalse();
    }

    @Test
    void givenUgandanPhoneNumber_WhenPhoneNumberIsValid_ReturnsTrue() {
        Customer customer = new CustomerEntity("JACKSON NELLY", "(256) 775069443");

        assertThat(customer.isPhoneNumberValid()).isTrue();
    }

    @Test
    void givenCameroonianPhoneNumber_WhenPhoneNumberIsInvalid_ReturnsFalse() {
        Customer customer = new CustomerEntity("WILLIAM KEMFANG", "(237) 6622284920");

        assertThat(customer.isPhoneNumberValid()).isFalse();
    }

    @Test
    void givenCameroonianPhoneNumber_WhenPhoneNumberIsValid_ReturnsTrue() {
        Customer customer = new CustomerEntity("LOUIS PARFAIT OMBES NTSO", "(237) 673122155");

        assertThat(customer.isPhoneNumberValid()).isTrue();
    }

    @Test
    void givenEthiopianPhoneNumber_WhenPhoneNumberIsInvalid_ReturnsFalse() {
        Customer customer = new CustomerEntity("shop23 sales", "(251) 9773199405");

        assertThat(customer.isPhoneNumberValid()).isFalse();
    }

//    @Test
//    void givenEthiopianPhoneNumber_WhenPhoneNumberIsValid_ReturnsTrue() {
//        Customer customer = new CustomerImpl("EPHREM KINFE", "(251) 914148181");
//
//        assertThat(customer.isPhoneValid()).isTrue();
//    }

    @Test
    void givenPhoneNumber_WhenCountryCodeIs237_ReturnsCameroon() {
        Customer customer = new CustomerEntity("LOUIS PARFAIT OMBES NTSO", "(237) 673122155");

        assertThat(customer.getCountry())
                .isEqualTo("Cameroon");
    }

    @Test
    void givenPhoneNumber_WhenCountryCodeIs251_ReturnsEthiopia() {
        Customer customer = new CustomerEntity("EPHREM KINFE", "(251) 914148181");

        assertThat(customer.getCountry())
                .isEqualTo("Ethiopia");
    }

    @Test
    void givenPhoneNumber_WhenCountryCodeIs212_ReturnsMorocco() {
        Customer customer = new CustomerEntity("Yosaf Karrouch", "(212) 698054317");

        assertThat(customer.getCountry())
                .isEqualTo("Morocco");
    }

    @Test
    void givenPhoneNumber_WhenCountryCodeIs258_ReturnsMozambique() {
        Customer customer = new CustomerEntity("Tanvi Sachdeva", "(258) 84330678235");

        assertThat(customer.getCountry())
                .isEqualTo("Mozambique");
    }

    @Test
    void givenPhoneNumber_WhenCountryCodeIs256_ReturnsUganda() {
        Customer customer = new CustomerEntity("Jokkene Richard", "(256) 7734127498");

        assertThat(customer.getCountry())
                .isEqualTo("Uganda");
    }

}
