package testserial;

import java.util.ArrayList;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectInput;

/**
 * Cette classe représente une entité en deux dimensions avec des attributs
 * tels que l'identifiant, le nom, les coordonnées (x, y) et une liste
 * d'éléments. Elle implémente l'interface Externalizable pour personnaliser
 * la sérialisation et la désérialisation de l'objet.
 */

public class Entity2D implements Externalizable {

    private static final long serialVersionUID = 1L;
    public static final int MAX_ITEMS = 10;
    public static int nb_genereted = 0;
    private int id;
    private String name;
    private float x;
    private float y;
    private ArrayList<Integer> items;

    public Entity2D(String name, float x, float y) {

        this.name = name;
        this.x = x;
        this.y = y;
        this.id = nb_genereted;
        nb_genereted++;
        items = new ArrayList<Integer>();

    }

    public static int getNb_genereted() {
        return nb_genereted;
    }

    public static void setNb_genereted(int nb_genereted) {
        Entity2D.nb_genereted = nb_genereted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ArrayList<Integer> getItems() {
        return items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
    }

    public void putItem(int item) {
        if (items.size() < MAX_ITEMS) {
            items.add(item);
        }
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeInt(id);
        out.writeObject(items);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
        x = in.readFloat();
        y = in.readFloat();
        items = (ArrayList<Integer>) in.readObject();
    }

    public void toBytes(DataOutputStream data) throws IOException {
        data.writeByte(id);
        data.writeUTF(name);
        data.writeFloat(x);
        data.writeFloat(y);
        data.writeByte(items.size());
        for (Integer item : items) {
            data.writeInt(item);
        }
    }

    /*
     * public static Entity2D fromBytes(DataInputStream data) {
     * 
     * 
     * }
     */

}