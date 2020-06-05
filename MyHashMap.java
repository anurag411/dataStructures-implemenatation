class Node {
        
    int key;    
    int val;    
    Node next;   
    Node (int key, int val) {        
        this.key = key;        
        this.val = val;        
        next = null;
    }
}
class MyHashMap {

    /** Initialize your data structure here. */
    Node map[];
    public MyHashMap() {       
        map = new Node[1000];    
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashVal = hash(key);
        if(map[hashVal] == null) {
            Node node = new Node(key, value);
            map[hashVal] = node;
        } else {
            Node node = map[hashVal];
            while(node != null) {
                if(node.key == key) {
                    node.val = value;
                    break;
                }
                if(node.next == null) {
                    Node temp = new Node(key, value);
                    node.next = temp;
                    break;
                }
                node = node.next;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashVal = hash(key);
        if(map[hashVal] == null) {
            return -1;
        }  else {
            Node node = map[hashVal];
            while(node != null) {
                if(node.key == key) {
                    return node.val;
                }
                node = node.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashVal = hash(key);
        if(map[hashVal] != null) {
            Node node = map[hashVal];
            Node head = node;
            Node pre = null;
            while(node != null) {
                if(node.key == key) {
                    if (pre == null ) {
                        node = node.next;
                        map[hashVal] = node;
                        break;
                    } else {
                        pre.next = node.next;
                        node.next = null;
                        map[hashVal] = head;
                        break;
                    }
                }
                pre = node;
                node = node.next;
            }
        }
    }
    private int hash(int key) {
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
