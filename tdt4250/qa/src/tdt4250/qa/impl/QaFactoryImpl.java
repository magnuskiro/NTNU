/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import tdt4250.qa.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QaFactoryImpl extends EFactoryImpl implements QaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QaFactory init() {
		try {
			QaFactory theQaFactory = (QaFactory)EPackage.Registry.INSTANCE.getEFactory("platform:/resource/qa/model/qa.ecore"); 
			if (theQaFactory != null) {
				return theQaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QaPackage.QUESTION: return createQuestion();
			case QaPackage.TEXT_ANSWER: return createTextAnswer();
			case QaPackage.NUMBER_ANSWER: return createNumberAnswer();
			case QaPackage.YES_NO_ANSWER: return createYesNoAnswer();
			case QaPackage.QA_TEST: return createQATest();
			case QaPackage.QA_SECTION: return createQASection();
			case QaPackage.OPTION_ANSWER: return createOptionAnswer();
			case QaPackage.EXPRESSION_ANSWER: return createExpressionAnswer();
			case QaPackage.QA_CONTAINER_OPTIONS: return createQAContainerOptions();
			case QaPackage.NEXT_RULE: return createNextRule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Question createQuestion() {
		QuestionImpl question = new QuestionImpl();
		return question;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextAnswer createTextAnswer() {
		TextAnswerImpl textAnswer = new TextAnswerImpl();
		return textAnswer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberAnswer createNumberAnswer() {
		NumberAnswerImpl numberAnswer = new NumberAnswerImpl();
		return numberAnswer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public YesNoAnswer createYesNoAnswer() {
		YesNoAnswerImpl yesNoAnswer = new YesNoAnswerImpl();
		return yesNoAnswer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QATest createQATest() {
		QATestImpl qaTest = new QATestImpl();
		return qaTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QASection createQASection() {
		QASectionImpl qaSection = new QASectionImpl();
		return qaSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OptionAnswer createOptionAnswer() {
		OptionAnswerImpl optionAnswer = new OptionAnswerImpl();
		return optionAnswer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionAnswer createExpressionAnswer() {
		ExpressionAnswerImpl expressionAnswer = new ExpressionAnswerImpl();
		return expressionAnswer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QAContainerOptions createQAContainerOptions() {
		QAContainerOptionsImpl qaContainerOptions = new QAContainerOptionsImpl();
		return qaContainerOptions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NextRule createNextRule() {
		NextRuleImpl nextRule = new NextRuleImpl();
		return nextRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QaPackage getQaPackage() {
		return (QaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QaPackage getPackage() {
		return QaPackage.eINSTANCE;
	}

} //QaFactoryImpl
