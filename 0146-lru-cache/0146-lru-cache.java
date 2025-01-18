class LRUCache {

    private int capacity;
    private Node left;
    private Node right;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(-1 ,-1);
        this.right = new Node(-1, -1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            left.next.prev = temp;
            temp.next = left.next;
            left.next = temp;
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            temp.val = value;
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            left.next.prev = temp;
            temp.next = left.next;
            left.next = temp;
        } else {
            if(cache.size() == this.capacity){
                Node temp = right.prev;
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                cache.remove(temp.key);
            }
            Node newNode = new Node(key, value);
            newNode.prev = left;
            left.next.prev = newNode;
            newNode.next = left.next;
            left.next = newNode;
            cache.put(key, newNode);
        }
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */