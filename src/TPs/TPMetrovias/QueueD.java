package TPs.TPMetrovias;


/**
 * @author Tomas Berretta
 **/

public class QueueD<T>{
    Node<T> front;
    Node<T> rear;
    int size;
    int length;

    QueueD(){
        front = null;
        rear = null;
        size = 0;
        length = 0;
    }

    public void enqueue(T newData){
        Node<T> node1 = new Node<>(newData);
        if (size == 0){
            front = node1;
            rear = node1;
            size++;
            length++;
            return;
        }
        rear.pointer = node1;
        rear = rear.pointer;
        size++;
        length++;
    }
    public T dequeue(){
        T toReturn = front.data;
        front = front.pointer;
        size--;
        return toReturn;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public int length(){
       return length;
    }
    public int size(){
        return size;
    }
    public void empty(){
        front = null;
        rear = null;
        size = 0;
        length = 0;
    }
}
