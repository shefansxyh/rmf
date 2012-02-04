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

package org.eclipse.rmf.reqif10.validation;

import org.eclipse.rmf.reqif10.DatatypeDefinition;
import org.eclipse.rmf.reqif10.RelationGroup;
import org.eclipse.rmf.reqif10.ReqIf;
import org.eclipse.rmf.reqif10.SpecObject;
import org.eclipse.rmf.reqif10.SpecRelation;
import org.eclipse.rmf.reqif10.SpecType;
import org.eclipse.rmf.reqif10.Specification;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link org.eclipse.rmf.reqif10.ReqIfContent}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ReqIfContentValidator {
	boolean validate();

	boolean validateDocumentRoot(ReqIf value);
	boolean validateSpecObjects(EList<SpecObject> value);
	boolean validateSpecifications(EList<Specification> value);
	boolean validateDatatypes(EList<DatatypeDefinition> value);
	boolean validateSpecRelations(EList<SpecRelation> value);
	boolean validateSpecRelationGroups(EList<RelationGroup> value);
	boolean validateSpecTypes(EList<SpecType> value);
}