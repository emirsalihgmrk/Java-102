package GenericUse;

import java.util.Arrays;

public class Mylist <T>{
    private T[] list;
    private int capacity = 10;
    public Mylist() {
        this.list = (T[]) new Object[this.capacity];
    }
    public Mylist(int capacity){
        while(this.capacity < capacity){ updateCapacity();}
        this.list = (T[]) new Object[this.capacity];
    }
    public void updateCapacity(){
        this.capacity*=2;
        this.list = Arrays.copyOf(this.list,capacity);
    }

    public int size(){
        int elementCounter = 0;
        for (T t : this.list) {
            if (t != null) elementCounter++;
        }
        return elementCounter;
    }

    public int getCapacity() {
        return this.capacity;
    }
    public void add(T value){
        for (int i = 0;i < capacity;i++) {
            if (this.list[i] == null){
                this.list[i] = value;
                break;
            }
            if (i == capacity-1){
                updateCapacity();
            }
        }
    }
    public T get(int index){
        return this.list[index];
    }
    public void set(int index,T data){
        if (index < 0 || index >= capacity){return;}
        this.list[index] = data;
    }
    public void remove(int index){
        this.list[index] = null;
        while (index + 1 < capacity){
            this.list[index] = this.list[index + 1];
            index++;
        }
    }
    public String toString(){
        for (int i = 1;i <= capacity;i++) {
            if (this.list[i -1] != null)System.out.println(i + "-" + this.list[i - 1]);
        }
        return "";
    }
    public int indexOfData(T data){
        for (int i = 0;i < capacity;i++) {
            if (this.list[i] == data){return i;}
        }
        return -1;
    }
    public int lastIndexOfData(T data){
        for (int i = capacity - 1;i > -1;i--){
            if (this.list[i] == data){return i;}
        }
        return -1;
    }
    public boolean isEmpty(){
        for (T t:this.list) {
            if (t != null){return false;}
        }
        return true;
    }
    public void clear(){
        for (int i = 0;i < capacity;i++) {
            this.list[i] = null;
        }
    }
    public Mylist<T> sublist(int start,int finish){
        Mylist<T> newList = new Mylist<>();
        for (int i = start;i <= finish;i++){
            newList.add(this.list[i]);
        }
        return newList;
    }
    public boolean contains(T data){
        for (T t:this.list) {
            if (data == t){return true;}
        }
        return false;
    }
}
