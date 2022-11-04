package gdi;

public class AVLTree {
    Node root;
    void add(int value) {
        if(isEmpty()) {
            root = new Node();
            root.value = value;
            root.height = 1;
        } else {
            root.add(value);
            root.updateheight();
        }        
        root = root.balance();
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
        if(!isEmpty()) root = root.balance();
        
    }
    
    boolean contains(int value) {
        return false; // TODO
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    class Node{
        int value;
        int height;
        Node left;
        Node right;
        Node parent;
        
        void add(int value) {
            if(value <= this.value) {
                if(this.left == null) {
                    left = new Node();
                    left.height = 1;
                    left.value = value;
                    left.parent = this;
                } else {
                    left.add(value);
                    left.updateheight();
                }
            } else {
                if(this.right == null) {
                    right = new Node();
                    right.height = 1;
                    right.value = value;
                    right.parent = this;
                } else {
                    right.add(value);
                    right.updateheight();
                }
            }
            this.updateheight();
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
            this.updateheight();
        }

        public int min() {
            if(left == null) {
                return value;
            } else {
                return left.min();
            }
        }
        
        int leftheight() {
            return left==null? 0: left.height;
        }
        
        int rightheight() {
            return right==null? 0: right.height;
        }
        
        void updateheight() {
            int rightheight = rightheight();
            int leftheight = leftheight();
            this.height = (leftheight<rightheight? rightheight: leftheight) + 1;
        }
        
        Node balance() {
            int dif = rightheight() - leftheight();
            if (dif >= 2) {
                int rightdif = right.rightheight() - right.leftheight();
                if (rightdif > 0) {
                    return this.leftrotate();
                }else {
                    right.rightrotate();
                    return this.leftrotate();
                }
            }else if(dif <= -2) {
                int leftdif = left.rightheight() - left.leftheight();
                if (leftdif < 0) {
                    return this.rightrotate();
                }else {
                    left.leftrotate();
                    return this.rightrotate();
                }
            } else {
                return this;
            }
        }
        
        Node leftrotate() {
            Node store = right;
            right = right.left;
            right.parent = this;
            store.parent = this.parent;
            parent = store;
            store.left = this;
            return store;
        }
        
        Node rightrotate() {
            Node store = left;
            left = left.right;
            left.parent = this;
            store.parent = this.parent;
            parent = store;
            store.right = this;
            return store;
        }
        
    }    
}
