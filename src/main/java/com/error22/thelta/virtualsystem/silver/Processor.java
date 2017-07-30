package com.error22.thelta.virtualsystem.silver;

public class Processor {
	private SilverCore[] cores;

	public Processor(SilverCore[] cores) {
		this.cores = cores;
	}

	public SilverCore getCore(int core) {
		return cores[core];
	}

}
