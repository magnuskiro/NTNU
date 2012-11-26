/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.NumberAnswer#getNumber <em>Number</em>}</li>
 *   <li>{@link tdt4250.qa.NumberAnswer#getEpsilon <em>Epsilon</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getNumberAnswer()
 * @model
 * @generated
 */
public interface NumberAnswer extends Answer {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(double)
	 * @see tdt4250.qa.QaPackage#getNumberAnswer_Number()
	 * @model
	 * @generated
	 */
	double getNumber();

	/**
	 * Sets the value of the '{@link tdt4250.qa.NumberAnswer#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(double value);

	/**
	 * Returns the value of the '<em><b>Epsilon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Epsilon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Epsilon</em>' attribute.
	 * @see #setEpsilon(double)
	 * @see tdt4250.qa.QaPackage#getNumberAnswer_Epsilon()
	 * @model
	 * @generated
	 */
	double getEpsilon();

	/**
	 * Sets the value of the '{@link tdt4250.qa.NumberAnswer#getEpsilon <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Epsilon</em>' attribute.
	 * @see #getEpsilon()
	 * @generated
	 */
	void setEpsilon(double value);

} // NumberAnswer
