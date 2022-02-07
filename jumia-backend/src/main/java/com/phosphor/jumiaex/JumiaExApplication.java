package com.phosphor.jumiaex;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sqlite.Function;

import java.sql.SQLException;

@AllArgsConstructor
@SpringBootApplication
public class JumiaExApplication {

    public static void main(String[] args) {
        SpringApplication.run(JumiaExApplication.class, args);
    }

}
