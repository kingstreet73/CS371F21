package vm;

import storage.PhyMemory;

public class VirtMemory extends Memory {

	public VirtMemory(PhyMemory ram) {
		super(ram);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void write(int addr, byte value) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte read(int addr) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void sync_to_disk() {
		// TODO Auto-generated method stub

	}

}
