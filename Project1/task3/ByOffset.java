import java.util.Comparator;

public class ByOffset implements Comparator<Block>{

    /**
     *
     */
    private static final int COMPARE = Integer.compare(lhs.offset, rhs.offset);

    @Override
    public int compare(Block lhs, Block rhs) {
        return COMPARE;
    }

}