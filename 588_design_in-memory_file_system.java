class FileSystem {
    Node root;
    public FileSystem() {
        root = new Node();
    }
    
    public List<String> ls(String path) {
        String[] arr = path.split("/");
        int i=1;
        Node curNode = root;
        while (i<arr.length) {
            if (curNode.children.containsKey(arr[i])) {
                curNode = curNode.children.get(arr[i]);
            } else {
                curNode.children.put(arr[i],new Node());
                curNode = curNode.children.get(arr[i]);
            }
            i++;
        }
        Map<String, Node> innerMap = curNode.children;
        List<String> inner = new LinkedList<>();
        if (curNode.isFile) {
            inner.add(curNode.fileName);
        } else {
            for (String s:innerMap.keySet()) {
                inner.add(s);
            }
            Collections.sort(inner);
        }
        
        
        return inner;
    }
    
    public void mkdir(String path) {
        String[] arr = path.split("/");
        int i=1;
        Node curNode = root;
        while (i<arr.length) {
            if (curNode.children.containsKey(arr[i])) {
                curNode = curNode.children.get(arr[i]);
            } else {
                curNode.children.put(arr[i],new Node());
                curNode = curNode.children.get(arr[i]);
            }
            i++;
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] arr = filePath.split("/");
        int i=1;
        Node curNode = root;
        while (i<arr.length) {
            if (curNode.children.containsKey(arr[i])) {
                curNode = curNode.children.get(arr[i]);
            } else {
                curNode.children.put(arr[i],new Node());
                curNode = curNode.children.get(arr[i]);
            }
            i++;
        }
        curNode.isFile = true;
        curNode.fileName = arr[arr.length-1];
        StringBuffer sb = new StringBuffer(curNode.content);
        sb.append(content);
        curNode.content = sb.toString();
    }
    
    public String readContentFromFile(String filePath) {
        String[] arr = filePath.split("/");
        int i=1;
        Node curNode = root;
        while (i<arr.length) {
            if (curNode.children.containsKey(arr[i])) {
                curNode = curNode.children.get(arr[i]);
            } else {
                curNode.children.put(arr[i],new Node());
                curNode = curNode.children.get(arr[i]);
            }
            i++;
        }
        return curNode.content;
    }
}

class Node {
    String content;
    String fileName;
    boolean isFile;
    Map<String, Node> children;
    public Node() {
        isFile = false;
        fileName = "";
        content = "";
        children = new HashMap<>();
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
