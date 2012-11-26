/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.TextAnswer#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getTextAnswer()
 * @model
 * @generated
 */
public interface TextAnswer extends Answer {
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
	 * @see tdt4250.qa.QaPackage#getTextAnswer_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link tdt4250.qa.TextAnswer#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // TextAnswer
