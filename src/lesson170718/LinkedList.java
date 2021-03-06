package lesson170718;

/**
 * Created by User on 19.07.2017.
 */
public class LinkedList<E> {

    static class Node<E>{
        E item;
        Node<E> next;
    }

    Node<E> first;
    Node<E> last;

    public void add(E item){

        Node<E> node = new Node<>();

        node.item = item;
        node.next = null;

        if(first==null){
            first = node;
        }else{
            last.next = node;
        }

        last = node;
    }
    public void print(){
        Node<E> current = first;
        while (current != null){
            System.out.println(current.item);
            current = current.next;
        }
    }

    public static void main(String[] args) {

    }

}
