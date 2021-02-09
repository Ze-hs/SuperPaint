/**
 *@version may 9, 2019
 * This class is required to build a dynamic stack
 */

class DynamicStack<T> implements StackADT<T> {
    private LinkedList<T> myList;
    
    /*
     * Creates an empty stack (based on a linked list). It does not take any arguments.
    */
    public DynamicStack() {
        myList = new LinkedList<T>();
    }
    
    /*
    * Takes in and adds the specified element to the top of the stack. Does not return anything
    */
    public void push( T element ) {
        myList.addFirst( element );
    }
    
    /*
    * Removes the element from the top of the stack and returns a reference to it, or null (if empty).
    * Does not have any parameters
    */
    public T pop() {
        return myList.removeFirst(); 
    }
    
    /*
    * Returns a reference to the element at the top of the stack, or null (if empty). Does
    * not have any parameters
    */
    public T peek() {
        return myList.peekFirst();
    }
    
    /* 
     * Returns true if the stack contains no elements, false otherwise. Does not have any parameters
    */
    public boolean isEmpty() {
        return myList.isEmpty();
    }
    
    /*
    * Returns the number of elements in the stack. Does not have any parameters
    */
    public int size() {
        return myList.size();
    }
    
    /*
    * Clears all elements from the stack. Does not have any parameters and does not return anything
    */
    public void clear() {
        myList.clear();
    }
    
    /*
    * Returns a String representation of the stack. Does not have any parameters 
    * and does not return anything
    */
    public String toString() {
        return myList.toString();
    }
}  