import java.util.Comparator;

public class ByOffset implements Comparator<Block>{

    @Override
    public int compare(Block lhs, Block rhs) {
        return Integer.compare(lhs.offset, rhs.offset);
    }

}