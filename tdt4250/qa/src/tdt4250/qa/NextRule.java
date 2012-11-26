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
 * A representation of the model object '<em><b>Next Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.NextRule#getNext <em>Next</em>}</li>
 *   <li>{@link tdt4250.qa.NextRule#getTries <em>Tries</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getNextRule()
 * @model
 * @generated
 */
public interface NextRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Next</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' reference.
	 * @see #setNext(QAPart)
	 * @see tdt4250.qa.QaPackage#getNextRule_Next()
	 * @model
	 * @generated
	 */
	QAPart getNext();

	/**
	 * Sets the value of the '{@link tdt4250.qa.NextRule#getNext <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(QAPart value);

	/**
	 * Returns the value of the '<em><b>Tries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tries</em>' attribute.
	 * @see #setTries(int)
	 * @see tdt4250.qa.QaPackage#getNextRule_Tries()
	 * @model
	 * @generated
	 */
	int getTries();

	/**
	 * Sets the value of the '{@link tdt4250.qa.NextRule#getTries <em>Tries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tries</em>' attribute.
	 * @see #getTries()
	 * @generated
	 */
	void setTries(int value);

} // NextRule
