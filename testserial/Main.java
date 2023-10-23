package testserial;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {
        Entity2D ent_1 = new Entity2D(" test1 ", 0.0f, 0.0f);
        ent_1.putItem(5);
        ent_1.putItem(7);
        ent_1.putItem(-1);
        ObjectOutputStream oos = null;

        // Writing into a file
        try {
            FileOutputStream fichier = new FileOutputStream("donnees.ser");
            oos = new ObjectOutputStream(fichier);
            oos.writeObject(ent_1);
            oos.flush();
            oos.close();
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        // How long is the file 8
        File saved = new File("donnees.ser");
        System.out.println("Taille du fichier : " + saved.length() + " octets ");

        // Writing into a file
        try {
            FileOutputStream fichier = new FileOutputStream("donnees.ser");
            oos = new ObjectOutputStream(fichier);
            ent_1.writeExternal(oos);
            oos.flush();
            oos.close();
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        // How long is the file 8
        File saved2 = new File("donnees.ser");
        System.out.println("Taille du fichier : " + saved2.length() + " octets ");

        // Writing into a file
        try {
            FileOutputStream fichier = new FileOutputStream("donnees.ser");
            oos = new DataOutputStream(fichier);
            ent_1.toBytes(oos);
            oos.flush();
            oos.close();
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();

        }

        // How long is the file 8
        File saved3 = new File("donnees.ser");
        System.out.println("Taille du fichier : " + saved3.length() + " octets ");
    }
}
