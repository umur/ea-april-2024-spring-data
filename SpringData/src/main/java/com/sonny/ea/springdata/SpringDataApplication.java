package com.sonny.ea.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Resource dataSql = new ClassPathResource("data.sql");
//
//        try (InputStreamReader reader = new InputStreamReader(dataSql.getInputStream())) {
//            String sql = FileCopyUtils.copyToString(reader);
//            jdbcTemplate.execute(sql);
//        }
    }
}
