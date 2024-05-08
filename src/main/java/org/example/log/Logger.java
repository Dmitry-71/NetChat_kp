package org.example.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static Logger instance;
    private static final String PATH = "C:\\Users\\User\\OneDrive\\Рабочий стол\\" +
            "Работа\\Тест\\Учеба\\NetChat_kp\\src\\main\\java\\org\\example\\log\\log.txt";

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public boolean log(String message) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(PATH, true));
            writer.write(LocalDateTime.now().format(formatter) + " " + message + "\n");
            writer.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
