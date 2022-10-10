package Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madinasagatova
 */
public class MyOwnQueue implements ArrayQueue{
    private String[] dataStructure;
    private int capacity;
    private int frontElement;
    private int queueSize;
    private int backElement;
     
    
    public MyOwnQueue(int capacity){
        this.dataStructure = new String[capacity];
        this.queueSize = 0;
        this.capacity = capacity;
        this.frontElement = -1;
        this.backElement = -1;
    }
    /**
     * adding the element on the back of the queue
     * @param newElement
     * @return 
     */
    @Override
    public boolean Enqueue(String newElement) {
        if(frontElement == -1){
            frontElement++;
        }
        if (backElement >= capacity-1){
            return false;
        }
      backElement++;
      dataStructure[backElement] = newElement;
      queueSize++;
      return true;
    }

    // Removes an element from the front of the queue
    @Override
    public String Dequeue() {
        if(queueSize == 0){
            return null;
        }
        String toReturn = dataStructure[frontElement];
        dataStructure[frontElement] = null;
        frontElement++;
        queueSize--;
        return toReturn;
    }
    //First element of the queue without removing it
    @Override
    public String First() {
        if(queueSize == 0){
            return null;
        }
        return dataStructure[frontElement];
    }
    //Last element of the queue without removing it
    @Override
    public String Last() {
        if(queueSize == 0){
            return null;
        }
        return dataStructure[backElement];
    }
    //Number of elements in the queue
    @Override
    public int size() {
        return queueSize;
    }
    //True if there is no elements in the queue
    @Override
    public boolean isEmpty() {
        if(queueSize == 0){
            return true;
        }
        return false;
       
    }
    //@Override
    public String toReturn(){
        String toReturn = "[ ";
        for(int i= frontElement; i <= backElement; i++){
            toReturn += dataStructure[i] + " ";
        }
        toReturn += " ]";
        return toReturn;
    }
    
}
