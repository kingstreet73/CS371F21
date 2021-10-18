Public class MyMemoryAllocation extends MyMemoryAllocation {
    
    String algorithm; //best fit first fit or next fit\
    MyLinkedList free_list;
    MyLinkedList used_List;

    //printing out pieces
    public void print();
    public int alloc(int size){...}
    ;


}