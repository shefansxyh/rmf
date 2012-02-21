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

package org.eclipse.rmf.reqif10.xsd.validation;

import org.eclipse.rmf.reqif10.xsd.ALTERNATIVEIDType8;
import org.eclipse.rmf.reqif10.xsd.SPECATTRIBUTESType1;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * A sample validator interface for {@link org.eclipse.rmf.reqif10.xsd.SPECIFICATIONTYPE}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SPECIFICATIONTYPEValidator {
	boolean validate();

	boolean validateALTERNATIVEID(ALTERNATIVEIDType8 value);
	boolean validateSPECATTRIBUTES(SPECATTRIBUTESType1 value);
	boolean validateDESC(String value);
	boolean validateIDENTIFIER(String value);
	boolean validateLASTCHANGE(XMLGregorianCalendar value);
	boolean validateLONGNAME(String value);
}
