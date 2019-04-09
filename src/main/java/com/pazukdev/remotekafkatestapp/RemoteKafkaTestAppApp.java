package com.pazukdev.remotekafkatestapp;

import com.pazukdev.remotekafkatestapp.terminal.InputProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RemoteKafkaTestAppApp implements CommandLineRunner {

    private final InputProcessor inputProcessor;

    public static void main(String[] args) {
        SpringApplication.run(RemoteKafkaTestAppApp.class, args);
    }

    @Override
    public void run(String... strings) {
        inputProcessor.processInput();
    }

}
