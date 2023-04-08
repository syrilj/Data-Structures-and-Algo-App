package mylib.datastructures.nodes;

public class SNode {

        public String data;
        private SNode next;
        public SNode(String data) {
            this.data = data;
            this.next = null;
        }
        public void setNextNode(SNode node) {
            this.next = node;
        }
        public SNode getNextNode() {
            return this.next;
        }

}

