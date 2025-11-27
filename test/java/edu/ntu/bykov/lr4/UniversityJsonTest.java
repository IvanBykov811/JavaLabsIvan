package edu.ntu.bykov.lr4;

import edu.ntu.bykov.lr4.json.JsonManager;
import edu.ntu.bykov.lr4.model.University;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityJsonTest {

    @Test
    public void testJsonSaveAndLoad() throws Exception {
        University oldUniversity = Run.createTypicalUniversity();

        Path path = Path.of("university.json");

        JsonManager jsonManager = new JsonManager();
        jsonManager.writeUniversityToFile(oldUniversity, path);

        University newUniversity = jsonManager.readUniversityFromFile(path);

        assertEquals(oldUniversity, newUniversity);
    }
}
