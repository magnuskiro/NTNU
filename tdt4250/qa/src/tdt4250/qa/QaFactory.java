/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tdt4250.qa.QaPackage
 * @generated
 */
public interface QaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QaFactory eINSTANCE = tdt4250.qa.impl.QaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Question</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Question</em>'.
	 * @generated
	 */
	Question createQuestion();

	/**
	 * Returns a new object of class '<em>Text Answer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Text Answer</em>'.
	 * @generated
	 */
	TextAnswer createTextAnswer();

	/**
	 * Returns a new object of class '<em>Number Answer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Answer</em>'.
	 * @generated
	 */
	NumberAnswer createNumberAnswer();

	/**
	 * Returns a new object of class '<em>Yes No Answer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Yes No Answer</em>'.
	 * @generated
	 */
	YesNoAnswer createYesNoAnswer();

	/**
	 * Returns a new object of class '<em>QA Test</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QA Test</em>'.
	 * @generated
	 */
	QATest createQATest();

	/**
	 * Returns a new object of class '<em>QA Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QA Section</em>'.
	 * @generated
	 */
	QASection createQASection();

	/**
	 * Returns a new object of class '<em>Option Answer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Option Answer</em>'.
	 * @generated
	 */
	OptionAnswer createOptionAnswer();

	/**
	 * Returns a new object of class '<em>Expression Answer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Answer</em>'.
	 * @generated
	 */
	ExpressionAnswer createExpressionAnswer();

	/**
	 * Returns a new object of class '<em>QA Container Options</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QA Container Options</em>'.
	 * @generated
	 */
	QAContainerOptions createQAContainerOptions();

	/**
	 * Returns a new object of class '<em>Next Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Next Rule</em>'.
	 * @generated
	 */
	NextRule createNextRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QaPackage getQaPackage();

} //QaFactory
