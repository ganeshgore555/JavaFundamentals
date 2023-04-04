package com.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileApi {

	public static void main(String[] args) throws IOException {
		System.out.println("Read File");
		Path path = Paths.get("resources", "person.txt");
		Stream<String> lineStream = Files.lines(path);
		lineStream.forEach(System.out::println);
		
		System.out.println("\nRead Folder");
		Path folderPath = Paths.get("resources");
		Stream<Path> folderStream = Files.list(folderPath);
		folderStream.map(p -> p.getFileName()).forEach(System.out::println);;

	
		System.out.println("\nRead Folder Recursively");
		Path recursiveFolderPath = Paths.get("resources");
		Stream<Path> recursiveFolderStream = Files.walk(recursiveFolderPath);
		recursiveFolderStream.map(p -> p.getFileName()).forEach(System.out::println);;

	}

}
