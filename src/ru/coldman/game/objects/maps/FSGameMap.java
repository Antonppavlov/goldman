package ru.coldman.game.objects.maps;

import ru.coldman.game.abstracts.AbstractGameMap;
import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.objects.creators.GameObjectCreator;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.interfaces.collections.GameCollection;
import ru.coldman.game.objects.Coordinate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

//класс реализации ЗАГУЗКИ
//СОХРАНЕНИЯ
//ОТРИСОВКИ 
//карты
public class FSGameMap extends AbstractGameMap {


    public FSGameMap(GameCollection gameCollection) {
        super(gameCollection);
    }

    @Override
    public boolean loadMap(Object source) {
        File file = new File(source.toString());
        if (!file.exists()) {
            throw new IllegalArgumentException("filename must not be empty!");
        }

        try {
            setExitExist(false);
            setGoldManExist(false);

            //Устанавливаем высоту
            setHeight(getLineCount(file));

            //берем весь текст из файла и помещаем в буфер 
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            // считываем первую строку для определения имени, длины, ширины карты. убираем пробела по краям
            String strLine = bufferedReader.readLine().trim();

            // разбиваем первую строку на токены, разделенные запятой.
            String[] textsInFirstLine = strLine.split(",");
            //Первый элемент это имя
            setName(textsInFirstLine[0]);
            //второй время
            setTimeLimit(Integer.valueOf(textsInFirstLine[1]).intValue());
            //третий ширина
            setWidth(Integer.valueOf(textsInFirstLine[2]).intValue());

            //переменные для координат
            int y = 0; // номер строки в массиве
            int x; // номер столбца в массиве

            //берем строку из файла
            while ((strLine = bufferedReader.readLine()) != null) {
                // чтобы каждый раз с первого столбца начинал
                x = 0;
                //бьём на массив стингов через , и обращаемся к каждой стринге
                for (String str : strLine.split(",")) {

                    //отправляем стирнг и её координаты в метод createGameObject
                    createGameObject(str, new Coordinate(x, y));
                    x++;
                }
                y++;
            }

            if (!isValidMap()) {
                throw new Exception("The map is not valid!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return true;

    }

    //метод принимает на вход стринг и координаты
    private void createGameObject(String str, Coordinate coordinate) {

        //Вычисляем какой тип объекта передаётся в стинг
        GameObjectType type = GameObjectType.valueOf(str.toUpperCase());

        //создаём асбтрактый объект передав туда тип объекта используя патерн фабрика объектов
        AbstractGameObject newObj = GameObjectCreator.getInstance().createObject(type, coordinate);
        //добавляем объект в коллекции отпавив в метод addGameObject абстрактного класса AbstractGameMap
        getGameCollection().addGameObject(newObj);


        //если тип объекта EXIT или GOLDMAN меняем значения соотвествующих переменных
        if (newObj.getType() == GameObjectType.EXIT) {
            setExitExist(true);
        } else if (newObj.getType() == GameObjectType.GOLDMAN) {
            setGoldManExist(true);
        }

    }

    //метод возвращает количество строчек в файле -1 т.к. первая строка не относится к карте
    private int getLineCount(File file) {
        BufferedReader reader = null;
        int lineCount = 0;
        try {
            reader = new BufferedReader(new FileReader(file));

            while (reader.readLine() != null) {
                lineCount++;
            }
            lineCount = lineCount - 1;
            // lineNumber-1 потому что первая строка из файла не входит в карту
        } catch (IOException ex) {
            Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(FSGameMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lineCount;

    }

    @Override
    public boolean saveMap(Object source) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
