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
 * A representation of the model object '<em><b>QA Container Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.QAContainerOptions#getMaxTries <em>Max Tries</em>}</li>
 *   <li>{@link tdt4250.qa.QAContainerOptions#isRevealAnswer <em>Reveal Answer</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getQAContainerOptions()
 * @model
 * @generated
 */
public interface QAContainerOptions extends EObject {
	/**
	 * Returns the value of the '<em><b>Max Tries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Tries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Tries</em>' attribute.
	 * @see #setMaxTries(int)
	 * @see tdt4250.qa.QaPackage#getQAContainerOptions_MaxTries()
	 * @model
	 * @generated
	 */
	int getMaxTries();

	/**
	 * Sets the value of the '{@link tdt4250.qa.QAContainerOptions#getMaxTries <em>Max Tries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Tries</em>' attribute.
	 * @see #getMaxTries()
	 * @generated
	 */
	void setMaxTries(int value);

	/**
	 * Returns the value of the '<em><b>Reveal Answer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reveal Answer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reveal Answer</em>' attribute.
	 * @see #setRevealAnswer(boolean)
	 * @see tdt4250.qa.QaPackage#getQAContainerOptions_RevealAnswer()
	 * @model
	 * @generated
	 */
	boolean isRevealAnswer();

	/**
	 * Sets the value of the '{@link tdt4250.qa.QAContainerOptions#isRevealAnswer <em>Reveal Answer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reveal Answer</em>' attribute.
	 * @see #isRevealAnswer()
	 * @generated
	 */
	void setRevealAnswer(boolean value);

} // QAContainerOptions
