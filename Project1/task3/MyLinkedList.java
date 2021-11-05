import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList implements Iterable<Block> {

    
   //NODE SECTION
    class Node{
        Block block;
        Node next = null;
        Node prev = null;
       
        public Node(Block block){
            this.block = block;
        }
    }

    Node head, tail = null;  
    public static int length;
    public static int blockSizeTotal = 0;
    public boolean canSplit = false;
    

    //CONSTRUCT EMPTY LIST
    public MyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    //ADD NODE TO END OF LIST -> NODE CONTAINS BLOCK DATA
    public void addNodeToEnd(Block block){
         
        Node newNode = new Node(block);
        if (head == null){ 
            head = tail = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            tail.block.setBlockOffset(tail.prev.block.getBlockOffset()+tail.prev.block.getBlockSize());  //set the newNodes offset = the value of the offset + size of the previous node
        }
    length++;
    blockSizeTotal += newNode.block.getBlockSize();
    }

    //ADD NODE AFTER ANOTHER NODE(TARGET) -> NODE CONTAINS BLOCK DATA
    public void addBlockAfterNode(Node target, Block block){
        Node temp = head;
        Node newNode = new Node(block);

        if (temp == null){
            head = tail = newNode;
        }
        else{
            while (temp != null){    //iterate through list until temp = target I wish to add after

                if (temp == target && target.next != null){ 
                   newNode.next = target.next;
                   target.next.prev = newNode;
                   newNode.prev = target;
                   target.next = newNode;
                }
                else{
                    addNodeToEnd(block);
                }

                temp = temp.next;
            }
        }
        length++;
        blockSizeTotal += newNode.block.getBlockSize();
    }

    //DELETE A NODE
    public void removeNode(Node target){
        blockSizeTotal -= target.block.getBlockSize();
        if (target.prev != null){
            target.prev.next = target.next;
        }
        else{
            head = target.next;
        }
        if (target.next != null){
            target.next.prev = target.prev;
        }
        else{
            tail = target.prev;
        }
        length--;
    }
    //CHECK IF LIST IS EMPTY
    public boolean isEmpty(){
        if (length == 0){
            return true;
        }
        else{
        return false;
        }
    }
    //GET TOTAL BLOCK SIZE IN LIST -- MIGHT NOT NEED
    public int totalBlockSize(){
        return blockSizeTotal;
    }
    //CHECK IF THE BLOCK IS SPLITTABLE -> IF TRUE, SPLIT BLOCK
    public void splitMayDelete(Node target, int size){
        int newBlockOffset;
       
        int oldBlockSize;

        this.canSplit = false;
        if (target.block.getBlockSize() > size){
            this.canSplit = true;
        }
        if (target.block.getBlockSize() == size){
           this.canSplit = false;
        }
        if (this.canSplit == true){
            newBlockOffset = target.block.getBlockOffset(); // set new block = old block offset
            oldBlockSize = target.block.getBlockSize();  //set
  
            target.block.setBlockSize(oldBlockSize-size);
            target.block.setBlockOffset(newBlockOffset+size);       
            //addBlockAfterNode(target.prev, newBlock);
        }

        

    }
    //RETURN NODE ELEMENT OF A BLOCK
    public Node getNode(Block block){
        Node temp = head;
        Node current = null;
        if (temp == null){
            return null;
        }
        while(temp != null){ 
            if (temp.block == block){
                current = temp;
            }
            temp = temp.next;
        }
    
        return current;
    }
    //MERGE BLOCKS
    public void insertMayCompact(){

    }
    //PUT LIST TO STRING

    public String toString(){
        String result = "";
            Node current = head;
            if(current == null){
                return "EMPTY";
            }
            
            while(current != null){
                result += current.block.toString();
                if(current.next != null){
                     result += "->";
                }
                current = current.next;
            }
            return "List: " + result;
    }



    //FIND LARGEST NODE
    public int findLargestNumber(){
        Node current = head;
        int max;

        if (head == null){
            return 0;
        }
        max = head.block.getBlockSize();
        while (current != null){
            if (max < current.block.getBlockSize()){
                max = current.block.getBlockSize();
            }
            current = current.next;
        }
        return max+1;
    }

    //SORT
    public void swap(Block lhs, Block rhs){
        ByOffset comparator = new ByOffset();
        if (lhs == rhs){
            return;
        }
        
        if(comparator.compare(lhs, rhs) > 0){
            Node temp = getNode(lhs).next;
            getNode(lhs).next = getNode(rhs).next;
            getNode(rhs).next = temp;
        }
    }
       
      
   
    

   




//ITERATOR SECTION------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public Iterator<Block> iterator() {
        return new BlockIterator();
    }
    private class BlockIterator implements Iterator<Block> {
       // private Node current = head;
        Node nextNode;

       public BlockIterator(){
           nextNode = head;
       }

        @Override
        public boolean hasNext() {
           // return current != null; 
           return nextNode != null;
        }

        @Override
        public Block next() {
            if (!hasNext()) {
            throw new NoSuchElementException();
        }
            Block block = nextNode.block;
            nextNode = nextNode.next;
            return block;
        }
    }   
}
