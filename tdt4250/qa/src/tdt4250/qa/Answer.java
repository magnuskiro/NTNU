/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.Answer#getQuestion <em>Question</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getAnswer()
 * @model abstract="true"
 * @generated
 */
public interface Answer extends EObject {
	/**
	 * Returns the value of the '<em><b>Question</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link tdt4250.qa.Question#getCorrect <em>Correct</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Question</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Question</em>' container reference.
	 * @see #setQuestion(Question)
	 * @see tdt4250.qa.QaPackage#getAnswer_Question()
	 * @see tdt4250.qa.Question#getCorrect
	 * @model opposite="correct" transient="false"
	 * @generated
	 */
	Question getQuestion();

	/**
	 * Sets the value of the '{@link tdt4250.qa.Answer#getQuestion <em>Question</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Question</em>' container reference.
	 * @see #getQuestion()
	 * @generated
	 */
	void setQuestion(Question value);

} // Answer
