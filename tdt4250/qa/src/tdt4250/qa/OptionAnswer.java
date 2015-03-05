/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Option Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.OptionAnswer#getOptionNumber <em>Option Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getOptionAnswer()
 * @model
 * @generated
 */
public interface OptionAnswer extends Answer {
	/**
	 * Returns the value of the '<em><b>Option Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Option Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Option Number</em>' attribute.
	 * @see #setOptionNumber(int)
	 * @see tdt4250.qa.QaPackage#getOptionAnswer_OptionNumber()
	 * @model
	 * @generated
	 */
	int getOptionNumber();

	/**
	 * Sets the value of the '{@link tdt4250.qa.OptionAnswer#getOptionNumber <em>Option Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Option Number</em>' attribute.
	 * @see #getOptionNumber()
	 * @generated
	 */
	void setOptionNumber(int value);

} // OptionAnswer
