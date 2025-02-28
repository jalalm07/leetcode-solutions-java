class MyHashMap {

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;

    private static final float LOAD_FACTOR_THRESHOLD = 0.75f;

    private int size;
    private int capacity;
    private Node[] buckets;

    public MyHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
        this.buckets = new Node[DEFAULT_CAPACITY];
    }

    public void put(int key, int value) {
        // Compute the index in the bucket array
        int index = getBucketIndex(key);

        // Head of the linked list at the computed index
        Node head = buckets[index];
        Node current = head;

        // Traverse to see if key already exists in the chain
        while (current != null) {
            if (current.key == key) {
                // Key found: update the value
                current.value = value;
                return; // We can exit since we've updated it
            }
            current = current.next;
        }

        // If key not found, create a new node and add it to the front of the chain
        Node newNode = new Node(key, value);
        newNode.next = head; // new node's next will point to existing head
        buckets[index] = newNode; // new node becomes the new head
        size++;

        // Check if we need to resize
        if ((1.0 * size) / capacity >= LOAD_FACTOR_THRESHOLD) {
            resize();
        }
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        Node current = buckets[index];

        // Traverse the linked list at that index
        while (current != null) {
            // Check if keys match
            if (current.key == key) {
                return current.value; // Return the value
            }
            current = current.next;
        }
        // Key not found
        return -1;
    }

    public void remove(int key) {
        int index = getBucketIndex(key);
        Node current = buckets[index];
        Node prev = null;

        // Traverse the linked list
        while (current != null) {
            if (current.key == key) {
                // Found the node to remove
                if (prev == null) {
                    // It's the head node
                    buckets[index] = current.next;
                } else {
                    // It's a middle or tail node
                    prev.next = current.next;
                }
                size--;
            }
            prev = current;
            current = current.next;
        }
    }

    private int getBucketIndex(Integer key) {
        if (key == null) {
            // Handle null keys in some consistent manner
            // For example, always put null key into index 0
            return 0;
        }
        return Math.abs(key.hashCode()) % capacity;
    }

    private void resize() {
        // Keep a reference to the old buckets
        Node[] oldBuckets = buckets;
        int oldCapacity = capacity;

        // Double the capacity
        capacity = 2 * oldCapacity;
        // Create a new bucket array
        buckets = new Node[capacity];
        // Reset size to 0; we'll re-insert all existing nodes
        size = 0;

        // Rehash all items from oldBuckets into the new array
        for (int i = 0; i < oldCapacity; i++) {
            Node current = oldBuckets[i];
            while (current != null) {
                // Put each entry into the new array
                put(current.key, current.value);
                current = current.next;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */