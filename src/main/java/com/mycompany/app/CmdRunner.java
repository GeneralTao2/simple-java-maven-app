package com.mycompany.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner {
    @Value("${somea}")
    String somea;

    @Value("${someb}")
    String someb;

    @Value("${somec} ${somec} ${somec}")
    String somec;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(somec);
    }
}
