package mp4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ObjectPlus implements Serializable {
    public static Map<Class, List> extent = new HashMap<>();

    public void ObjectPlus() {
        //addToExtent();
    }

    public void addToExtent() {
        List list = extent.get(this.getClass());
        if (list == null) {
            list = new ArrayList();
            extent.put(this.getClass(), list);
        }
        list.add(this);
    }

    public void removeFromExtent() {
        List list = extent.get(this.getClass());
        if (list == null) {
            return;
        }
        list.remove(this);
    }

    public static Map<Class, List> getExtent() {
        return Collections.unmodifiableMap(extent);
    }

    public static <E> List<E> getExtent(Class<E> c) {
        List list = extent.get(c);
        if (list == null) {
            return new ArrayList();
        }
        return Collections.unmodifiableList(list);
    }

    public static void saveExtent(ObjectOutputStream oos) throws IOException {
        oos.writeObject(extent);
    }

    public static void loadExtent(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        extent = (Map<Class, List>) ois.readObject();
    }

}
