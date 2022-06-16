package ru.otus.logging;
import java.io.IOException;
import java.util.logging.*;

public class LoggerExample {
    //Создаем экземпляр Logger
    private final static Logger logger = Logger.getLogger(LoggerExample.class.getName());
    //Создаем обработчик файлов для подробных сообщений
    //private static FileHandler finerhandler = null;
    //Создаем обработчик файлов только для конфигурационных сообщений
    //private static FileHandler warninghandler = null;

    public static Logger getLogger() {
        return logger;
    }
    /*
    public static void logIt() {
        try {
            finerhandler = new FileHandler("logging/loggerExample_finer.log", false);
            warninghandler = new FileHandler("logging/loggerExample_config.log", false);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

        //Добавляем базовую программу разметки и устанавливаем уровень
        finerhandler.setFormatter(new SimpleFormatter());
        //Этот обработчик будет печатать все сообщения в свой журнал
        finerhandler.setLevel(Level.FINER);

        //Добавляем базовую программу разметки и устанавливаем уровень
        warninghandler.setFormatter(new SimpleFormatter());
        //Этот обработчик будет печатать только серьезные сообзения в журнал
        warninghandler.setLevel(Level.CONFIG);

        //Добавляем обработчик
        logger.addHandler(finerhandler);
        logger.addHandler(warninghandler);

        //Устанавливаем уровень для FINEST
        //(Записывать ВСЕ сообщения)
        logger.setLevel(Level.FINER);
    }

     */
}
