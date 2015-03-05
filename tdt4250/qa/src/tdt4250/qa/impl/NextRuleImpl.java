/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import tdt4250.qa.NextRule;
import tdt4250.qa.QAPart;
import tdt4250.qa.QaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Next Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tdt4250.qa.impl.NextRuleImpl#getNext <em>Next</em>}</li>
 *   <li>{@link tdt4250.qa.impl.NextRuleImpl#getTries <em>Tries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NextRuleImpl extends EObjectImpl implements NextRule {
	/**
	 * The cached value of the '{@link #getNext() <em>Next</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNext()
	 * @generated
	 * @ordered
	 */
	protected QAPart next;

	/**
	 * The default value of the '{@link #getTries() <em>Tries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTries()
	 * @generated
	 * @ordered
	 */
	protected static final int TRIES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTries() <em>Tries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTries()
	 * @generated
	 * @ordered
	 */
	protected int tries = TRIES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NextRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QaPackage.Literals.NEXT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QAPart getNext() {
		if (next != null && next.eIsProxy()) {
			InternalEObject oldNext = (InternalEObject)next;
			next = (QAPart)eResolveProxy(oldNext);
			if (next != oldNext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QaPackage.NEXT_RULE__NEXT, oldNext, next));
			}
		}
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QAPart basicGetNext() {
		return next;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNext(QAPart newNext) {
		QAPart oldNext = next;
		next = newNext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.NEXT_RULE__NEXT, oldNext, next));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTries() {
		return tries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTries(int newTries) {
		int oldTries = tries;
		tries = newTries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.NEXT_RULE__TRIES, oldTries, tries));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QaPackage.NEXT_RULE__NEXT:
				if (resolve) return getNext();
				return basicGetNext();
			case QaPackage.NEXT_RULE__TRIES:
				return getTries();
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
			case QaPackage.NEXT_RULE__NEXT:
				setNext((QAPart)newValue);
				return;
			case QaPackage.NEXT_RULE__TRIES:
				setTries((Integer)newValue);
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
			case QaPackage.NEXT_RULE__NEXT:
				setNext((QAPart)null);
				return;
			case QaPackage.NEXT_RULE__TRIES:
				setTries(TRIES_EDEFAULT);
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
			case QaPackage.NEXT_RULE__NEXT:
				return next != null;
			case QaPackage.NEXT_RULE__TRIES:
				return tries != TRIES_EDEFAULT;
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
		result.append(" (tries: ");
		result.append(tries);
		result.append(')');
		return result.toString();
	}

} //NextRuleImpl
