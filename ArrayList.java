package edu.touro.mco264;

import java.util.*;

public class ArrayList implements List<String> {

    // Private variables are only accessible by methods
    // within the class.
    private int iP;
    private String[] backingStore;

    public ArrayList(){
        this.backingStore = new String[10];
        iP = 0;
    }

    public ArrayList(int initialCapacity){
        this.backingStore = new String[initialCapacity];
        iP = 0;
    }

    private ArrayList(Collection<String> c){
        this.backingStore = new String[c.size()];
        iP = 0;
    }


    @Override
    public int size() { return iP; }


    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public boolean contains(Object o) {
        boolean bool = false;
        for (String s : backingStore) {
            if (s == o) {
                bool = true;
            }
        }
        return bool;
    }


    //Amortized O(1)
    @Override
    public boolean add(String s) {
        if (iP >= backingStore.length){
            ensureCapacity();
        }
        backingStore[iP] = s;
        iP++;
        return true;
    }


    //O(N)
    @Override
    public void add(int index, String element) {
        checkBoundsForException(index, iP - 1);
        // in @Test, iP = 5.
        System.arraycopy(backingStore, index, backingStore, index + 1, iP);
        // then "C" is inserted at index 2
        backingStore[index] = element;
        iP++;
    }


    //O(1)
    @Override
    public String set(int index, String element) {
        checkBoundsForException(index, iP - 1);
        String oldElement = backingStore[index];
        backingStore[index] = element;
        return oldElement;
    }


    //O(1)
    @Override
    public String get(int index) {
        checkBoundsForException(index,iP);
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(String.format("Index [%d] is not in bounds. Size = [%d]",
                    index, size()));

        return backingStore[index];
    }


    // O(N)
    @Override
    public String remove(int index) {
        checkBoundsForException(index, iP);
        String removedElement = backingStore[index];
        System.arraycopy(backingStore, index + 1, backingStore, index, iP - 1);
        iP--;
        return removedElement;
    }


    // O(N)
    // Removes the first occurrence of the specified element
    // from this list, if it is present. If the list does not
    // contain the element, it is unchanged.
    @Override
    public boolean remove(Object o)  {
        for(int i = 0; i < iP; i++){
            if((o==null ? get(i)==null : o.equals(get(i)))){
                remove(i);
                i--;
            }
        }
        return true;
    }


    @Override
    public int indexOf(Object o) {
        for(int indexCount = 0; indexCount < backingStore.length; indexCount++){
            if(o.equals(backingStore[indexCount])){
                return indexCount;
            }
        }
        return - 1;
    }


    @Override
    public void clear() {
        backingStore = new String[10];
        iP=0;
    }


    // returns the highest index i, such that
    // (o==null ? get(i)==null : o.equals(get(i))),
    // or -1 if there is no such index.
    @Override
    public int lastIndexOf(Object o) {
        for(int i = iP; i >= 0; i--){
            if((o==null ? get(i)==null : o.equals(get(i)))){
                return i;
            }
        }
        return -1;
    }


    // O(M)
    @Override
    public boolean addAll(Collection<? extends String> collection) {
        ensureCapacity();
        for (String s : collection) {
            add(s);
        }
        return true;
    }


    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        checkBoundsForException(index, iP - 1);
        ensureCapacity();
        for(String s: collection){
            add(index, s);
            index++;
        }
        return true;
    }


    //O(M x N)
    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean bool = false;
        for(Object o: collection){
            bool = contains(o);
        }
        return bool;
    }


    //O(M x N)
    @Override
    public boolean removeAll(Collection<?> c) {
        if(containsAll(c)){ // O(M)
            for(int i = 0; i < iP; i++){
                for(Object o: c){
                    if(backingStore[i].equals(o)){
                        remove(i);
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

    //O(M x N)
    // Removes from this list all of its elements that are
    // not contained in the specified collection.
    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < iP; i++) {
            if(! c.contains(backingStore[i])){ // <---O(N x M)
                remove(i);
                i--;
            }

        }
        return true;
    }


    // For lists, The iterator inherited from Collection returns
    // list elements in order of increasing index, and it's next()
    // method ALWAYS moves "forward" through the list.
    @Override
    public Iterator<String> iterator() {
        return new MyListIterator();
    }

    private class MyListIterator implements Iterator<String>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < iP;
        }

        @Override
        public String next() {
            return backingStore[index++];
        }
    }


    @Override
    public Object[] toArray() {
        Object[] objTemp = new Object[iP];
        System.arraycopy(backingStore, 0, objTemp, 0, iP);
        return objTemp;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public ListIterator<String> listIterator() {
        return null;
    }


    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }


    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }


    private void ensureCapacity() {
        String[] tempCapacity = new String[backingStore.length * 2 + 1];
        System.arraycopy(backingStore, 0, tempCapacity, 0, backingStore.length);
        backingStore = tempCapacity;
    }


    private void checkBoundsForException(int index, int highPoint) {
        if( index < 0){
            throw new IndexOutOfBoundsException("Your index: " + index + " is lower than index 0.");
        }
        else if(index > highPoint){
            throw new IndexOutOfBoundsException("Your index: " + index + " is greater than the arrays size.");
        }
    }

}
