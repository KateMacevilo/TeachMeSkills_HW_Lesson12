package com.teachMeSkills.lesson_12.task1;
/**
 * Программа должна получать имена файлов с номерами документов с консоли: каждая новая строка - это путь к файлу и имя файла.
 * Для завершения ввода списка файлов следует ввести 0.
 * <p>
 * После получения списка документов программа должна обработать каждый документ: вычитать из файла номера документов и провалидировать их.
 * В конце работы создать один файл отчет с выходной информаций: номер документа - комментарий(валиден или не валиден и по какой причине).
 * Пусть каждый файл содержит каждый номер документа с новой строки и в строке никакой другой информации, только номер документа.
 * Валидный номер документа должен иметь длину 15 символов и начинаться с последовательности docnum(далее любая последовательность букв/цифр) или kontract(далее любая последовательность букв/цифр).
 * Учесть, что номера документов могут повторяться в пределах одного файла и так же разные документы могут содержать одни и те же номера документов.
 * Если номера документов повторяются, то повторные номера документов не проверять, не валидировать.
 * <p>
 * <p>
 * Немного технических деталей
 * 1) Считать с консоли список документов: раз список - то это коллекции типа List,
 * никаких других условий нет - значит все имена файлов с консоли сохраняем в структуру данных ArrayList.
 * <p>
 * 2) Номера документов могут повторяться, но повторные документы обрабатывать не надо и валидировать не надо,
 * т.е. по сути дубликаты нам не нужны - значит, надо считать номера документов из файлов
 * и все номера документов сохранять в коллекцию типа Set. Других условий нет, значит можно использовать HashSet.
 * <p>
 * 3) В конце должна быть структура номер документа - комментарий - т.е. эта структура
 * типа ключ-значений,значит это коллекция типа Map.
 * Других условий нет - значит, можно использовать HashMap. Создать такую структуру
 * и уже потом сделать цикл по этой структуре и записать всю информацию из этой мапы в файл-отчет.
 */

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //C:\Users\Катя\Desktop\doc1.txt
        //C:\Users\Катя\Desktop\outValid.txt

        ArrayList<String> listPathFull = getListPath();

        String data;
        String info = "";
        String pathOutValidFile = "C:\\Users\\Катя\\Desktop\\outValid.txt";

        Set<String> listNumDoc = new HashSet<>();
        Map<String, String> docNumMap = new HashMap<>();

        for (String item : listPathFull) {
            try (FileInputStream inFile = new FileInputStream(item);
                 BufferedReader infileBuff = new BufferedReader(new InputStreamReader(inFile));
                 FileOutputStream outValidFile = new FileOutputStream(pathOutValidFile);
                 BufferedWriter outFileBuff = new BufferedWriter(new OutputStreamWriter(outValidFile))) {

                data = infileBuff.readLine();
                if (listNumDoc.add(data)) {
                    info = NumDoc.checkNumDoc(data);
                    docNumMap.put(data, info);
                }

                for (String key : docNumMap.keySet()) {
                    outFileBuff.write(key + " - " + docNumMap.get(key));
                    outFileBuff.newLine();
                }


            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


//        try (FileInputStream inFile = new FileInputStream(path);
//             FileOutputStream outValidFile = new FileOutputStream(pathOutValidFile);
//             FileOutputStream outNotValidFile = new FileOutputStream(pathOutNotValidFile);
//             BufferedReader infileBuff = new BufferedReader(new InputStreamReader(inFile));
//             BufferedWriter outFileBuff = new BufferedWriter(new OutputStreamWriter(outValidFile));
//             BufferedWriter outFileBuff2 = new BufferedWriter(new OutputStreamWriter(outNotValidFile))) {
//
//            while ((data = infileBuff.readLine()) != null) {
//                info = NumDoc.checkNumDoc(data);
//                if (info.isEmpty()) {
//                    outFileBuff.write(data);
//                    outFileBuff.newLine();
//                    outFileBuff.flush();
//                } else {
//                    outFileBuff2.write(data + " - " + info);
//                    outFileBuff2.newLine();
//                    outFileBuff2.flush();
//                }
//                System.out.println(data);
//            }
//
//            System.out.println("Success");
//
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


    }

    static ArrayList<String> getListPath() {

        ArrayList<String> listPath = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String path = "";

        boolean ready = false;
        while (!ready) {
            System.out.println("Укажите путь к файлу");
            path = scanner.next();

            if (!path.contains("0")) {
                listPath.add(path);
            } else {
                ready = true;
            }

        }

        scanner.close();
        return listPath;
    }

}
