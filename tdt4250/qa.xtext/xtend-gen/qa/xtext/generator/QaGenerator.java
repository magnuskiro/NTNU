package qa.xtext.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import tdt4250.qa.QAPart;
import tdt4250.qa.QASection;
import tdt4250.qa.QATest;
import tdt4250.qa.Question;

@SuppressWarnings("all")
public class QaGenerator implements IGenerator {
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    {
      URI _uRI = resource.getURI();
      URI _trimFileExtension = _uRI.trimFileExtension();
      String _lastSegment = _trimFileExtension.lastSegment();
      String _firstUpper = StringExtensions.toFirstUpper(_lastSegment);
      final String className = _firstUpper;
      URI _uRI_1 = resource.getURI();
      URI _trimSegments = _uRI_1.trimSegments(1);
      List<String> _segmentsList = _trimSegments.segmentsList();
      Iterable<String> _drop = IterableExtensions.<String>drop(_segmentsList, 3);
      final Iterable<String> packageNameList = _drop;
      String _join = IterableExtensions.join(packageNameList, ".");
      final String packageName = _join;
      String _join_1 = IterableExtensions.join(packageNameList, "/");
      String _operator_plus = StringExtensions.operator_plus(_join_1, "/");
      String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, className);
      String _operator_plus_2 = StringExtensions.operator_plus(_operator_plus_1, ".java");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package ");
      String _join_2 = IterableExtensions.join(packageNameList, ".");
      _builder.append(_join_2, "");
      _builder.append(";");
      _builder.newLineIfNotEmpty();
      _builder.append("public class ");
      _builder.append(className, "");
      _builder.append(" implements Runnable {");
      _builder.newLineIfNotEmpty();
      _builder.newLine();
      _builder.append("private tdt4250.io.AbstractIO io = new tdt4250.io.ConsoleIO();");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public void run() {");
      _builder.newLine();
      EList<EObject> _contents = resource.getContents();
      EObject _get = _contents.get(0);
      CharSequence _generate = this.generate(((QATest) _get));
      _builder.append(_generate, "");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("public static void main(String[] args) {");
      _builder.newLine();
      _builder.append("new ");
      _builder.append(className, "");
      _builder.append("().run();");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      fsa.generateFile(_operator_plus_2, _builder);
    }
  }
  
  protected CharSequence _generate(final QATest qa) {
    EList<QAPart> _parts = qa.getParts();
    final Function1<QAPart,CharSequence> _function = new Function1<QAPart,CharSequence>() {
        public CharSequence apply(final QAPart p) {
          CharSequence _generate = QaGenerator.this.generate(p);
          return _generate;
        }
      };
    String _join = IterableExtensions.<QAPart>join(_parts, "\n", _function);
    return _join;
  }
  
  protected CharSequence _generate(final QAPart qa) {
    return null;
  }
  
  protected CharSequence _generate(final QASection qs) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Generated codes for a section");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("io.println(\"Here comes a section\");");
    _builder.newLine();
    _builder.append("io.println(\"");
    String _title = qs.getTitle();
    _builder.append(_title, "");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    EList<Question> _questions = qs.getQuestions();
    final Function1<Question,CharSequence> _function = new Function1<Question,CharSequence>() {
        public CharSequence apply(final Question q) {
          CharSequence _generate = QaGenerator.this.generate(q);
          return _generate;
        }
      };
    String _join = IterableExtensions.<Question>join(_questions, "\n", _function);
    _builder.append(_join, "");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    return _builder;
  }
  
  protected CharSequence _generate(final Question q) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//Generated codes for a question");
    _builder.newLine();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("io.println(\"Here comes a question\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("int i = 0;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("while(true){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("io.println(\"");
    String _text = q.getText();
    _builder.append(_text, "		");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("String input = io.inputString(\"\",\"\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String corris;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (input.equals(corris)) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("io.println(\"Correct!\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("break;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("else io.println(\"Wrong!\");");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("i++;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//repeat the following until a correct answer is given, or hit the maximum tries if there is.");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//1.print out the question,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//2.get user input ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("//3.compare user input with the correct answer, and notify user correct or wrong answer");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate(final EObject qs) {
    if ((qs instanceof QASection)) {
      return _generate((QASection)qs);
    } else if ((qs instanceof QATest)) {
      return _generate((QATest)qs);
    } else if ((qs instanceof Question)) {
      return _generate((Question)qs);
    } else if ((qs instanceof QAPart)) {
      return _generate((QAPart)qs);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        java.util.Arrays.<Object>asList(qs).toString());
    }
  }
}