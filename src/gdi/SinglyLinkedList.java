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
}
