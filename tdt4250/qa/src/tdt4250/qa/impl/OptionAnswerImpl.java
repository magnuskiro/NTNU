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

import tdt4250.qa.OptionAnswer;
import tdt4250.qa.QaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Option Answer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tdt4250.qa.impl.OptionAnswerImpl#getOptionNumber <em>Option Number</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OptionAnswerImpl extends AnswerImpl implements OptionAnswer {
	/**
	 * The default value of the '{@link #getOptionNumber() <em>Option Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int OPTION_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOptionNumber() <em>Option Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptionNumber()
	 * @generated
	 * @ordered
	 */
	protected int optionNumber = OPTION_NUMBER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionAnswerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QaPackage.Literals.OPTION_ANSWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOptionNumber() {
		return optionNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptionNumber(int newOptionNumber) {
		int oldOptionNumber = optionNumber;
		optionNumber = newOptionNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.OPTION_ANSWER__OPTION_NUMBER, oldOptionNumber, optionNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QaPackage.OPTION_ANSWER__OPTION_NUMBER:
				return getOptionNumber();
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
			case QaPackage.OPTION_ANSWER__OPTION_NUMBER:
				setOptionNumber((Integer)newValue);
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
			case QaPackage.OPTION_ANSWER__OPTION_NUMBER:
				setOptionNumber(OPTION_NUMBER_EDEFAULT);
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
			case QaPackage.OPTION_ANSWER__OPTION_NUMBER:
				return optionNumber != OPTION_NUMBER_EDEFAULT;
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
		result.append(" (optionNumber: ");
		result.append(optionNumber);
		result.append(')');
		return result.toString();
	}

} //OptionAnswerImpl
