/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import tdt4250.qa.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tdt4250.qa.QaPackage
 * @generated
 */
public class QaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static QaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QaSwitch() {
		if (modelPackage == null) {
			modelPackage = QaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case QaPackage.QA_CONTAINER: {
				QAContainer qaContainer = (QAContainer)theEObject;
				T result = caseQAContainer(qaContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.QUESTION: {
				Question question = (Question)theEObject;
				T result = caseQuestion(question);
				if (result == null) result = caseQAPart(question);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.ANSWER: {
				Answer answer = (Answer)theEObject;
				T result = caseAnswer(answer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.TEXT_ANSWER: {
				TextAnswer textAnswer = (TextAnswer)theEObject;
				T result = caseTextAnswer(textAnswer);
				if (result == null) result = caseAnswer(textAnswer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.NUMBER_ANSWER: {
				NumberAnswer numberAnswer = (NumberAnswer)theEObject;
				T result = caseNumberAnswer(numberAnswer);
				if (result == null) result = caseAnswer(numberAnswer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.YES_NO_ANSWER: {
				YesNoAnswer yesNoAnswer = (YesNoAnswer)theEObject;
				T result = caseYesNoAnswer(yesNoAnswer);
				if (result == null) result = caseAnswer(yesNoAnswer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.QA_TEST: {
				QATest qaTest = (QATest)theEObject;
				T result = caseQATest(qaTest);
				if (result == null) result = caseQAContainer(qaTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.QA_SECTION: {
				QASection qaSection = (QASection)theEObject;
				T result = caseQASection(qaSection);
				if (result == null) result = caseQAContainer(qaSection);
				if (result == null) result = caseQAPart(qaSection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.QA_PART: {
				QAPart qaPart = (QAPart)theEObject;
				T result = caseQAPart(qaPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.OPTION_ANSWER: {
				OptionAnswer optionAnswer = (OptionAnswer)theEObject;
				T result = caseOptionAnswer(optionAnswer);
				if (result == null) result = caseAnswer(optionAnswer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.EXPRESSION_ANSWER: {
				ExpressionAnswer expressionAnswer = (ExpressionAnswer)theEObject;
				T result = caseExpressionAnswer(expressionAnswer);
				if (result == null) result = caseNumberAnswer(expressionAnswer);
				if (result == null) result = caseAnswer(expressionAnswer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.QA_CONTAINER_OPTIONS: {
				QAContainerOptions qaContainerOptions = (QAContainerOptions)theEObject;
				T result = caseQAContainerOptions(qaContainerOptions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case QaPackage.NEXT_RULE: {
				NextRule nextRule = (NextRule)theEObject;
				T result = caseNextRule(nextRule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQAContainer(QAContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Question</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Question</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuestion(Question object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Answer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnswer(Answer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Answer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextAnswer(TextAnswer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Answer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberAnswer(NumberAnswer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Yes No Answer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Yes No Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseYesNoAnswer(YesNoAnswer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQATest(QATest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQASection(QASection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQAPart(QAPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Option Answer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Option Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptionAnswer(OptionAnswer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Answer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionAnswer(ExpressionAnswer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>QA Container Options</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>QA Container Options</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQAContainerOptions(QAContainerOptions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Next Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Next Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNextRule(NextRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //QaSwitch
