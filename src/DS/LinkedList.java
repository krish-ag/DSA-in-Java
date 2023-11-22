package DS;

class Link {
    public int data;
    public Link next;
    public Link(int data) {
        this.data = data;
    }

    public void insertElement(int data) {
        this.next = new Link(data);
    }



    public Link find(int item) {
        if (this.data == item) return this;
        if (this.next == null) return null;
        return this.next.find(item);
    }

    @Override
    public String toString() {
        return this.data + " -> " + this.next;
    }
}


class LList {

        private Link first;

        public LList(int[] arr) {
            if (arr.length == 0) return;
            first = new Link(arr[0]);
            addElements(this.first, arr, 1);
        }

        private void addElements(Link link, int[] arr, int position) {
            if (arr.length == position) return;
            link.next = new Link(arr[position]);
            addElements(link.next, arr, position + 1);
        }

//        public void display() {
//            System.out.println(this.first);
//        }

        public String toString() {
            return this.first.toString();
        }

        public void deleteFirst() {
            this.first = this.first.next;
        }

        public Link find(int item){
            return first.find(item);
        }

        public Link delete(int item) {
            Link prev = null;
            Link current = first;
            while (current.data != item) {
                if (current.next == null) return null;
                prev = current;
                current = current.next;
            }
            if (prev == null) {
                first = current.next;

            }
            else prev.next = current.next;

            return current;
        }




}

public class LinkedList {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        LList l = new LList(arr);
        System.out.println(l);
        l.deleteFirst();
        System.out.println(l);
        System.out.println(l.find(4));
        System.out.println(l.delete(4));
        System.out.println(l);


    }
}