class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        next=null;
    }

    Node(){
        this.data=-1;
        next=null;
    }

}



class MyLinkedList {
    Node head;
    Node tail;

    private int size=0;


    public void display(Node curr){
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println();

    }

    public MyLinkedList() {
        head=new Node();
        tail=head;

        
    }
    
    public int get(int index) {
        if(index<0 || index>=size){
            return -1;
        }

        Node curr=head.next;

        for(int i=0;i<index;i++){
            curr=curr.next;
        }


        return curr.data;
        
    }
    
    public void addAtHead(int val) {
        Node curr=new Node(val);
        
        curr.next=head.next;
        head.next=curr;

        if(size==0){
            tail=curr;
        }


        display(head.next);
        size++;
    }
    
    public void addAtTail(int val) {
        Node curr=new Node(val);
        
        tail.next=curr;
        tail=curr;
        
        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size){
            return ;
        }

        Node curr=head;
        

        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        Node next=curr.next;
        // System.out.println("index is : "+index);
        // System.out.println("length is : "+size);
        
        

        Node insert=new Node(val);

        curr.next=insert;
        insert.next=next;

        if(index==size){
            tail=insert;
        }

        size++;    
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size){
            return;
        }

        Node  curr=head;

        for(int i=0;i<index;i++){
            curr=curr.next;
        }

        Node next=curr.next!=null?curr.next.next:null;

        curr.next=next;
        if(index==size-1){
            tail=curr;
        }



        
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */