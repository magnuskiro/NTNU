package examples;
public class Example1 implements Runnable {

private tdt4250.io.AbstractIO io = new tdt4250.io.ConsoleIO();

public void run() {
//Generated codes for a question
{
	io.println("Here comes a question");
	int i = 0;
	while(true){
		io.println("Are you ready");
		String input = io.inputString("","");
		String corris;
	
		if (input.equals(corris)) {
			io.println("Correct!");
			break;
		}
		else io.println("Wrong!");
		i++;
	}
	//repeat the following until a correct answer is given, or hit the maximum tries if there is.
	//1.print out the question,
	//2.get user input 
	//3.compare user input with the correct answer, and notify user correct or wrong answer
}

//Generated codes for a section
{
io.println("Here comes a section");
io.println("Math");
//Generated codes for a question
{
	io.println("Here comes a question");
	int i = 0;
	while(true){
		io.println("What is 2 + 2");
		String input = io.inputString("","");
		String corris;
	
		if (input.equals(corris)) {
			io.println("Correct!");
			break;
		}
		else io.println("Wrong!");
		i++;
	}
	//repeat the following until a correct answer is given, or hit the maximum tries if there is.
	//1.print out the question,
	//2.get user input 
	//3.compare user input with the correct answer, and notify user correct or wrong answer
}

//Generated codes for a question
{
	io.println("Here comes a question");
	int i = 0;
	while(true){
		io.println("What is 2 - 2");
		String input = io.inputString("","");
		String corris;
	
		if (input.equals(corris)) {
			io.println("Correct!");
			break;
		}
		else io.println("Wrong!");
		i++;
	}
	//repeat the following until a correct answer is given, or hit the maximum tries if there is.
	//1.print out the question,
	//2.get user input 
	//3.compare user input with the correct answer, and notify user correct or wrong answer
}

//Generated codes for a question
{
	io.println("Here comes a question");
	int i = 0;
	while(true){
		io.println("What is the square root of 2");
		String input = io.inputString("","");
		String corris;
	
		if (input.equals(corris)) {
			io.println("Correct!");
			break;
		}
		else io.println("Wrong!");
		i++;
	}
	//repeat the following until a correct answer is given, or hit the maximum tries if there is.
	//1.print out the question,
	//2.get user input 
	//3.compare user input with the correct answer, and notify user correct or wrong answer
}
}
//Generated codes for a section
{
io.println("Here comes a section");
io.println("Geography");
//Generated codes for a question
{
	io.println("Here comes a question");
	int i = 0;
	while(true){
		io.println("Where is Norway");
		String input = io.inputString("","");
		String corris;
	
		if (input.equals(corris)) {
			io.println("Correct!");
			break;
		}
		else io.println("Wrong!");
		i++;
	}
	//repeat the following until a correct answer is given, or hit the maximum tries if there is.
	//1.print out the question,
	//2.get user input 
	//3.compare user input with the correct answer, and notify user correct or wrong answer
}

//Generated codes for a question
{
	io.println("Here comes a question");
	int i = 0;
	while(true){
		io.println("What is the capitol of Norway");
		String input = io.inputString("","");
		String corris;
	
		if (input.equals(corris)) {
			io.println("Correct!");
			break;
		}
		else io.println("Wrong!");
		i++;
	}
	//repeat the following until a correct answer is given, or hit the maximum tries if there is.
	//1.print out the question,
	//2.get user input 
	//3.compare user input with the correct answer, and notify user correct or wrong answer
}
}
}

public static void main(String[] args) {
new Example1().run();
}
}
