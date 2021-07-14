class MyHashMap {
    List<List<Pair>> list;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList<>();
        for (int i=0;i<10;i++) {
            list.add(new LinkedList<>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int k = key%10; 
        List<Pair> inner = list.get(k);
        Iterator itr = inner.iterator();
        while (itr.hasNext()) {
            Pair p = (Pair)itr.next();
            if (p.k == key) {
                p.v = value;
                return;
            }
        }
        inner.add(new Pair(key, value));
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int k = key%10;
        if (list.get(k).size()==0) {
            return -1;
        } else {
            List<Pair> inner = list.get(k);
            Iterator itr = inner.iterator();
            while (itr.hasNext()) {
                Pair p = (Pair)itr.next();
                if (p.k == key) {
                    return p.v;
                }
            }
            return -1;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int k = key%10;
        List<Pair> inner = list.get(k);
        if (inner.size() == 0) {
            return;
        } else {
            Iterator itr = inner.iterator();
            int i = 0;
            while (itr.hasNext()) {
                Pair p = (Pair)itr.next();
                if (p.k == key) {
                    inner.remove(i);
                    return;
                }
                i++;
            }
        }
        return;
    }
}

class Pair {
    int k;
    int v;
    public Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */