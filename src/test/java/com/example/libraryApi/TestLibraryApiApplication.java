package com.example.libraryApi;

import org.springframework.boot.SpringApplication;

public class TestLibraryApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(LibraryApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
