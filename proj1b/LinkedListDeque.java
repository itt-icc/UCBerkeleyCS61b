public class LinkedListDeque<T> implements Deque<T>{

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
    @Override
    public void addFirst(T item){
        StuffNode node=new StuffNode(item,null,null);
        node.next=this.first;
        if(isEmpty()) this.last=node;
        else this.first.pre=node;
        this.first=node;
        this.size++;
    }
    @Override
    public void addLast(T item){
        StuffNode node=new StuffNode(item,null,null);
        node.pre=this.last;
        if(isEmpty()) this.first=node;
        else this.last.next=node;
        this.last=node;
        this.size++;
    }
    @Override
    public boolean isEmpty(){return size==0;}
    @Override
    public int size(){return this.size; }
    @Override
    public void printDeque(){
        if(isEmpty()) return;
        StuffNode cur=first;
        System.out.print(cur.item);
        cur=cur.next;
        while(cur!=null){
            System.out.print(" "+cur.item);
            cur=cur.next;
        }
    }
    @Override
    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        size--;
        StuffNode cur=first;
        this.first=first.next;
        if(isEmpty())last=null;
        else first.pre=null;
        return cur.item;
    }
    @Override
    public T removeLast(){
        if(this.isEmpty()){
            return null;
        }
        size--;
        StuffNode cur=last;
        this.last=last.pre;
        if(isEmpty())first=null;
        else last.next=null;
        return cur.item;
    }
    @Override
    public T get(int index){
        if(isEmpty()||index>size-1)return null;
        StuffNode cur=first;
        for(int idx=0;idx!=index&&idx<size;++idx){
            cur=cur.next;
        }
        return cur.item;
    }
    @Override
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
    public static void main(String[] arg){
        LinkedListDeque<Integer> D =new LinkedListDeque();
//        for(int i=0;i<5;i++){
//            D.addFirst(i);
//        }
//        for(int i=100;i<105;i++){
//            D.addLast(i);
//        }
//        D.printDeque();
        D.addFirst(0);
        int res = D.removeFirst();
        System.out.println("res = "+res);
        D.printDeque();
        System.out.print("\n"+D.getRecursive(7));
        System.out.print("\n"+D.size());
//        LinkedListDeque<String> D =new LinkedListDeque();
//        D.addFirst("first");
//        D.addFirst("second");
//        D.addFirst("third");
//        D.printDeque();
    }

}
