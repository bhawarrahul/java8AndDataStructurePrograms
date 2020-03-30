package com.adobe.program.example;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author rahul.bhawar
 */
public class JavaObjectCreationType implements Cloneable, Serializable {
    String name = "Rahul Bhawar";

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException, IOException, ClassNotFoundException {
        //1 - New keyword
        JavaObjectCreationType obj1 = new JavaObjectCreationType();
        System.out.println(obj1.name);

        //2 - Class.NewInstance() Method
        JavaObjectCreationType obj2 = JavaObjectCreationType.class.newInstance();
        System.out.println(obj2.name);

        //3 - Constructor newInstance() Method
        Constructor<JavaObjectCreationType> obj = JavaObjectCreationType.class.getConstructor();
        JavaObjectCreationType obj3 = obj.newInstance();
        System.out.println(obj3.name);

        //4 - Clone object
        JavaObjectCreationType obj4 = (JavaObjectCreationType) obj3.clone();
        System.out.println(obj4.name);

        //5 - Serialization and Deserialization
        final String file = "abc.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(obj4);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        JavaObjectCreationType obj5 = (JavaObjectCreationType) ois.readObject();
        System.out.println(obj5.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
