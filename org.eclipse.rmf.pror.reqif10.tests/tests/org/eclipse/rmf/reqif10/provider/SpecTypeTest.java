/*******************************************************************************
 * Copyright (c) 2011 Formal Mind GmbH and University of Dusseldorf.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Michael Jastram - initial API and implementation
 ******************************************************************************/

package org.eclipse.rmf.reqif10.provider;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.rmf.pror.reqif10.provider.VirtualSpecTypeItemProvider;
import org.eclipse.rmf.pror.reqif10.util.ProrUtil;
import org.eclipse.rmf.reqif10.AttributeDefinitionString;
import org.eclipse.rmf.reqif10.ReqIf;
import org.eclipse.rmf.reqif10.Reqif10Factory;
import org.eclipse.rmf.reqif10.Reqif10Package;
import org.eclipse.rmf.reqif10.SpecType;
import org.junit.Test;

/**
 * A test case for the model object '<em><b>Spec Type</b></em>'.
 */
public abstract class SpecTypeTest extends IdentifiableTest {

	/**
	 * Returns the fixture for this Spec Type test case.
	 */
	@Override
	protected SpecType getFixture() {
		return (SpecType)fixture;
	}
	
	/**
	 * If a value of AttributeDefinition changes, then the SpecType should be notified
	 */
	@Test
	public void testAttributeDefinitionChanges() {
		AttributeDefinitionString ad = Reqif10Factory.eINSTANCE.createAttributeDefinitionString();
		getFixture().getSpecAttributes().add(ad);
		ItemProviderAdapter ip = getItemProvider(getFixture());
		ip.addListener(listener);
		setViaCommand(ad, Reqif10Package.Literals.IDENTIFIABLE__LONG_NAME, "New Name");
		assertEquals(1, notifications.size());
	}
	
	@Test
	public void testParentIsVirtual() throws URISyntaxException {
		ReqIf reqif = getTestReqif("simple.reqif");
		// Required for generating the Virtual Element lazily.
		getItemProvider(reqif.getCoreContent()).getChildren(reqif.getCoreContent());

		setViaCommand(reqif.getCoreContent(), Reqif10Package.Literals.REQ_IF_CONTENT__SPEC_TYPES, getFixture());
		ItemProviderAdapter ip = ProrUtil.getItemProvider(adapterFactory, getFixture());
		assertTrue(ip.getParent(getFixture()) instanceof VirtualSpecTypeItemProvider);
	}

} //SpecTypeTest
