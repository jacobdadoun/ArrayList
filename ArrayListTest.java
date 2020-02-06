package edu.touro.mco264;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    //Arrange
    private ArrayList malWare = new ArrayList();

    @org.junit.jupiter.api.Test
    void size() {
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        //Act & Assert
        assertEquals(3, malWare.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        //Assert
        assertTrue(malWare.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains(){
        ArrayList malWare = new ArrayList();
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        //Act & Assert
        assertTrue(malWare.contains("B"));
    }

    @org.junit.jupiter.api.Test
    void add() {
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        assertEquals("D",malWare.get(3));
    }

    @org.junit.jupiter.api.Test
    void addIndex(){
        ///Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("D");
        malWare.add("E");
        malWare.add("F");
        //Act
        malWare.add( 2,"C");
        //Assert
        assertEquals("C", malWare.get(2));
    }

    @org.junit.jupiter.api.Test
    void set(){
        //Arrange
        ArrayList malWare = new ArrayList(5);
        malWare.add("A");
        malWare.add("C");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        //Act
        malWare.set(1, "B");
        //Assert
        assertEquals("B", malWare.get(1));
    }

    @org.junit.jupiter.api.Test
    void get() {
        ArrayList malWare = new ArrayList();
        malWare.add("A");

        assertEquals("A", malWare.get(0));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        // Arrange
        ArrayList malWare = new ArrayList();
        malWare.add("A");
        malWare.add("B");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        //Act
        malWare.remove(2);
        //Assert
        assertEquals("C", malWare.get(2));
    }

    @org.junit.jupiter.api.Test
    void removeObject(){
        //Arrange
        ArrayList malWare = new ArrayList();
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        //Act
        malWare.remove("B");
        //Assert
        assertEquals("C", malWare.get(1));
    }

    @org.junit.jupiter.api.Test
    void indexOf(){
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        //Act & Assert
        assertEquals(2,malWare.indexOf("C"));
    }

    @org.junit.jupiter.api.Test
    void clear(){
        //Arrange
        ArrayList malWare = new ArrayList();
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        //Act
        malWare.clear();
        //Assert
        assertEquals( 0, malWare.size());
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf(){
        //Arrange
        ArrayList malWare = new ArrayList();
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        //Act & Assert
        assertEquals(4 ,malWare.lastIndexOf("B"));
        assertNotEquals(0, malWare.lastIndexOf("A"));
    }

    @org.junit.jupiter.api.Test
    void addAll(){
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        ArrayList coll = new ArrayList();
        coll.add("D");
        coll.add("E");
        //Act
        malWare.addAll(coll);
        //Assert
        assertTrue(malWare.addAll(coll));
        assertEquals(malWare.get(2), "C");
        assertEquals(malWare.get(3), "D");
        assertEquals(malWare.get(4), "E");
    }

    @org.junit.jupiter.api.Test
    void addAllIndex(){
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("E");
        ArrayList coll = new ArrayList();
        coll.add("C");
        coll.add("D");
        //Act
        malWare.addAll(2,coll);
        //Assert
        assertTrue(malWare.addAll(coll));
        assertEquals(malWare.get(2), "C");
        assertEquals(malWare.get(3), "D");
        assertEquals(malWare.get(4), "E");
    }

    @org.junit.jupiter.api.Test
    void containsAll(){
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        ArrayList coll = new ArrayList();
        coll.add("B");
        coll.add("C");
        //Act & Assert
        assertTrue(malWare.containsAll(coll));
    }

    @org.junit.jupiter.api.Test
    void removeAll(){
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        malWare.add("F");
        ArrayList coll = new ArrayList();
        coll.add("B");
        coll.add("C");
        coll.add("D");
        //Act
        malWare.removeAll(coll);
        //Assert
        assertEquals("E",malWare.get(1));
    }

    @org.junit.jupiter.api.Test
    void retainAll(){
        //Arrange
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        malWare.add("F");
        ArrayList coll = new ArrayList();
        coll.add("B");
        coll.add("C");
        coll.add("D");
        //Act
        malWare.retainAll(coll);
        //Assert
        assertEquals("B",malWare.get(0));
        assertEquals("C",malWare.get(1));
        assertEquals("D",malWare.get(2));
    }

    @org.junit.jupiter.api.Test
    void iterator(){
        //Arrange
        ArrayList malWare = new ArrayList(5);
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        //Act
        Iterator<String> iterate = malWare.iterator();
        //Assert
        assertTrue(iterate.hasNext());
        assertEquals("A",iterate.next());
        assertEquals("B",iterate.next());
        assertEquals("C",iterate.next());
        assertEquals("D",iterate.next());
        assertFalse(iterate.hasNext());
    }

    @org.junit.jupiter.api.Test
    void toArray(){
        //Arrange
        ArrayList malWare = new ArrayList(5);
        malWare.add("A");
        malWare.add("B");
        malWare.add("C");
        malWare.add("D");
        malWare.add("E");
        //Act
        malWare.toArray();
        //Assert
        assertEquals(malWare, malWare);
    }
}