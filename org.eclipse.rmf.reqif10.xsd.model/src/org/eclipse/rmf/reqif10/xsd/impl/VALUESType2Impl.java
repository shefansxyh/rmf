/*******************************************************************************
 * Copyright (c) 2011 itemis GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Nirmal Sasidharan - initial API and implementation
 ******************************************************************************/

package org.eclipse.rmf.reqif10.xsd.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUEBOOLEAN;
import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUEDATE;
import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUEENUMERATION;
import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUEINTEGER;
import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUEREAL;
import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUESTRING;
import org.eclipse.rmf.reqif10.xsd.ATTRIBUTEVALUEXHTML;
import org.eclipse.rmf.reqif10.xsd.ReqifPackage;
import org.eclipse.rmf.reqif10.xsd.VALUESType2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VALUES Type2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUEBOOLEAN <em>ATTRIBUTEVALUEBOOLEAN</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUEDATE <em>ATTRIBUTEVALUEDATE</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUEENUMERATION <em>ATTRIBUTEVALUEENUMERATION</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUEINTEGER <em>ATTRIBUTEVALUEINTEGER</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUEREAL <em>ATTRIBUTEVALUEREAL</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUESTRING <em>ATTRIBUTEVALUESTRING</em>}</li>
 *   <li>{@link org.eclipse.rmf.reqif10.xsd.impl.VALUESType2Impl#getATTRIBUTEVALUEXHTML <em>ATTRIBUTEVALUEXHTML</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VALUESType2Impl extends EObjectImpl implements VALUESType2 {
	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VALUESType2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReqifPackage.Literals.VALUES_TYPE2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, ReqifPackage.VALUES_TYPE2__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUEBOOLEAN> getATTRIBUTEVALUEBOOLEAN() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUEBOOLEAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUEDATE> getATTRIBUTEVALUEDATE() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUEDATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUEENUMERATION> getATTRIBUTEVALUEENUMERATION() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUEENUMERATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUEINTEGER> getATTRIBUTEVALUEINTEGER() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUEINTEGER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUEREAL> getATTRIBUTEVALUEREAL() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUEREAL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUESTRING> getATTRIBUTEVALUESTRING() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUESTRING);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ATTRIBUTEVALUEXHTML> getATTRIBUTEVALUEXHTML() {
		return getGroup().list(ReqifPackage.Literals.VALUES_TYPE2__ATTRIBUTEVALUEXHTML);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReqifPackage.VALUES_TYPE2__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEBOOLEAN:
				return ((InternalEList<?>)getATTRIBUTEVALUEBOOLEAN()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEDATE:
				return ((InternalEList<?>)getATTRIBUTEVALUEDATE()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEENUMERATION:
				return ((InternalEList<?>)getATTRIBUTEVALUEENUMERATION()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEINTEGER:
				return ((InternalEList<?>)getATTRIBUTEVALUEINTEGER()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEREAL:
				return ((InternalEList<?>)getATTRIBUTEVALUEREAL()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUESTRING:
				return ((InternalEList<?>)getATTRIBUTEVALUESTRING()).basicRemove(otherEnd, msgs);
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEXHTML:
				return ((InternalEList<?>)getATTRIBUTEVALUEXHTML()).basicRemove(otherEnd, msgs);
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
			case ReqifPackage.VALUES_TYPE2__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEBOOLEAN:
				return getATTRIBUTEVALUEBOOLEAN();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEDATE:
				return getATTRIBUTEVALUEDATE();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEENUMERATION:
				return getATTRIBUTEVALUEENUMERATION();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEINTEGER:
				return getATTRIBUTEVALUEINTEGER();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEREAL:
				return getATTRIBUTEVALUEREAL();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUESTRING:
				return getATTRIBUTEVALUESTRING();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEXHTML:
				return getATTRIBUTEVALUEXHTML();
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
			case ReqifPackage.VALUES_TYPE2__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEBOOLEAN:
				getATTRIBUTEVALUEBOOLEAN().clear();
				getATTRIBUTEVALUEBOOLEAN().addAll((Collection<? extends ATTRIBUTEVALUEBOOLEAN>)newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEDATE:
				getATTRIBUTEVALUEDATE().clear();
				getATTRIBUTEVALUEDATE().addAll((Collection<? extends ATTRIBUTEVALUEDATE>)newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEENUMERATION:
				getATTRIBUTEVALUEENUMERATION().clear();
				getATTRIBUTEVALUEENUMERATION().addAll((Collection<? extends ATTRIBUTEVALUEENUMERATION>)newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEINTEGER:
				getATTRIBUTEVALUEINTEGER().clear();
				getATTRIBUTEVALUEINTEGER().addAll((Collection<? extends ATTRIBUTEVALUEINTEGER>)newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEREAL:
				getATTRIBUTEVALUEREAL().clear();
				getATTRIBUTEVALUEREAL().addAll((Collection<? extends ATTRIBUTEVALUEREAL>)newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUESTRING:
				getATTRIBUTEVALUESTRING().clear();
				getATTRIBUTEVALUESTRING().addAll((Collection<? extends ATTRIBUTEVALUESTRING>)newValue);
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEXHTML:
				getATTRIBUTEVALUEXHTML().clear();
				getATTRIBUTEVALUEXHTML().addAll((Collection<? extends ATTRIBUTEVALUEXHTML>)newValue);
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
			case ReqifPackage.VALUES_TYPE2__GROUP:
				getGroup().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEBOOLEAN:
				getATTRIBUTEVALUEBOOLEAN().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEDATE:
				getATTRIBUTEVALUEDATE().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEENUMERATION:
				getATTRIBUTEVALUEENUMERATION().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEINTEGER:
				getATTRIBUTEVALUEINTEGER().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEREAL:
				getATTRIBUTEVALUEREAL().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUESTRING:
				getATTRIBUTEVALUESTRING().clear();
				return;
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEXHTML:
				getATTRIBUTEVALUEXHTML().clear();
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
			case ReqifPackage.VALUES_TYPE2__GROUP:
				return group != null && !group.isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEBOOLEAN:
				return !getATTRIBUTEVALUEBOOLEAN().isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEDATE:
				return !getATTRIBUTEVALUEDATE().isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEENUMERATION:
				return !getATTRIBUTEVALUEENUMERATION().isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEINTEGER:
				return !getATTRIBUTEVALUEINTEGER().isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEREAL:
				return !getATTRIBUTEVALUEREAL().isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUESTRING:
				return !getATTRIBUTEVALUESTRING().isEmpty();
			case ReqifPackage.VALUES_TYPE2__ATTRIBUTEVALUEXHTML:
				return !getATTRIBUTEVALUEXHTML().isEmpty();
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
		result.append(" (group: ");
		result.append(group);
		result.append(')');
		return result.toString();
	}

} //VALUESType2Impl