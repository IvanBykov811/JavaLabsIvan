package edu.ntu.bykov.lr4.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.ntu.bykov.lr4.model.University;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonManager {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public void writeUniversityToFile(University university, Path path) throws IOException {
        String json = gson.toJson(university);
        Files.writeString(path, json, StandardCharsets.UTF_8);
    }

    public University readUniversityFromFile(Path path) throws IOException {
        String json = Files.readString(path, StandardCharsets.UTF_8);
        return gson.fromJson(json, University.class);
    }
}
