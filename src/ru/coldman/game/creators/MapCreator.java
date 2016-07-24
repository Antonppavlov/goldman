package ru.coldman.game.creators;


import ru.coldman.game.abstracts.AbstractGameMap;
import ru.coldman.game.enums.LocationType;
import ru.coldman.game.collections.GameCollection;
import ru.coldman.game.objects.maps.FSGameMap;

/*
патернт фабрика объектов для классов имлементтящих AbstractGameMap, в зависимости от
переданного типа enum LocationType будет выбранна реализация
 */

public class MapCreator {

    private static MapCreator instance;

    public static MapCreator getInstance() {
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }

    public AbstractGameMap createMap(LocationType type, GameCollection gameCollection) {
        AbstractGameMap obj = null;

        switch (type) {
            case FS: {
                obj = new FSGameMap(gameCollection);
                break;
            }
            case DB: {

                break;
            }
            default:
                throw new IllegalArgumentException("Can't create map type: " + type);

        }

        return obj;
    }
}
