class Node {
    int key;
    int val;
    Node pre;
    Node next;
    Node (int key, int val) { 
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map ;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = null;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addNodeToHead(node);
            return map.get(key).val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addNodeToHead(node);
        } else {
            if(map.size() == capacity) {
                map.remove(tail.key);
                removeNode(tail);                 
            }
            Node temp = new Node(key, value);
            map.put(key, temp);
            addNodeToHead(temp);
        }
    }
    public void removeNode(Node node) {
         if(node == tail) {
             tail = tail.pre;
             if(tail != null) 
                tail.next = null;
             else {
                head = null;
             }
         } else if(node == head) {
             head = head.next;
             head.pre = null;
         } else {
             Node temp = node.next;
             node.next = null;
             temp.pre = node.pre;
             node.pre = null;
             temp.pre.next = temp;
         }
    }
    public void addNodeToHead(Node node) {
        if(head != null) {
            head.pre = node;
            node.next = head;
            node.pre = null;
        }
        if(head == null) {
            tail = node;            
        }
        head = node;        
    }
}
