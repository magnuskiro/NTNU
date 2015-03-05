/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import tdt4250.qa.QAContainerOptions;
import tdt4250.qa.QaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QA Container Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tdt4250.qa.impl.QAContainerOptionsImpl#getMaxTries <em>Max Tries</em>}</li>
 *   <li>{@link tdt4250.qa.impl.QAContainerOptionsImpl#isRevealAnswer <em>Reveal Answer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QAContainerOptionsImpl extends EObjectImpl implements QAContainerOptions {
	/**
	 * The default value of the '{@link #getMaxTries() <em>Max Tries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTries()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_TRIES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxTries() <em>Max Tries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTries()
	 * @generated
	 * @ordered
	 */
	protected int maxTries = MAX_TRIES_EDEFAULT;

	/**
	 * The default value of the '{@link #isRevealAnswer() <em>Reveal Answer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRevealAnswer()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVEAL_ANSWER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRevealAnswer() <em>Reveal Answer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRevealAnswer()
	 * @generated
	 * @ordered
	 */
	protected boolean revealAnswer = REVEAL_ANSWER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QAContainerOptionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QaPackage.Literals.QA_CONTAINER_OPTIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxTries() {
		return maxTries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxTries(int newMaxTries) {
		int oldMaxTries = maxTries;
		maxTries = newMaxTries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.QA_CONTAINER_OPTIONS__MAX_TRIES, oldMaxTries, maxTries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRevealAnswer() {
		return revealAnswer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRevealAnswer(boolean newRevealAnswer) {
		boolean oldRevealAnswer = revealAnswer;
		revealAnswer = newRevealAnswer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.QA_CONTAINER_OPTIONS__REVEAL_ANSWER, oldRevealAnswer, revealAnswer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QaPackage.QA_CONTAINER_OPTIONS__MAX_TRIES:
				return getMaxTries();
			case QaPackage.QA_CONTAINER_OPTIONS__REVEAL_ANSWER:
				return isRevealAnswer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QaPackage.QA_CONTAINER_OPTIONS__MAX_TRIES:
				setMaxTries((Integer)newValue);
				return;
			case QaPackage.QA_CONTAINER_OPTIONS__REVEAL_ANSWER:
				setRevealAnswer((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case QaPackage.QA_CONTAINER_OPTIONS__MAX_TRIES:
				setMaxTries(MAX_TRIES_EDEFAULT);
				return;
			case QaPackage.QA_CONTAINER_OPTIONS__REVEAL_ANSWER:
				setRevealAnswer(REVEAL_ANSWER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case QaPackage.QA_CONTAINER_OPTIONS__MAX_TRIES:
				return maxTries != MAX_TRIES_EDEFAULT;
			case QaPackage.QA_CONTAINER_OPTIONS__REVEAL_ANSWER:
				return revealAnswer != REVEAL_ANSWER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (maxTries: ");
		result.append(maxTries);
		result.append(", revealAnswer: ");
		result.append(revealAnswer);
		result.append(')');
		return result.toString();
	}

} //QAContainerOptionsImpl
