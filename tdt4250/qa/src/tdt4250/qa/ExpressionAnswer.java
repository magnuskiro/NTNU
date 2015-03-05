/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Answer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.ExpressionAnswer#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getExpressionAnswer()
 * @model
 * @generated
 */
public interface ExpressionAnswer extends NumberAnswer {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see tdt4250.qa.QaPackage#getExpressionAnswer_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link tdt4250.qa.ExpressionAnswer#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // ExpressionAnswer
