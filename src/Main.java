import ArrayListRealisation.NewArrayList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> lists = new LinkedList<>();
        lists.add("Five");
        lists.add("Six");

        List<Integer> lists2 = new LinkedList<>();
        lists2.add(70);
        lists2.add(80);
        lists2.add(90);
        lists2.add(50);

        //проверка работы конструктора принимающего в себя другую коллекцию
        NewArrayList<String> newArrayList = new NewArrayList<>(lists);

        System.out.println("проверка работы конструктора c коллекцией: ");
        System.out.println(newArrayList);
        System.out.println(" ");


        NewArrayList<Integer> newArrayList2 = new NewArrayList<>();
        newArrayList2.add(20);
        newArrayList2.add(15);
        newArrayList2.add(10);
        newArrayList2.add(5);

        for (int i = 0; i < 3; i++){
            newArrayList2.add(500);
        }


        newArrayList2.addAll(lists2);
        System.out.println("Проверка работы добавления элементов из другой коллекции: ");
        System.out.println(newArrayList2);
        System.out.println(" ");

        System.out.println("получение элемента из коллекции: ");
        System.out.println(newArrayList2.get(3));
        System.out.println(" ");


        System.out.println("удаление элемента из коллекции: ");
        System.out.println(newArrayList2.size());
        newArrayList2.remove(5);
        System.out.println(newArrayList2.size());
        System.out.println(" ");


        System.out.println("Сортировка коллекции: ");
        System.out.println(newArrayList2);
        //сортировка коллекции статическим методом
        NewArrayList.bubbleSort(newArrayList2);
        System.out.println(newArrayList2);












    }
}