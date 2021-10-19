public class MyMemoryAllocation extends MemoryAllocation {
    
    public MyMemoryAllocation(int mem_size, String algorithm) {
        super(mem_size, algorithm);
       
    }
    String algorithm; //best fit first fit or next fit\
    MyLinkedList free_list;
    MyLinkedList used_List;

    //printing out pieces
    public void print(){}

    public int alloc(int size){
        return size;
    }

    public void free(int address){}

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int max_size() {
        return 0;
    }

 
}
