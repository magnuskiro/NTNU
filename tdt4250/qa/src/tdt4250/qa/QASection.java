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
 * A representation of the model object '<em><b>QA Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link tdt4250.qa.QASection#getQuestions <em>Questions</em>}</li>
 * </ul>
 * </p>
 *
 * @see tdt4250.qa.QaPackage#getQASection()
 * @model
 * @generated
 */
public interface QASection extends QAContainer, QAPart {
	/**
	 * Returns the value of the '<em><b>Questions</b></em>' containment reference list.
	 * The list contents are of type {@link tdt4250.qa.Question}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Questions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Questions</em>' containment reference list.
	 * @see tdt4250.qa.QaPackage#getQASection_Questions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Question> getQuestions();

} // QASection
