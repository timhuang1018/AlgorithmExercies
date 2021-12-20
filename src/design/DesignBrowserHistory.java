package design;

public class DesignBrowserHistory {

    private Node current;

    public DesignBrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    public void visit(String url) {
        current.next = new Node(url);
        current.next.pre = current;
        current = current.next;
    }

    public String back(int steps) {
        Node findNode = current.pre;
        while(findNode != null && findNode.pre != null && --steps > 0){
            findNode = findNode.pre;
        }
        if(findNode != null){
            current = findNode;
        }
        return current.url;
    }

    public String forward(int steps) {
        Node findNode = current.next;
        while(findNode != null && findNode.next != null && --steps > 0){
            findNode = findNode.next;
        }
        if(findNode != null){
            current = findNode;
        }
        return current.url;
    }

    static class Node{
        String url;
        Node next;
        Node pre;
        public Node(String url){
            this.url = url;
        }
    }
}
