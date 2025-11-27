package edu.ntu.bykov.lr4;

import edu.ntu.bykov.lr4.json.JsonManager;
import edu.ntu.bykov.lr4.model.University;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityJsonTest {

    @Test
    public void testJsonSaveAndLoad() throws Exception {
        // Створюємо "старий" університет
        University oldUniversity = Run.createTypicalUniversity();

        // Шлях до файлу з JSON
        Path path = Path.of("university.json");

        // Пишемо університет у файл
        JsonManager jsonManager = new JsonManager();
        jsonManager.writeUniversityToFile(oldUniversity, path);

        // Зчитуємо університет з файлу
        University newUniversity = jsonManager.readUniversityFromFile(path);

        // Порівнюємо
        assertEquals(oldUniversity, newUniversity);
    }
}
