package vm;

import storage.PhyMemory;
import java.util.*;

public class VirtMemory extends Memory {

	private static final PhyMemory ram = null;
	Hashtable hash = new Hashtable();
	public VirtMemory() {
		super(ram);
		
	}

	@Override
	public void write(int addr, byte value) {
		hash.put(addr, value);
	}

	@Override
	public byte read(int addr) {
		return (byte) hash.get(addr);
	}

	@Override
	protected void sync_to_disk() {
		
	}
	
}
