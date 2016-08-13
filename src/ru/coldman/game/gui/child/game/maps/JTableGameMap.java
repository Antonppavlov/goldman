package ru.coldman.game.gui.child.game.maps;

import ru.coldman.game.abstracts.AbstractGameMap;
import ru.coldman.game.abstracts.AbstractGameObject;
import ru.coldman.game.enums.GameObjectType;
import ru.coldman.game.enums.LocationType;
import ru.coldman.game.interfaces.collections.GameCollection;
import ru.coldman.game.interfaces.gamemap.DrawableMap;
import ru.coldman.game.objects.Coordinate;
import ru.coldman.game.objects.Nothing;
import ru.coldman.game.objects.Wall;
import ru.coldman.game.objects.creators.MapCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

/**
 * Created by Антон on 21.07.2016.
 */
public class JTableGameMap extends JTable implements DrawableMap {

    private JTable jTableMap = new JTable();

    //Создаём абстракрутную игровую карту, откуда необходимо будет скачивать будет выбрано выше
    private AbstractGameMap gameMap;
    //массив для хранения названия колонок
    private String[] columnNames;

    // объекты для отображения на карте будут храниться в двумерном массиве типа AbstractGameObject
    // каждый элемент массива будет обозначаться согласно текстовому представлению объекта как описано в GameObjectType
    private AbstractGameObject[][] mapObjects;

    public JTableGameMap(LocationType type, Object source, GameCollection gameCollection) {
        jTableMap.setEnabled(false);
        jTableMap.setSize(new Dimension(300, 300));
        jTableMap.setRowHeight(26);
        jTableMap.setRowSelectionAllowed(false);
        jTableMap.setShowHorizontalLines(false);
        jTableMap.setShowVerticalLines(false);
        jTableMap.setTableHeader(null);
        jTableMap.setUpdateSelectionOnSort(false);
        jTableMap.setVerifyInputWhenFocusTarget(false);

        //выбираем из фабрики объектов каким из классов реализации мы будем пользоваться
        gameMap = MapCreator.getInstance().createMap(type, gameCollection);
        //передаём откуда загрузить карту
        gameMap.loadMap(source);

    }

    @Override
    public boolean drawMap() {
        mapObjects = createGameObjectsArray();

        try {
            columnNames = new String[gameMap.getWidth()];
            // присваиваем пустоту всем заголовкам столбцов, чтобы у таблицы не было заголовоков, а то некрасиво смотрится
            for (int i = 0; i < columnNames.length; i++) {
                columnNames[i] = "";
            }
//TODO УЗКОЕ МЕСТО
            // игровое поле будет отображаться в super без заголовков столбцов
            jTableMap.setModel(new DefaultTableModel(mapObjects, columnNames));


            // вместо текста в ячейках таблицы устанавливаем отображение картинки
            for (int i = 0; i < jTableMap.getColumnCount(); i++) {
                //указываем чтобы в каждой ячейке отображался не текст а инонка. для этого передаёстя объект класса ImageRenderer
                jTableMap.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
                TableColumn a = jTableMap.getColumnModel().getColumn(i);
                a.setPreferredWidth(26);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public Component getMapComponent() {
        return jTableMap;
    }

    @Override
    public AbstractGameMap getGameMap() {
        return gameMap;
    }

    private AbstractGameObject[][] createGameObjectsArray() {

        AbstractGameObject[][] mapObjects = new AbstractGameObject[gameMap.getHeight()][gameMap.getWidth()];

        //вначале мы заполняем весь массив пустотой... чтобы если что-то пропустили
        //то пропущенная область была пустой
        for (int y = 0; y < gameMap.getHeight(); y++) {
            for (int x = 0; x < gameMap.getWidth(); x++) {
                mapObjects[y][x] = new Nothing(new Coordinate(x, y));
            }
        }

        // потом заполнить массив объектами
        for (AbstractGameObject gameObj : gameMap.getGameCollection().getAllGameObjects()) {
            if (!gameObj.getType().equals(GameObjectType.NOTHING)) {// пустоты не добавляем, т.к. они уже добавились когда мы вызвали метод fillEmptyMap()
                int y = gameObj.getCoordinate().getY();
                int x = gameObj.getCoordinate().getX();
                if (!(mapObjects[y][x] instanceof Nothing) & // если в этих координатах уже есть какой то объект, отличный от пустоты и стены
                        !(mapObjects[y][x] instanceof Wall)) {
                    AbstractGameObject tmpObj = mapObjects[y][x];
                    mapObjects[y][x] = gameMap.getPriorityObject(tmpObj, gameObj);
                } else {
                    mapObjects[y][x] = gameObj;// проставить объект на карте согласно его координатам
                }
            }
        }
        return mapObjects;
    }


}


