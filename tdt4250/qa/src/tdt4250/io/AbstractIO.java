package tdt4250.io;

public abstract class AbstractIO implements IO {

	public AbstractIO() {
	}
	
	protected abstract String readString();
	protected abstract void printString(String prompt);
	
	protected void printPrompt(String prompt) {
		printString(prompt);
		printString("? ");
	}

	public Integer inputInt(String prompt, int min, int max) {
		printPrompt(prompt);
		try {
			int value = Integer.parseInt(readString());
			if (value >= min && value <= max) {
				return value;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public Integer inputInt(String prompt) {
		return inputInt(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public Double inputDouble(String prompt, double min, double max) {
		printPrompt(prompt);
		try {
			double value = Double.parseDouble(readString());
			if (value >= min && value <= max) {
				return value;
			}
		} catch (Exception e) {
			System.err.println();
		}
		return null;
	}
	public Double inputDouble(String prompt) {
		return inputDouble(prompt, -Double.MAX_VALUE, Double.MAX_VALUE);
	}

	public Boolean inputBoolean(String prompt, String trueString, String falseString) {
		printPrompt(prompt);
		try {
			String line = readString();
			if (trueString.equals(line)) {
				return Boolean.TRUE;
			} else if (falseString.equals(line)) {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public String inputString(String prompt, String regex) {
		printPrompt(prompt);
		try {
			String line = readString();
			if (regex == null || line.matches(regex)) {
				return line;
			}
		} catch (Exception e) {
		}
		return null;
	}
	public String inputString(String prompt) {
		return inputString(prompt, null);
	}

	public Integer inputOption(String prompt, Object... options) {
		printPrompt(prompt);
		printPrompt("\n");
		int num = 1;
		for (Object option : options) {
			printString(num + ") " + option);
			printPrompt("\n");
			num++;
		}
		try {
			return inputInt("Select option (1 - " + options.length + ")", 1, options.length);
		} catch (Exception e) {
		}
		return null;
	}
}
