package arrays;


/*   В нашей реализации ArrayList (которая называется MyArrayList) реализуйте
самостоятельно такие методы

1) size()  - метод, аналогичный методу size() из обычного arrayList - он возвращет
    реальный размер листа
2) add(index, value) - метод add, только который вставляет значение не в конец списка,
а в любое произвольное место (место задается переменной index)

3) remove(int index) - аналог remove из классического ArrayList - удаляет элемент из
    листа по индексу

    Давайте реализуем методы size(), add(index, value) и remove(int index) для вашей
    MyArrayList на Java:
*/

    import java.util.Arrays;

    public class MyArrayList {
        private int[] array;
        private int size;
        private static final int DEFAULT_CAPACITY = 10;

        public MyArrayList() {
            this.array = new int[DEFAULT_CAPACITY];
            this.size = 0;
        }

        public int size() {
            return size;
        }

        public void add(int value) {
            if (size == array.length) {
                ensureCapacity();
            }
            array[size++] = value;
        }

        public void add(int index, int value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }

            if (size == array.length) {
                ensureCapacity();
            }

            for (int i = size; i > index; i--) {
                array[i] = array[i - 1];
            }

            array[index] = value;
            size++;
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index is out of bounds");
            }

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }

            size--;
        }

        private void ensureCapacity() {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            MyArrayList myArrayList = new MyArrayList();
            myArrayList.add(1);
            myArrayList.add(2);
            myArrayList.add(4);
            myArrayList.add(3);
            myArrayList.print(); // Вывод: 1 2 4 3

            myArrayList.add(2, 5); // Вставляем 5 на позицию 2
            myArrayList.print(); // Вывод: 1 2 5 4 3

            myArrayList.remove(3); // Удаляем элемент на позиции 3
            myArrayList.print(); // Вывод: 1 2 5 3

            System.out.println("Размер: " + myArrayList.size()); // Вывод: Размер: 4
        }
    }

/*    Этот код добавляет методы size(), add(index, value) и remove(int index) к
вашей MyArrayList, позволяя получать размер списка, добавлять элементы по индексу и
удалять элементы по индексу.
public class MyArrayList {

    private int[] array;
    private int size;

    public MyArrayList(){
        array = new int[10];
    }

    public void add(int value){
        if(size == array.length){
            grow();
        }
        array[size] = value;
        size++;
    }

    private void grow(){
        int[] newArray = new int[array.length * 2];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean contains(int element){
        for (int i = 0; i < size; i++) {
            if(array[i] == element){
                return true;
            }
        }
        return false;
    }



    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';

                Написать Продленка (18-020523-e-be)

public void remove(int index){
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        size--;
    }

public void trimToSize(){
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }
    }
}

Написать Продленка (18-020523-e-be)

 */

