/**
 * @version May 9, 2019
 * 
 * Class containing methods required to build a linked list
 */
class LinkedList<T> implements LinkedListADT<T> {
    private ListNode<T> front = null;
    private int numberOfNodes = 0; 
    
    /*
     * Returns true if the linked list has no nodes, or false otherwise. Does not take in any arguments
    */
    @Override
    public boolean isEmpty() {
        return (front == null);
    }
    
    /*
    * Deletes all of the nodes in the linked list. Does not return anything nor does it 
    * take in any arguments
    */
    @Override
    public void clear() {
        front = null;
        numberOfNodes = 0;
    }
    
    /*
     * Returns the number of nodes in the linked list and does not take any arguments
    */
    @Override
    public int size() {
        return numberOfNodes;
    }
    
    /*
    * Adds a node to the front of the linked list. Does not take reutn anything
    * but takes a T object
    */
    @Override
    public void addFirst( T element ) {
        front = new ListNode<T>( element, front );
        numberOfNodes++;
    }
    
    /*
    * Returns a reference to the data in the first node, or null if the list is empty.
    * DOes not take in any arguments
    */
    @Override
    public T peekFirst() {
        if ( isEmpty() ) 
            return null;
        
        return front.getData();
    }
    
    /*
    * Removes a node from the front of the linked list (if there is one).
    * Returns a reference to the data in the first node, or null if the list is empty.
    * Does not take in any arguments
    */
    @Override
    @SuppressWarnings("unchecked")
    public T removeFirst() {
        T tempData;
        
        if ( isEmpty() ) 
            return null;
        
        tempData = front.getData();
        front = front.getNext();
        numberOfNodes--;
        return tempData;
    }
    
    /*
     * Returns true if the linked list contains a certain element, or false otherwise. Does 
     * not take in any arguments
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean contains( T key ) {
        ListNode<T> searchNode;
        searchNode = front;
        while ( ( searchNode != null ) && ( !key.equals( searchNode.getData() ) ) ) {
            searchNode = searchNode.getNext();
        }
        return ( searchNode != null );
    }
    
    /*
     * Add an element to the end of the linked list, does not return anything
     */
    @SuppressWarnings("unchecked")
    public void addLast( T element ) {
        if (isEmpty()){
            addFirst(element);
        }
        else{
            ListNode<T> lastNode = front;
            
            while(lastNode.getNext() != null){
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(new ListNode<T>(element));
        }
        numberOfNodes++;
    }
    
    /*
     * Remove an element from the end of the linked list
     */
    @SuppressWarnings("unchecked")
    public T removeLast(){
        ListNode<T> searchNode = front;
        ListNode<T> tempNode; 
        T temp;
        if (isEmpty()){
            return null;
        }
        else if(front.getNext() == null){
            temp = front.getData();
            clear();
        }
        else{
            while(searchNode.getNext().getNext() != null){
                searchNode = searchNode.getNext();
            }
            tempNode = searchNode.getNext();
            temp = tempNode.getData();
            searchNode.setNext(null);
            numberOfNodes--;
            
        }
        return temp;
        
    }
    
    /*
     * Returns a String representation of the linked list and does not have a parameter
     */
    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        ListNode<T> node;
        String linkedList = "FRONT ==> ";
        
        node = front;
        while (node != null) {
            linkedList += "[ " + node.getData() + " ] ==> ";
            node = node.getNext();
        }
        
        return linkedList + "NULL";
    }
}