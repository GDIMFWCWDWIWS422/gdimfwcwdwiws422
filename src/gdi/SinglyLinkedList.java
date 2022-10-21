package gdi;

class SinglyLinkedList {
    
    SinglyLinkedListElement root;
    
    boolean isEmpty() {
        return root == null;
        
    /*    if(root == null) {
            return true;
        }
        else {
            return false;
        }*/
        
    }
    boolean contains(int value) {
        if(isEmpty()) {
            return false;
        }
        else {
            SinglyLinkedListElement soufian = root;
        while(soufian!=null && soufian.value!=value) {
            soufian=soufian.next;
        }
        return soufian!=null;
        /*
        if(soufian == null) {
            return false;
        }
        else {
            return true;
        }*/
        }
    }
    void add(int value) {
        if(isEmpty()) {
            root = new SinglyLinkedListElement ();
            root.value = value;
        }
        else {
            SinglyLinkedListElement current = root;
            while (current.next != null) {
                current = current.next;   
            }
            
            current.next = new SinglyLinkedListElement();
            current.next.value = value;
       
        }
    }
    void remove(int value) {
        if(!isEmpty()) {
            if(root.value==value) {
                root=root.next;
            }
            else {
            SinglyLinkedListElement current = root;
            while(current.next!=null && current.next.value!=value) {
                current=current.next;
                
            }
            if(current.next!=null) {
                current.next=current.next.next;
            }
           }
        }
        
    }
}
