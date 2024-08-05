/*
* LRU Cache https://leetcode.com/problems/lru-cache/description/
*/

class Node {
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int data, int value) {
        this.key = data;
        this.value = value;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    //add after head
    //encache operation
    public Node addNode(int data, int value) {
        Node newNode = new Node(data, value);
        newNode.next = head.next;
        newNode.prev = head;
        Node temp = head.next;
        temp.prev = newNode;
        head.next = newNode;
        return newNode;
    }

    //delete before tail
    //decache opeartion
    public int deleteNode(Node n) {
        Node next = n.next;
        Node prev = n.prev;
        next.prev = prev;
        prev.next = next;
        return n.key;
    }
}

class LRUCache {
    int maxCap;
    DoublyLinkedList doublyLinkedList;
    HashMap<Integer, Node> hashMap;

    public LRUCache(int capacity) {
        this.maxCap = capacity;
        this.doublyLinkedList = new DoublyLinkedList();
        this.hashMap = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(this.hashMap.get(key) != null) {
            //key found
            Node currNode = this.hashMap.get(key);
            this.doublyLinkedList.deleteNode(currNode);
            Node newNode = this.doublyLinkedList.addNode(currNode.key, currNode.value);
            this.hashMap.put(key, newNode);
            return currNode.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.hashMap.get(key) == null) {
            if(this.hashMap.size() == this.maxCap){
                int key1 = this.doublyLinkedList.deleteNode(this.doublyLinkedList.tail.prev);
                this.hashMap.remove(key1);
            }
            Node newNode = this.doublyLinkedList.addNode(key, value);
            this.hashMap.put(key, newNode);
        }else{
            Node currNode = this.hashMap.get(key);
            this.doublyLinkedList.deleteNode(currNode);
            Node newNode = this.doublyLinkedList.addNode(key, value);
            this.hashMap.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
