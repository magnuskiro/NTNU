/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package tdt4250.qa.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tdt4250.qa.Answer;
import tdt4250.qa.NextRule;
import tdt4250.qa.QaPackage;
import tdt4250.qa.Question;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Question</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link tdt4250.qa.impl.QuestionImpl#getText <em>Text</em>}</li>
 *   <li>{@link tdt4250.qa.impl.QuestionImpl#getCorrect <em>Correct</em>}</li>
 *   <li>{@link tdt4250.qa.impl.QuestionImpl#getCandidates <em>Candidates</em>}</li>
 *   <li>{@link tdt4250.qa.impl.QuestionImpl#getNextRules <em>Next Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuestionImpl extends QAPartImpl implements Question {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCorrect() <em>Correct</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrect()
	 * @generated
	 * @ordered
	 */
	protected Answer correct;

	/**
	 * The cached value of the '{@link #getCandidates() <em>Candidates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCandidates()
	 * @generated
	 * @ordered
	 */
	protected EList<Answer> candidates;

	/**
	 * The cached value of the '{@link #getNextRules() <em>Next Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextRules()
	 * @generated
	 * @ordered
	 */
	protected EList<NextRule> nextRules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QuestionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QaPackage.Literals.QUESTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.QUESTION__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Answer getCorrect() {
		return correct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorrect(Answer newCorrect, NotificationChain msgs) {
		Answer oldCorrect = correct;
		correct = newCorrect;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QaPackage.QUESTION__CORRECT, oldCorrect, newCorrect);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrect(Answer newCorrect) {
		if (newCorrect != correct) {
			NotificationChain msgs = null;
			if (correct != null)
				msgs = ((InternalEObject)correct).eInverseRemove(this, QaPackage.ANSWER__QUESTION, Answer.class, msgs);
			if (newCorrect != null)
				msgs = ((InternalEObject)newCorrect).eInverseAdd(this, QaPackage.ANSWER__QUESTION, Answer.class, msgs);
			msgs = basicSetCorrect(newCorrect, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QaPackage.QUESTION__CORRECT, newCorrect, newCorrect));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Answer> getCandidates() {
		if (candidates == null) {
			candidates = new EObjectContainmentEList<Answer>(Answer.class, this, QaPackage.QUESTION__CANDIDATES);
		}
		return candidates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NextRule> getNextRules() {
		if (nextRules == null) {
			nextRules = new EObjectContainmentEList<NextRule>(NextRule.class, this, QaPackage.QUESTION__NEXT_RULES);
		}
		return nextRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QaPackage.QUESTION__CORRECT:
				if (correct != null)
					msgs = ((InternalEObject)correct).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QaPackage.QUESTION__CORRECT, null, msgs);
				return basicSetCorrect((Answer)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QaPackage.QUESTION__CORRECT:
				return basicSetCorrect(null, msgs);
			case QaPackage.QUESTION__CANDIDATES:
				return ((InternalEList<?>)getCandidates()).basicRemove(otherEnd, msgs);
			case QaPackage.QUESTION__NEXT_RULES:
				return ((InternalEList<?>)getNextRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QaPackage.QUESTION__TEXT:
				return getText();
			case QaPackage.QUESTION__CORRECT:
				return getCorrect();
			case QaPackage.QUESTION__CANDIDATES:
				return getCandidates();
			case QaPackage.QUESTION__NEXT_RULES:
				return getNextRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QaPackage.QUESTION__TEXT:
				setText((String)newValue);
				return;
			case QaPackage.QUESTION__CORRECT:
				setCorrect((Answer)newValue);
				return;
			case QaPackage.QUESTION__CANDIDATES:
				getCandidates().clear();
				getCandidates().addAll((Collection<? extends Answer>)newValue);
				return;
			case QaPackage.QUESTION__NEXT_RULES:
				getNextRules().clear();
				getNextRules().addAll((Collection<? extends NextRule>)newValue);
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
			case QaPackage.QUESTION__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case QaPackage.QUESTION__CORRECT:
				setCorrect((Answer)null);
				return;
			case QaPackage.QUESTION__CANDIDATES:
				getCandidates().clear();
				return;
			case QaPackage.QUESTION__NEXT_RULES:
				getNextRules().clear();
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
			case QaPackage.QUESTION__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case QaPackage.QUESTION__CORRECT:
				return correct != null;
			case QaPackage.QUESTION__CANDIDATES:
				return candidates != null && !candidates.isEmpty();
			case QaPackage.QUESTION__NEXT_RULES:
				return nextRules != null && !nextRules.isEmpty();
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
		result.append(" (text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} //QuestionImpl
