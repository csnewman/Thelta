package com.error22.thelta.virtualsystem.java;

public class JavaSystem {

	// JavaProgram program = new JavaProgram();
	// loadFile(program,
	// "C:\\Users\\chand\\eclipse-workspace\\JBIOS\\bin\\jbios\\JBIOS.class");
	//
	// ExternalManager manager = program.getExternalManager();
	// program.addClass(new ExternalClass(program, "java/lang/Object", null, new
	// String[0], null, null, null));
	//
	// manager.defineExternalClass("hw/GPU", null, null, null);
	//
	// MethodSignature fillRect = new MethodSignature("hw/GPU", "fillRect",
	// PrimitiveType.Void, PrimitiveType.Int,
	// PrimitiveType.Int, PrimitiveType.Int, PrimitiveType.Int, PrimitiveType.Int);
	// manager.defineHook(fillRect);
	// manager.bindHook(fillRect, sf -> {
	//
	// System.out.println("[GPU] Fill rect - x=" + sf.getLocal(0).getValue() + " y="
	// + sf.getLocal(1).getValue()
	// + " width=" + sf.getLocal(2).getValue() + " height=" +
	// sf.getLocal(3).getValue() + " color="
	// + sf.getLocal(4).getValue());
	//
	// sf.exit(null);
	// });
	//
	// manager.defineExternalClass("hw/Debug", null, null, null);
	//
	// MethodSignature print = new MethodSignature("hw/Debug", "print",
	// PrimitiveType.Void, StringType.INSTANCE);
	// manager.defineHook(print);
	// manager.bindHook(print, sf -> {
	// System.out.println("[DEBUG] " + sf.getLocal(0).getValue());
	// sf.exit(null);
	// });
	//
	// WrappedClass stringBuilder = new WrappedClass(StringBuilder.class);
	// stringBuilder.define(manager);
	// stringBuilder.bind(manager);
	//
	// JavaMethod entryMethod = program.getMethod(new MethodSignature("jbios/JBIOS",
	// "entry", PrimitiveType.Void));
	// System.out.println(" " + entryMethod);
	//
	// JavaThread thread = new JavaThread(program);
	// thread.callMethod(entryMethod);

	// long start = System.nanoTime();
	// try {
	// while (true)
	// thread.step();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// long taken = System.nanoTime() - start;
	// System.out.println("Took " + (taken / 1000000f) + "ms");

}
