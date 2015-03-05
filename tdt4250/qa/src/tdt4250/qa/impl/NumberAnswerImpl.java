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

import tdt4250.qa.NumberAnswer;
import tdt4250.qa.QaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Answer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tdt4250.qa.impl.NumberAnswerImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link tdt4250.qa.impl.NumberAnswerImpl#getEpsilon <em>Epsilon</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberAnswerImpl extends AnswerImpl implements NumberAnswer {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final double NUMBER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected double number = NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getEpsilon() <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpsilon()
	 * @generated
	 * @ordered
	 */
	protected static final double EPSILON_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getEpsilon() <em>Epsilon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEpsilon()
	 * @generated
	 * @ordered
	 */
	protected double epsilon = EPSILON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberAnswerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QaPackage.Literals.NUMBER_ANSWER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(double newNumber) {
		double oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.NUMBER_ANSWER__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getEpsilon() {
		return epsilon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEpsilon(double newEpsilon) {
		double oldEpsilon = epsilon;
		epsilon = newEpsilon;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.NUMBER_ANSWER__EPSILON, oldEpsilon, epsilon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QaPackage.NUMBER_ANSWER__NUMBER:
				return getNumber();
			case QaPackage.NUMBER_ANSWER__EPSILON:
				return getEpsilon();
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
			case QaPackage.NUMBER_ANSWER__NUMBER:
				setNumber((Double)newValue);
				return;
			case QaPackage.NUMBER_ANSWER__EPSILON:
				setEpsilon((Double)newValue);
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
			case QaPackage.NUMBER_ANSWER__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case QaPackage.NUMBER_ANSWER__EPSILON:
				setEpsilon(EPSILON_EDEFAULT);
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
			case QaPackage.NUMBER_ANSWER__NUMBER:
				return number != NUMBER_EDEFAULT;
			case QaPackage.NUMBER_ANSWER__EPSILON:
				return epsilon != EPSILON_EDEFAULT;
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
		result.append(" (number: ");
		result.append(number);
		result.append(", epsilon: ");
		result.append(epsilon);
		result.append(')');
		return result.toString();
	}

} //NumberAnswerImpl
