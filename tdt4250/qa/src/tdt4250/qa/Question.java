/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Question</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.Question#getText <em>Text</em>}</li>
 *   <li>{@link tdt4250.qa.Question#getCorrect <em>Correct</em>}</li>
 *   <li>{@link tdt4250.qa.Question#getCandidates <em>Candidates</em>}</li>
 *   <li>{@link tdt4250.qa.Question#getNextRules <em>Next Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getQuestion()
 * @model
 * @generated
 */
public interface Question extends QAPart {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see tdt4250.qa.QaPackage#getQuestion_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link tdt4250.qa.Question#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Correct</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link tdt4250.qa.Answer#getQuestion <em>Question</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correct</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correct</em>' containment reference.
	 * @see #setCorrect(Answer)
	 * @see tdt4250.qa.QaPackage#getQuestion_Correct()
	 * @see tdt4250.qa.Answer#getQuestion
	 * @model opposite="question" containment="true" required="true"
	 * @generated
	 */
	Answer getCorrect();

	/**
	 * Sets the value of the '{@link tdt4250.qa.Question#getCorrect <em>Correct</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correct</em>' containment reference.
	 * @see #getCorrect()
	 * @generated
	 */
	void setCorrect(Answer value);

	/**
	 * Returns the value of the '<em><b>Candidates</b></em>' containment reference list.
	 * The list contents are of type {@link tdt4250.qa.Answer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidates</em>' containment reference list.
	 * @see tdt4250.qa.QaPackage#getQuestion_Candidates()
	 * @model containment="true"
	 * @generated
	 */
	EList<Answer> getCandidates();

	/**
	 * Returns the value of the '<em><b>Next Rules</b></em>' containment reference list.
	 * The list contents are of type {@link tdt4250.qa.NextRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Rules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Rules</em>' containment reference list.
	 * @see tdt4250.qa.QaPackage#getQuestion_NextRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<NextRule> getNextRules();

} // Question
