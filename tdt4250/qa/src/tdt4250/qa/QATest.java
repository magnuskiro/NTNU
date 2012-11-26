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
 * A representation of the model object '<em><b>QA Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.QATest#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getQATest()
 * @model
 * @generated
 */
public interface QATest extends QAContainer {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link tdt4250.qa.QAPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see tdt4250.qa.QaPackage#getQATest_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<QAPart> getParts();

} // QATest
