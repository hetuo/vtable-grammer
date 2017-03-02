package cs652.j.semantics;

import org.antlr.symtab.GlobalScope;
import org.antlr.symtab.Type;

public class ComputeTypes extends JBaseListener {
	protected StringBuilder buf = new StringBuilder();

	public static final Type JINT_TYPE = new JPrimitiveType("int");
	public static final Type JFLOAT_TYPE = new JPrimitiveType("float");
	public static final Type JSTRING_TYPE = new JPrimitiveType("string");
	public static final Type JVOID_TYPE = new JPrimitiveType("void");

	public ComputeTypes(GlobalScope globals) {
		//this.currentScope = globals;
	}

	// ...

	// S U P P O R T

	public String getRefOutput() {
		return buf.toString();
	}
}

