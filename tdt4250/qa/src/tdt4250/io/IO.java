package tdt4250.io;

public interface IO {
	public void print(Object o);
	public void println(Object o);
	
	public Integer inputInt(String prompt, int min, int max);
	public Double inputDouble(String prompt, double min, double max);
	public Boolean inputBoolean(String prompt, String trueString, String falseString);
	public String inputString(String prompt, String regex);
	public Integer inputOption(String prompt, Object... options);
}
