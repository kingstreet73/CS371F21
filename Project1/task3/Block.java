public class Block{
    private int offset;
    private int blockSize;
    

    
    /*Create a new Block*/
    public Block(int blockSize, int offset){
        this.blockSize = blockSize;
        this.offset = offset;
    }

    public int getBlockSize(){
        return blockSize;
    }
    public int getBlockOffset(){
        return offset;
    }
    public void setBlockSize(int blockSize){
        this.blockSize = blockSize;
    }

    public void setBlockOffset(int offset){
        this.offset = offset;
    }

    public String toString(){
        return " [" + offset + "," + blockSize +"]"; 
    }

    public boolean is_adjacent(Block other){
        int leftHandside;
        int rightHandside;
        
        if (other.getBlockOffset() > this.offset){
            leftHandside = other.getBlockOffset();
            rightHandside = this.offset + this.blockSize;
        }
        
        else{
            leftHandside = this.offset;
            rightHandside = other.getBlockOffset() + other.getBlockSize();
        }
        
        return leftHandside == rightHandside;
    
    }

}