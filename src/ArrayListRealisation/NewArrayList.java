package ArrayListRealisation;

import java.util.*;

public class NewArrayList<E> extends AbstractList<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    Object[] elements;
    private int size;


    public NewArrayList() {
        this.elements = EMPTY_ELEMENTDATA;
    }


    //конструктор принимающий другую колекцию в качестве параметра
    //Представляет эту коллекцию в виде массива, изменяет размер коллекции на длинну этого массива и если размер не равен нулю то
    // создает новый массив
    public NewArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        size = a.length;
        if (size != 0) {
            elements = Arrays.copyOf(a, size, Object[].class);
        } else {
            elements = EMPTY_ELEMENTDATA;
        }
    }

    public NewArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    //метод получение элемента из коллекции
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    //метод checkIndex принимает индекс элемента и выбрасывает исключение в случаях если:
    // индекс меньше нуля или индекс превышает размер коллекции
    private void checkIndex(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Индекс обращения: " + index + ", Размер коллекции " + size);
        }
    }

    //метод добавления элемента в коллекцию
    public boolean add(E e) {
        if (size == elements.length)
            elements = ensureCapacity();
        elements[size] = e;
        size++;
        return true;
    }

    //метод добавления другой коллекции в конец текущей
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] eData;
        final int s;
        if (numNew > (eData = this.elements).length - (s = size))
            eData = grow(s + numNew);
        System.arraycopy(a, 0, eData, s, numNew);
        size += numNew;
        return true;
    }

    //метод увеличения размера коллекции
    public Object[] ensureCapacity() {
        return grow(size + 1);
    }

    //вспомогательный метод для увеличения размера коллеции
    private Object[] grow(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > 0 || elements != EMPTY_ELEMENTDATA) {
            int newCapacity = oldCapacity + (oldCapacity /2);
            return elements = Arrays.copyOf(elements, newCapacity);
        }else {
            return elements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    //метод удаления элемента
    public E remove(int index) {
        checkIndex(index);
        E oldValue = get(index);
        final int removeNum;
        if ((removeNum = size - 1) > index)
            System.arraycopy(elements, index + 1, elements, index, removeNum - index);
        elements[--size] = null;
        return oldValue;
    }

    public static <T extends Comparable<? super T>> void bubbleSort(NewArrayList<T> list) {
        boolean sorted;
        for (int i = 0; i < list.size() - 1; i++) {
            sorted = true;
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    public E set(int index, E element) {
        checkIndex(index);
        elements[index] = element;
        return element;
    }

}
