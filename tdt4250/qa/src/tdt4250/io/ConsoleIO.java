package tdt4250.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ConsoleIO extends AbstractIO {

	private PrintStream out;
	private BufferedReader in;
	
	public ConsoleIO(PrintStream out, InputStream in) {
		this.out = out;
		this.in = new BufferedReader(new InputStreamReader(in));
	}
	public ConsoleIO(PrintStream out) {
		this(out, System.in);
	}
	public ConsoleIO(InputStream in) {
		this(System.out, in);
	}
	public ConsoleIO() {
		this(System.out, System.in);
	}
	
	@Override
	protected String readString() {
		try {
			return in.readLine();
		} catch (IOException e) {
		}
		return null;
	}

	
	@Override
	protected void printString(String prompt) {
		out.print(prompt);
	}
	
	public void print(Object o) {
		out.print(o);
	}

	public void println(Object o) {
		out.println(o);
	}
}
