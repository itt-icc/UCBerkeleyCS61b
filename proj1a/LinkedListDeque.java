public class LinkedListDeque<T> {
    /**nested node*/
    private class StuffNode{
        public T item;
        public StuffNode pre;
        public StuffNode next;
        public StuffNode (T i,StuffNode _pre,StuffNode _next) {
            this.item=i;
            this.pre=_pre;
            this.next=_next;
        }
    }

    private int size;
    private StuffNode first;
    private StuffNode last;

    public LinkedListDeque(){
        this.size=0;
        this.first=null;
        this.last=null;
    }


    public void addFirst(T item){
        StuffNode node=new StuffNode(item,null,null);
        node.next=this.first;
        if(isEmpty()){
            this.first=node;
            this.last=node;
        }
        else{
            this.first.pre=node;
            this.first=node;
        }
        this.size++;
    }

    public void addLast(T item){
        StuffNode node=new StuffNode(item,null,null);
        node.pre=this.last;
        if(isEmpty())
            this.first=node;
        else
            this.last.next=node;
        this.last=node;
        this.size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return this.size;
    }
    public void printDeque(){
        StuffNode cur=first;
        System.out.print(cur.item);
        cur=cur.next;
        while(cur!=null){
            System.out.print(" "+cur.item);
            cur=cur.next;
        }
    }

    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        size--;
        StuffNode cur=first;
        this.first=first.next;
        first.pre=null;
        return cur.item;
    }

    public T removeLast(){
        if(this.isEmpty()){
            return null;
        }
        size--;
        StuffNode cur=last;
        this.last=last.pre;
        last.next=null;
        return cur.item;
    }

    public T get(int index){
        if(isEmpty()||index>size-1)return null;
        StuffNode cur=first;
        for(int idx=0;idx!=index&&idx<size;++idx){
            cur=cur.next;
        }
        return cur.item;
    }

    public T getRecursive(int index){
        if(isEmpty()||index>size-1)return null;
        /*base case*/
        return getRecursive(0, index, first);
    }

    private T getRecursive(int idx,int index,StuffNode X) {
        if(idx==index)
            return X.item;
        return getRecursive(idx+1,index,X.next);
    }
//    public static void main(String[] arg){
//        LinkedListDeque<Integer> D =new LinkedListDeque();
//        for(int i=0;i<5;i++){
//            D.addFirst(i);
//        }
//        for(int i=100;i<105;i++){
//            D.addLast(i);
//        }
//        D.printDeque();
//        D.removeFirst();
//        D.removeLast();
//        System.out.println();
//        D.printDeque();
//        System.out.print("\n"+D.getRecursive(7));
//        System.out.print("\n"+D.size());
//        LinkedListDeque<String> D =new LinkedListDeque();
//        D.addFirst("first");
//        D.addFirst("second");
//        D.addFirst("third");
//        D.printDeque();
//    }

}
