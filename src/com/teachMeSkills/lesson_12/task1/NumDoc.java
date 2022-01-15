package com.teachMeSkills.lesson_12.task1;

class NumDoc {


    static String checkNumDoc(String str) {

        String infoNumb = "";

        if (str.length() != 15) {
            infoNumb = "Не валиден: Длина номера документа должна быть 15 символов";
        } else if (!((str.contains("docnum")) || (str.contains("сontract")))) {
            infoNumb = "Не валиден: Номер документа не содержит docnum или сontract";
        } else {
            infoNumb = "Валиден";
        }

        return infoNumb;

    }

}
