/*
* generated by Xtext
*///
package qa.xtext.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import tdt4250.qa.QATest
import tdt4250.qa.Question
import tdt4250.qa.QAPart
import tdt4250.qa.QASection
import tdt4250.qa.AnswerType
import tdt4250.qa.Answer
import tdt4250.qa.YesNoAnswer
import tdt4250.qa.TextAnswer
import tdt4250.qa.NumberAnswer
import tdt4250.qa.OptionAnswer
import tdt4250.qa.ExpressionAnswer
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.NumberType

class QaGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		val className = resource.URI.trimFileExtension.lastSegment.toFirstUpper
		val packageNameList = resource.URI.trimSegments(1).segmentsList.drop(3)
		val packageName = packageNameList.join(".")
		fsa.generateFile(packageNameList.join("/") + "/" + className + ".java", '''
		package �packageNameList.join(".")�;
		public class �className� implements Runnable {
		
		private tdt4250.io.AbstractIO io = new tdt4250.io.ConsoleIO();
		
		public void run() {
		�generate(resource.contents.get(0) as QATest)�
		}
		
		public static void main(String[] args) {
		new �className�().run();
		}
		}
		''')
	}
	
	def dispatch CharSequence generate(QATest qa) {
		qa.parts.join("\n", [p | p.generate])
	}
	
	def dispatch CharSequence generate(QAPart qa) {
	}
	
	def dispatch CharSequence generate(QASection qs) {
		'''
		//Generated codes for a section
		{
		io.println("Here comes a section");
		io.println("�qs.title�");
		�qs.questions.join("\n", [q | q.generate])�
		}'''
	}
	
	def dispatch CharSequence generate(Question q) {
		'''
		//Generated codes for a question
		{
			io.println("Here comes a question");
			int i = 0;
			while(true){
				io.println("�q.text�");
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
		'''
	}
}