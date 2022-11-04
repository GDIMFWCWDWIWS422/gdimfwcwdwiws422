package gdi;

public class BinaryTree {
    Node root;
    void add(int value) {
        if(isEmpty()) {
            root = new Node();
            root.value = value;
        } else {
            root.add(value);
        }        
        
    }
    
    void remove(int value) {
        if(!isEmpty()) {
            if(value == root.value) {
                if(root.left == null) {
                    root = root.right;
                    if(root != null) {
                        root.parent = null;
                    }
                }
                else if(root.right == null) {
                    root = root.left;
                    root.parent = null;
                }
                else {
                    int min = root.right.min();
                    root.remove(min);
                    root.value = min;
                }
            } else {
                root.remove(value);
            }
        }
    }
    
    boolean contains(int value) {
        return false; // TODO
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    class Node{
        int value;
        Node left;
        Node right;
        Node parent;
        
        void add(int value) {
            if(value <= this.value) {
                if(this.left == null) {
                    left = new Node();
                    left.value = value;
                    left.parent = this;
                } else {
                    left.add(value);
                }
            } else {
                if(this.right == null) {
                    right = new Node();
                    right.value = value;
                    right.parent = this;
                } else {
                    right.add(value);
                }
            }
            
        }

        public void remove(int value) {
            if(value <= this.value) {
                if(value == left.value) {
                    if(left.left == null) {
                        left = left.right;
                        if(left != null) {
                            left.parent = this;
                        }
                    }
                    else if(left.right == null) {
                        left = left.left;
                        left.parent = this;
                    }
                    else {
                        int min = left.right.min();
                        left.remove(min);
                        left.value = min;
                    }
                } 
                else {
                    left.remove(value);
                }
            }
            else {
                if(value == right.value) {
                    if(right.left == null) {
                        right = right.right;
                        if(right != null) {
                            right.parent = this;
                        }
                    }
                    else if(right.right == null) {
                        right = right.left;
                        right.parent = this;
                    }
                    else {
                        int min = right.right.min();
                        right.remove(min);
                        right.value = min;
                    }
                }
                else {
                    right.remove(value);
                }
            }
        }

        public int min() {
            if(left == null) {
                return value;
            } else {
                return left.min();
            }
        }
    }    
}
