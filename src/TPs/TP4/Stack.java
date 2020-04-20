package TPs.TP4;

/**********************************************************************************************************************
 ************** @author Grupo 6 : Agustina Abalo, Tomas Berretta, Pedro Bogunovich, Tomas Bruno************************
 *********************************************************************************************************************/

public class Stack<T> {
    Node<T> top;
    int size;

    public Stack(){
        empty();
    }

    public void push (T newData){
        Node<T> node1 = new Node<>(newData);
        node1.pointer = top;
        top = node1;
        size++;
    }

    public void pop (){
        top = top.pointer;
        size--;
    }

    public T peek(){
        return top.data;
    }

    public boolean isEmpty (){
        return (size == 0);
    }

    public void empty (){
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

}
