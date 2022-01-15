package com.teachMeSkills.lesson_12.task2;

import java.util.jar.JarOutputStream;

/**
 * Дополнительное задание
 * Представим, что в Java нет коллекции типа ArrayList.
 * Создать свой класс, симулирующий работу класса динамической коллекции - т.е. создать свою кастомную коллекцию.
 * В основе коллекции будет массив.
 * Кастомная коллекция должна хранить элементы разных классов(т.е. это generic).
 * Предусмотреть операции добавления элемента, удаления элемента, получение элемента по индексу, проверка есть ли элемент в коллекции, метод очистки все коллекции.
 * Предусмотреть конструктор без параметров - создает массив размером по умолчанию.
 * Предусмотреть конструктор с задаваемым размером внутреннего массива.
 * Предусмотреть возможность автоматического расширения коллекции при добавлении элемента в том случае, когда коллекция уже заполнена.
 */
public class Main {

    public static void main(String[] args) {

        MyGenericArray<String> arrayString = new MyGenericArray<>(3);
        arrayString.set(0, "It's");
        arrayString.set(1, "12");
        arrayString.set(2, "homework");
        arrayString.set(3, "!");
        arrayString.delete(1);
        System.out.println(arrayString);
        System.out.println("элемент по индексу 2 - " + arrayString.get(2));
        System.out.println("существует ли ! в массиве? - " + arrayString.isExistElement("!"));
        arrayString.clearArray();

        System.out.println(arrayString);

        MyGenericArray<Character> arrayChar = new MyGenericArray<>();
        System.out.println(arrayChar + " length " + arrayChar.lengthArray());

    }

}
