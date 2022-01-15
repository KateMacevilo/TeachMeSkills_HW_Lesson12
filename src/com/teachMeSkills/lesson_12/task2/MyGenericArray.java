package com.teachMeSkills.lesson_12.task2;


import java.util.Arrays;

public class MyGenericArray<T> {

    private Object[] arrayObj;
    private Object[] newArrayObj;

    MyGenericArray(int length) {
        arrayObj = new Object[length];
    }

    MyGenericArray() {
        arrayObj = new Object[5];
    }

    public T get(int index) {
        return (T) arrayObj[index];
    }

    public void set(int index, T element) {

        if (arrayObj.length == index) {
            arrayObj = extendArray(index);
            arrayObj[index] = element;
        } else {
            arrayObj[index] = element;
        }

    }

    private Object[] extendArray(int index) {

        int size = (index * 3) / 2 + 1;
        newArrayObj = new Object[size];
        newArrayObj = Arrays.copyOf(arrayObj, size);
        System.out.println(Arrays.toString(newArrayObj));
        return newArrayObj;

    }

    public void delete(int index) {

        arrayObj[index] = null;
        for (int i = index + 1; i < arrayObj.length; i++) { //переписываю все элементы внутри массива, чтобы не было дырок
            arrayObj[i - 1] = arrayObj[i];
            arrayObj[i] = null;
        }

    }

    public T clearArray() {

        for (int i = 0; i < arrayObj.length; i++) {
            arrayObj[i] = null;
        }
        return (T) arrayObj;

    }

    public boolean isExistElement(T element) {

        boolean result = false;
        for (int i = 0; i < arrayObj.length; i++) {

            if (arrayObj[i] == null) {
                break;
            }

            if (arrayObj[i].equals(element)) {
                result = true;
                break;
            } else {
                result = false;
            }
        }
        return result;

    }

    public int lengthArray() {
        return arrayObj.length;
    }


    @Override
    public String toString() {
        return "arrayObj=" + Arrays.toString(arrayObj);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyGenericArray<?> that = (MyGenericArray<?>) o;
        return Arrays.equals(arrayObj, that.arrayObj) &&
                Arrays.equals(newArrayObj, that.newArrayObj);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(arrayObj);
        result = 31 * result + Arrays.hashCode(newArrayObj);
        return result;
    }

}
