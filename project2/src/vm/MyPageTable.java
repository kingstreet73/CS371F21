package vm;

public class MyPageTable {
	private static int INITIAL_SIZE = 1024;
	private PageTableEntry[] entries = new PageTableEntry[INITIAL_SIZE];

	private static class PageTableEntry {
		int vpn = 0;
		int pfn = 0;
		
		boolean dirty = false;{
		if(vpn == null && pfn == null)
			dirty = false;
		else 
			dirty = true;
	}
	}
}

