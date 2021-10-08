public class ArrayDeque<T> {


    private int head;
    private int tail;
    private int capacity;
    private T[]items;
    private int size;


    public ArrayDeque(){
        this.items=(T[])new Object[8];
        this.capacity=items.length;
        this.head=capacity-1;
        this.tail=head;
        this.size=0;
    }
    private void resize(int newCapacity){
        T[]newItems=(T[])new Object[newCapacity];
        for(int i = 0;i<size;i++){
            newItems[i]=items[(head+i)%this.capacity];
        }
        this.head=0;
        this.tail=size-1;
        this.items=newItems;
        this.capacity=newCapacity;
    }

    public void addFirst(T item) {
        if(isEmpty()){
            this.items[head]=item;
            this.size++;
            return;
        }
        if(size==capacity)
            resize(this.capacity*2);
        this.head=(this.head+this.capacity-1)%this.capacity;
        this.items[this.head]=item;
        this.size++;
    }

    public void addLast(T item) {
        if(isEmpty()){
            items[tail]=item;
            size++;
            return;
        }
        if(size==capacity)
            resize(capacity*2);
        tail=(tail+1)%capacity;
        items[tail]=item;
        size++;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(isEmpty())return;
        for(int i=0;i<size-1;i++){
            System.out.print(items[(head+i)%capacity]+" ");
        }
        System.out.print(items[tail]);
    }

    private void resizeDown(){
        double usage=size*1.0/capacity;
        if(usage<0.25&&capacity>=16){
            resize((int)(capacity*0.5));
        }
    }

    public T removeFirst() {
        if(isEmpty())return null;
        T cur=items[head];
        items[head]=null;
        head=(head+1)%capacity;
        size--;
        resizeDown();
        return cur;
    }

    public T removeLast() {
        if(isEmpty())return null;
        T cur=items[tail];
        items[tail]=null;
        tail=(tail-1+capacity)%capacity;
        size--;
        resizeDown();
        return cur;
    }

    public T get(int index) {
        if(isEmpty()||index>=size)return null;
        return items[(head+index)%capacity];
    }

}
