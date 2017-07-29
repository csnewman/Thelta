package com.error22.thelta.virtualsystem;

import com.error22.thelta.virtualsystem.silver.SilverCore;
import com.error22.thelta.virtualsystem.silver.SilverSystem;

public class Processor {
	private ICore[] cores;

	public Processor(ICore[] cores) {
		this.cores = cores;
	}

	public ICore getCore(int core) {
		return cores[core];
	}

}
