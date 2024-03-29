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

import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;

import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.rmf.reqif10.DatatypeDefinition;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.pror.provider.VirtualDatatypeDefinitionItemProvider;
import org.eclipse.rmf.reqif10.pror.util.ProrUtil;
import org.junit.Test;

/**
 * A test case for the model object '<em><b>Datatype Definition</b></em>'.
 */
public abstract class DatatypeDefinitionTest extends IdentifiableTest {

	/**
	 * Returns the fixture for this Datatype Definition test case.
	 */
	@Override
	protected DatatypeDefinition getFixture() {
		return (DatatypeDefinition)fixture;
	}
	
	@Test
	public void testParentIsVirtual() throws URISyntaxException {
		ReqIF reqif = getTestReqif("simple.reqif");
		// Required for generating the Virtual Element lazily.
		getItemProvider(reqif.getCoreContent()).getChildren(reqif.getCoreContent());
		
		setViaCommand(reqif.getCoreContent(), ReqIF10Package.Literals.REQ_IF_CONTENT__DATATYPES, getFixture());
		ItemProviderAdapter ip = ProrUtil.getItemProvider(adapterFactory, getFixture());
		assertTrue(ip.getParent(getFixture()) instanceof VirtualDatatypeDefinitionItemProvider);
	}


} //DatatypeDefinitionTest
