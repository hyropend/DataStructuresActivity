class Node
{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next=null;
    }
}
public class Test {

    public static Node push(Node head, int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public static void printList(Node head){
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }

        System.out.print("null\n");
    }

    public static int add(Node head, int digit){
        if(head==null)
            return digit;
        int value = add(head.next,digit);
        int sum = head.data+value;
        head.data = sum % 10;
        return sum/10;
    }

    public static Node addDigit(Node head, int digit)
    {
        int carry = add(head, digit);

        if (carry > 0) {
            head = push(head, carry);
        }
        return head;
    }
    public static void main(String[] args)
    {
        //HOCAM ÇALIŞIYOR AMA DEĞERLERİ TERSTEN EKLEMEK GEREKİYOR :D.
        //Bize verilen değeri sona eklemek için traverse ettim böyle oldu.
        Node head = null;
        head = push(head,3);
        head = push(head,9);
        head = push(head,9);
        head = push(head,9);

        int digit=7;
        System.out.println("Added value: "+ digit);
        printList(head);
        head = addDigit(head, digit);
        printList(head);
    }
}