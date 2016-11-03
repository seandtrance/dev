package mrtestingdemo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextLoader {
	public static String load(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
