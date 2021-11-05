

public class MyMemoryAllocation extends MemoryAllocation {
    
    String algorithm; //best fit first fit or next fit
    MyLinkedListcopy free_list = new MyLinkedListcopy(); //create two empty lists
    MyLinkedListcopy used_List = new MyLinkedListcopy();
    public static int blockSizeTotal;

    public MyMemoryAllocation(int mem_size, String algorithm) {
        super(mem_size, algorithm);
        this.algorithm = algorithm;

    
        Block block1 = new Block(mem_size-1, 1);
        free_list.addNodeToEnd(block1);
      
}

    
    //printing out blocks
    public void print(){
       System.out.println("Free " + free_list.toString());
       System.out.println("Used " + used_List.toString());
       System.out.println("");
     }

          
        
    

    //allocates memory with specified size - if memory requested = available, return an address (offset of the beginning of allocated memory, otherwise return 0)
    public int alloc(int size){
        int offset = 0;

        if (this.algorithm == "FF"){   
            //free_list.iterator();
            //PLAN: ITERATE THROUGH FREE LIST FROM LEFT TO RIGHT. IF NODE/BLOCK SIZE >= SIZE_REQUEST, SPLIT THE BLOCK, ELSE KEEP ITERATING.
            // SPLITTING BLOCK WILL TAKE THE BIG ENOUGH BLOCK, CREATE A NEW BLOCK -> 
            while(free_list.iterator().hasNext()){
                if(free_list.iterator().next().getBlockSize() == size){  //if the current node has a block size == size I want, add the node to the used list and delete it from free
                    used_List.addNodeToEnd(free_list.iterator().next());
                    offset = free_list.iterator().next().getBlockOffset();
                    free_list.removeNode(free_list.getNode(free_list.iterator().next()));
                   
                    return offset;
                }
                if(free_list.iterator().next().getBlockSize() > size){   //if current node has block size > size I want, split the node and add the size I want to used list, keep the rest in free

                    Block newBlock = new Block(size, free_list.iterator().next().getBlockOffset());
                    free_list.splitMayDelete(free_list.getNode(free_list.iterator().next()), size);
                    

                    used_List.addNodeToEnd(newBlock);
                    offset = newBlock.getBlockOffset();
                    blockSizeTotal += size;
                    return offset;
                }
                if(size() == 0){
                    return offset = 0;
                }
               free_list.iterator().next();
            }  
        }  


        if(this.algorithm == "BF"){
            if(free_list.iterator().next().getBlockSize() == size){  //if the current node has a block size == size I want, add the node to the used list and delete it from free
                used_List.addNodeToEnd(free_list.iterator().next());
                offset = free_list.iterator().next().getBlockOffset();
                free_list.removeNode(free_list.getNode(free_list.iterator().next()));
               
                return offset;
            }
            for (Block block : free_list) {
                int max = 0;
                int y = block.getBlockSize();
                
            }

            }

            if(this.algorithm == "NF"){
            
            }
             return offset;
           }
        
    

       


    

    //release allocated memory. Must detect if memory is valid / was previously allocated.
    public void free(int addr){
        ByOffset comparator = new ByOffset();
        while(used_List.iterator().hasNext()){
            
            if(used_List.iterator().next().getBlockOffset() == addr){
                
                while(free_list.iterator().hasNext()){
                    if(comparator.compare(free_list.iterator().next(), used_List.iterator().next()) > 0){
                        free_list.addBlockAfterNode((free_list.getNode(free_list.iterator().next()).prev), used_List.iterator().next());
                        break;
                    }
                    free_list.iterator().next();
                }
                used_List.removeNode(used_List.getNode(used_List.iterator().next()));
                break;
            }
            used_List.iterator().next();
           
        }
        return;
    }

    // returns the global size of available memory, it is sum of all available parts of memory.
    @Override
    public int size() {
        int totalSize=0;
        for (Block block : free_list) {
            totalSize += block.getBlockSize();
        }
        return totalSize;
    }

   // returns the size of the biggest available part of memory. It is the biggest size that can be allocated.
    @Override
    public int max_size() {
        return free_list.findLargestNumber();
    }
}

