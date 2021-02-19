package Stacks;

import java.util.ArrayList;

public class ArrayImplement<T> implements Stack<T> {

    private T[] arr;

    private int total;

    public ArrayImplement()
    {
        arr = (T[]) new Object[2];
    }

    private void resize(int capacity)
    {
        T[] tmp = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, tmp, 0, total);
        arr = tmp;
    }

    public ArrayImplement<T> push(T ele)
    {
        if (arr.length == total) resize(arr.length * 2);
        arr[total++] = ele;
        return this;
    }

    public T pop()
    {
        if (total == 0) throw new java.util.NoSuchElementException();
        T ele = arr[--total];
        arr[total] = null;
        if (total > 0 && total == arr.length / 4) resize(arr.length / 2);
        return ele;
    }
    
//    public T peek()
//    {
//    	
//    }

    @Override
    public String toString()
    {
        return java.util.Arrays.toString(arr);
    }
    public static void main(String Args[])
    {
    	
//    		System.out.println(tc.push(“quarter”));
//    		System.out.println(tc.push(“dime”));
//    		System.out.println(tc.push(“nickel”));
//    		System.out.println(tc.push(“penny”));
//    		System.out.println( “toString() “ + tc);
//    	//	System.out.println( “peek() “ + tc.peek());
//    		System.out.println( “search for dime “ + tc.search(“dime”));
//    		System.out.println( “search for euro “ + tc.search(“euro”));
//    		System.out.println( “Size “ + tc.size());
//    		System.out.println(“pop() and isEmpty()”);
//    		while (!tc.isEmpty())
//    		System.out.println(tc.pop());
//    		
    }

}
