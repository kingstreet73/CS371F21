package vm;

public class MyPageTable {
	private static int INITIAL_SIZE = 10;// placeholder value
	private PageTableEntry[] entries = new PageTableEntry[INITIAL_SIZE];

	private static class PageTableEntry {
		int vpn;
		int pfn;
		boolean dirty;

	}
}
