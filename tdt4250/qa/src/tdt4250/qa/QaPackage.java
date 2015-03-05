/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see tdt4250.qa.QaFactory
 * @model kind="package"
 * @generated
 */
public interface QaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qa";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/qa/model/qa.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QaPackage eINSTANCE = tdt4250.qa.impl.QaPackageImpl.init();

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.QAContainerImpl <em>QA Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.QAContainerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getQAContainer()
	 * @generated
	 */
	int QA_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_CONTAINER__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_CONTAINER__OPTIONS = 1;

	/**
	 * The number of structural features of the '<em>QA Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_CONTAINER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.QAPartImpl <em>QA Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.QAPartImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getQAPart()
	 * @generated
	 */
	int QA_PART = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_PART__NAME = 0;

	/**
	 * The number of structural features of the '<em>QA Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_PART_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.QuestionImpl <em>Question</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.QuestionImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getQuestion()
	 * @generated
	 */
	int QUESTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__NAME = QA_PART__NAME;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__TEXT = QA_PART_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Correct</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__CORRECT = QA_PART_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Candidates</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__CANDIDATES = QA_PART_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION__NEXT_RULES = QA_PART_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Question</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUESTION_FEATURE_COUNT = QA_PART_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.AnswerImpl <em>Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.AnswerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getAnswer()
	 * @generated
	 */
	int ANSWER = 2;

	/**
	 * The feature id for the '<em><b>Question</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER__QUESTION = 0;

	/**
	 * The number of structural features of the '<em>Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANSWER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.TextAnswerImpl <em>Text Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.TextAnswerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getTextAnswer()
	 * @generated
	 */
	int TEXT_ANSWER = 3;

	/**
	 * The feature id for the '<em><b>Question</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANSWER__QUESTION = ANSWER__QUESTION;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANSWER__TEXT = ANSWER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Text Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANSWER_FEATURE_COUNT = ANSWER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.NumberAnswerImpl <em>Number Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.NumberAnswerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getNumberAnswer()
	 * @generated
	 */
	int NUMBER_ANSWER = 4;

	/**
	 * The feature id for the '<em><b>Question</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_ANSWER__QUESTION = ANSWER__QUESTION;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_ANSWER__NUMBER = ANSWER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_ANSWER__EPSILON = ANSWER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Number Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMBER_ANSWER_FEATURE_COUNT = ANSWER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.YesNoAnswerImpl <em>Yes No Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.YesNoAnswerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getYesNoAnswer()
	 * @generated
	 */
	int YES_NO_ANSWER = 5;

	/**
	 * The feature id for the '<em><b>Question</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YES_NO_ANSWER__QUESTION = ANSWER__QUESTION;

	/**
	 * The feature id for the '<em><b>Yes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YES_NO_ANSWER__YES = ANSWER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Yes No Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int YES_NO_ANSWER_FEATURE_COUNT = ANSWER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.QATestImpl <em>QA Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.QATestImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getQATest()
	 * @generated
	 */
	int QA_TEST = 6;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_TEST__TITLE = QA_CONTAINER__TITLE;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_TEST__OPTIONS = QA_CONTAINER__OPTIONS;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_TEST__PARTS = QA_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QA Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_TEST_FEATURE_COUNT = QA_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.QASectionImpl <em>QA Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.QASectionImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getQASection()
	 * @generated
	 */
	int QA_SECTION = 7;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_SECTION__TITLE = QA_CONTAINER__TITLE;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_SECTION__OPTIONS = QA_CONTAINER__OPTIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_SECTION__NAME = QA_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Questions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_SECTION__QUESTIONS = QA_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>QA Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_SECTION_FEATURE_COUNT = QA_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.OptionAnswerImpl <em>Option Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.OptionAnswerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getOptionAnswer()
	 * @generated
	 */
	int OPTION_ANSWER = 9;

	/**
	 * The feature id for the '<em><b>Question</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_ANSWER__QUESTION = ANSWER__QUESTION;

	/**
	 * The feature id for the '<em><b>Option Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_ANSWER__OPTION_NUMBER = ANSWER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Option Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPTION_ANSWER_FEATURE_COUNT = ANSWER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.ExpressionAnswerImpl <em>Expression Answer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.ExpressionAnswerImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getExpressionAnswer()
	 * @generated
	 */
	int EXPRESSION_ANSWER = 10;

	/**
	 * The feature id for the '<em><b>Question</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ANSWER__QUESTION = NUMBER_ANSWER__QUESTION;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ANSWER__NUMBER = NUMBER_ANSWER__NUMBER;

	/**
	 * The feature id for the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ANSWER__EPSILON = NUMBER_ANSWER__EPSILON;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ANSWER__EXPRESSION = NUMBER_ANSWER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Answer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_ANSWER_FEATURE_COUNT = NUMBER_ANSWER_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.QAContainerOptionsImpl <em>QA Container Options</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.QAContainerOptionsImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getQAContainerOptions()
	 * @generated
	 */
	int QA_CONTAINER_OPTIONS = 11;

	/**
	 * The feature id for the '<em><b>Max Tries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_CONTAINER_OPTIONS__MAX_TRIES = 0;

	/**
	 * The feature id for the '<em><b>Reveal Answer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_CONTAINER_OPTIONS__REVEAL_ANSWER = 1;

	/**
	 * The number of structural features of the '<em>QA Container Options</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QA_CONTAINER_OPTIONS_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link tdt4250.qa.impl.NextRuleImpl <em>Next Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tdt4250.qa.impl.NextRuleImpl
	 * @see tdt4250.qa.impl.QaPackageImpl#getNextRule()
	 * @generated
	 */
	int NEXT_RULE = 12;

	/**
	 * The feature id for the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_RULE__NEXT = 0;

	/**
	 * The feature id for the '<em><b>Tries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_RULE__TRIES = 1;

	/**
	 * The number of structural features of the '<em>Next Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEXT_RULE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link tdt4250.qa.QAContainer <em>QA Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA Container</em>'.
	 * @see tdt4250.qa.QAContainer
	 * @generated
	 */
	EClass getQAContainer();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.QAContainer#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see tdt4250.qa.QAContainer#getTitle()
	 * @see #getQAContainer()
	 * @generated
	 */
	EAttribute getQAContainer_Title();

	/**
	 * Returns the meta object for the containment reference '{@link tdt4250.qa.QAContainer#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Options</em>'.
	 * @see tdt4250.qa.QAContainer#getOptions()
	 * @see #getQAContainer()
	 * @generated
	 */
	EReference getQAContainer_Options();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.Question <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Question</em>'.
	 * @see tdt4250.qa.Question
	 * @generated
	 */
	EClass getQuestion();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.Question#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see tdt4250.qa.Question#getText()
	 * @see #getQuestion()
	 * @generated
	 */
	EAttribute getQuestion_Text();

	/**
	 * Returns the meta object for the containment reference '{@link tdt4250.qa.Question#getCorrect <em>Correct</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correct</em>'.
	 * @see tdt4250.qa.Question#getCorrect()
	 * @see #getQuestion()
	 * @generated
	 */
	EReference getQuestion_Correct();

	/**
	 * Returns the meta object for the containment reference list '{@link tdt4250.qa.Question#getCandidates <em>Candidates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Candidates</em>'.
	 * @see tdt4250.qa.Question#getCandidates()
	 * @see #getQuestion()
	 * @generated
	 */
	EReference getQuestion_Candidates();

	/**
	 * Returns the meta object for the containment reference list '{@link tdt4250.qa.Question#getNextRules <em>Next Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Next Rules</em>'.
	 * @see tdt4250.qa.Question#getNextRules()
	 * @see #getQuestion()
	 * @generated
	 */
	EReference getQuestion_NextRules();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.Answer <em>Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Answer</em>'.
	 * @see tdt4250.qa.Answer
	 * @generated
	 */
	EClass getAnswer();

	/**
	 * Returns the meta object for the container reference '{@link tdt4250.qa.Answer#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Question</em>'.
	 * @see tdt4250.qa.Answer#getQuestion()
	 * @see #getAnswer()
	 * @generated
	 */
	EReference getAnswer_Question();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.TextAnswer <em>Text Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Answer</em>'.
	 * @see tdt4250.qa.TextAnswer
	 * @generated
	 */
	EClass getTextAnswer();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.TextAnswer#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see tdt4250.qa.TextAnswer#getText()
	 * @see #getTextAnswer()
	 * @generated
	 */
	EAttribute getTextAnswer_Text();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.NumberAnswer <em>Number Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Number Answer</em>'.
	 * @see tdt4250.qa.NumberAnswer
	 * @generated
	 */
	EClass getNumberAnswer();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.NumberAnswer#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see tdt4250.qa.NumberAnswer#getNumber()
	 * @see #getNumberAnswer()
	 * @generated
	 */
	EAttribute getNumberAnswer_Number();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.NumberAnswer#getEpsilon <em>Epsilon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Epsilon</em>'.
	 * @see tdt4250.qa.NumberAnswer#getEpsilon()
	 * @see #getNumberAnswer()
	 * @generated
	 */
	EAttribute getNumberAnswer_Epsilon();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.YesNoAnswer <em>Yes No Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Yes No Answer</em>'.
	 * @see tdt4250.qa.YesNoAnswer
	 * @generated
	 */
	EClass getYesNoAnswer();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.YesNoAnswer#isYes <em>Yes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Yes</em>'.
	 * @see tdt4250.qa.YesNoAnswer#isYes()
	 * @see #getYesNoAnswer()
	 * @generated
	 */
	EAttribute getYesNoAnswer_Yes();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.QATest <em>QA Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA Test</em>'.
	 * @see tdt4250.qa.QATest
	 * @generated
	 */
	EClass getQATest();

	/**
	 * Returns the meta object for the containment reference list '{@link tdt4250.qa.QATest#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see tdt4250.qa.QATest#getParts()
	 * @see #getQATest()
	 * @generated
	 */
	EReference getQATest_Parts();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.QASection <em>QA Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA Section</em>'.
	 * @see tdt4250.qa.QASection
	 * @generated
	 */
	EClass getQASection();

	/**
	 * Returns the meta object for the containment reference list '{@link tdt4250.qa.QASection#getQuestions <em>Questions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Questions</em>'.
	 * @see tdt4250.qa.QASection#getQuestions()
	 * @see #getQASection()
	 * @generated
	 */
	EReference getQASection_Questions();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.QAPart <em>QA Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA Part</em>'.
	 * @see tdt4250.qa.QAPart
	 * @generated
	 */
	EClass getQAPart();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.QAPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tdt4250.qa.QAPart#getName()
	 * @see #getQAPart()
	 * @generated
	 */
	EAttribute getQAPart_Name();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.OptionAnswer <em>Option Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Option Answer</em>'.
	 * @see tdt4250.qa.OptionAnswer
	 * @generated
	 */
	EClass getOptionAnswer();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.OptionAnswer#getOptionNumber <em>Option Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Option Number</em>'.
	 * @see tdt4250.qa.OptionAnswer#getOptionNumber()
	 * @see #getOptionAnswer()
	 * @generated
	 */
	EAttribute getOptionAnswer_OptionNumber();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.ExpressionAnswer <em>Expression Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Answer</em>'.
	 * @see tdt4250.qa.ExpressionAnswer
	 * @generated
	 */
	EClass getExpressionAnswer();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.ExpressionAnswer#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see tdt4250.qa.ExpressionAnswer#getExpression()
	 * @see #getExpressionAnswer()
	 * @generated
	 */
	EAttribute getExpressionAnswer_Expression();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.QAContainerOptions <em>QA Container Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QA Container Options</em>'.
	 * @see tdt4250.qa.QAContainerOptions
	 * @generated
	 */
	EClass getQAContainerOptions();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.QAContainerOptions#getMaxTries <em>Max Tries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Tries</em>'.
	 * @see tdt4250.qa.QAContainerOptions#getMaxTries()
	 * @see #getQAContainerOptions()
	 * @generated
	 */
	EAttribute getQAContainerOptions_MaxTries();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.QAContainerOptions#isRevealAnswer <em>Reveal Answer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reveal Answer</em>'.
	 * @see tdt4250.qa.QAContainerOptions#isRevealAnswer()
	 * @see #getQAContainerOptions()
	 * @generated
	 */
	EAttribute getQAContainerOptions_RevealAnswer();

	/**
	 * Returns the meta object for class '{@link tdt4250.qa.NextRule <em>Next Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Next Rule</em>'.
	 * @see tdt4250.qa.NextRule
	 * @generated
	 */
	EClass getNextRule();

	/**
	 * Returns the meta object for the reference '{@link tdt4250.qa.NextRule#getNext <em>Next</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next</em>'.
	 * @see tdt4250.qa.NextRule#getNext()
	 * @see #getNextRule()
	 * @generated
	 */
	EReference getNextRule_Next();

	/**
	 * Returns the meta object for the attribute '{@link tdt4250.qa.NextRule#getTries <em>Tries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tries</em>'.
	 * @see tdt4250.qa.NextRule#getTries()
	 * @see #getNextRule()
	 * @generated
	 */
	EAttribute getNextRule_Tries();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QaFactory getQaFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.QAContainerImpl <em>QA Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.QAContainerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getQAContainer()
		 * @generated
		 */
		EClass QA_CONTAINER = eINSTANCE.getQAContainer();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_CONTAINER__TITLE = eINSTANCE.getQAContainer_Title();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QA_CONTAINER__OPTIONS = eINSTANCE.getQAContainer_Options();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.QuestionImpl <em>Question</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.QuestionImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getQuestion()
		 * @generated
		 */
		EClass QUESTION = eINSTANCE.getQuestion();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUESTION__TEXT = eINSTANCE.getQuestion_Text();

		/**
		 * The meta object literal for the '<em><b>Correct</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTION__CORRECT = eINSTANCE.getQuestion_Correct();

		/**
		 * The meta object literal for the '<em><b>Candidates</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTION__CANDIDATES = eINSTANCE.getQuestion_Candidates();

		/**
		 * The meta object literal for the '<em><b>Next Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUESTION__NEXT_RULES = eINSTANCE.getQuestion_NextRules();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.AnswerImpl <em>Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.AnswerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getAnswer()
		 * @generated
		 */
		EClass ANSWER = eINSTANCE.getAnswer();

		/**
		 * The meta object literal for the '<em><b>Question</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANSWER__QUESTION = eINSTANCE.getAnswer_Question();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.TextAnswerImpl <em>Text Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.TextAnswerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getTextAnswer()
		 * @generated
		 */
		EClass TEXT_ANSWER = eINSTANCE.getTextAnswer();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT_ANSWER__TEXT = eINSTANCE.getTextAnswer_Text();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.NumberAnswerImpl <em>Number Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.NumberAnswerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getNumberAnswer()
		 * @generated
		 */
		EClass NUMBER_ANSWER = eINSTANCE.getNumberAnswer();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_ANSWER__NUMBER = eINSTANCE.getNumberAnswer_Number();

		/**
		 * The meta object literal for the '<em><b>Epsilon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMBER_ANSWER__EPSILON = eINSTANCE.getNumberAnswer_Epsilon();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.YesNoAnswerImpl <em>Yes No Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.YesNoAnswerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getYesNoAnswer()
		 * @generated
		 */
		EClass YES_NO_ANSWER = eINSTANCE.getYesNoAnswer();

		/**
		 * The meta object literal for the '<em><b>Yes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute YES_NO_ANSWER__YES = eINSTANCE.getYesNoAnswer_Yes();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.QATestImpl <em>QA Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.QATestImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getQATest()
		 * @generated
		 */
		EClass QA_TEST = eINSTANCE.getQATest();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QA_TEST__PARTS = eINSTANCE.getQATest_Parts();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.QASectionImpl <em>QA Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.QASectionImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getQASection()
		 * @generated
		 */
		EClass QA_SECTION = eINSTANCE.getQASection();

		/**
		 * The meta object literal for the '<em><b>Questions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QA_SECTION__QUESTIONS = eINSTANCE.getQASection_Questions();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.QAPartImpl <em>QA Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.QAPartImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getQAPart()
		 * @generated
		 */
		EClass QA_PART = eINSTANCE.getQAPart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_PART__NAME = eINSTANCE.getQAPart_Name();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.OptionAnswerImpl <em>Option Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.OptionAnswerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getOptionAnswer()
		 * @generated
		 */
		EClass OPTION_ANSWER = eINSTANCE.getOptionAnswer();

		/**
		 * The meta object literal for the '<em><b>Option Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPTION_ANSWER__OPTION_NUMBER = eINSTANCE.getOptionAnswer_OptionNumber();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.ExpressionAnswerImpl <em>Expression Answer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.ExpressionAnswerImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getExpressionAnswer()
		 * @generated
		 */
		EClass EXPRESSION_ANSWER = eINSTANCE.getExpressionAnswer();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_ANSWER__EXPRESSION = eINSTANCE.getExpressionAnswer_Expression();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.QAContainerOptionsImpl <em>QA Container Options</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.QAContainerOptionsImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getQAContainerOptions()
		 * @generated
		 */
		EClass QA_CONTAINER_OPTIONS = eINSTANCE.getQAContainerOptions();

		/**
		 * The meta object literal for the '<em><b>Max Tries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_CONTAINER_OPTIONS__MAX_TRIES = eINSTANCE.getQAContainerOptions_MaxTries();

		/**
		 * The meta object literal for the '<em><b>Reveal Answer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QA_CONTAINER_OPTIONS__REVEAL_ANSWER = eINSTANCE.getQAContainerOptions_RevealAnswer();

		/**
		 * The meta object literal for the '{@link tdt4250.qa.impl.NextRuleImpl <em>Next Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tdt4250.qa.impl.NextRuleImpl
		 * @see tdt4250.qa.impl.QaPackageImpl#getNextRule()
		 * @generated
		 */
		EClass NEXT_RULE = eINSTANCE.getNextRule();

		/**
		 * The meta object literal for the '<em><b>Next</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEXT_RULE__NEXT = eINSTANCE.getNextRule_Next();

		/**
		 * The meta object literal for the '<em><b>Tries</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEXT_RULE__TRIES = eINSTANCE.getNextRule_Tries();

	}

} //QaPackage
