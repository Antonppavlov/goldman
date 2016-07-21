package ru.coldman.game.creators;


import ru.coldman.game.abstracts.AbstractGameMap;
import ru.coldman.game.enums.LocationType;
import ru.coldman.game.objects.maps.FSGameMap;

public class MapCreator {

    private static MapCreator instance;

    public static MapCreator getInstance() {
        if (instance == null) {
            instance = new MapCreator();
        }
        return instance;
    }

    public AbstractGameMap createMap(LocationType type) {
        AbstractGameMap obj = null;

        switch (type) {
            case FS: {
                obj = new FSGameMap();
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
