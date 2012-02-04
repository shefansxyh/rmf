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
package org.eclipse.rmf.pror.reqif10.editor.agilegrid;

import java.math.BigInteger;

import org.agilemore.agilegrid.AgileGrid;
import org.agilemore.agilegrid.ICellEditorValidator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.rmf.pror.reqif10.util.ProrUtil;
import org.eclipse.rmf.reqif10.Identifiable;

public class ProrIntegerCellEditor extends ProrCellEditor {

	private BigInteger min;
	private BigInteger max;

	public ProrIntegerCellEditor(AgileGrid agileGrid,
			EditingDomain editingDomain, Identifiable affectedObject) {
		super(agileGrid, editingDomain, affectedObject);
		this.setValidator(new ICellEditorValidator() {

			@Override
			public String isValid(Object value) {
				if (!(value instanceof String)) {
					return null;
				}
				try {
					BigInteger num = new BigInteger(value.toString());
					if ((min != null && num.compareTo(min) < 0)
							|| (max != null && num.compareTo(max) > 0)) {
						return "Value must be in [" + min + ".." + max + "]";
					}
				} catch (NumberFormatException e) {
					return e.getLocalizedMessage();
				}
				return null;
			}
		});
	}

	@Override
	protected Object doGetValue() {
		try {
			BigInteger value = new BigInteger(text.getText());
			ProrUtil.setTheValue(attributeValue, value, affectedObject,
					editingDomain);
		} catch (NumberFormatException e) {
			// No action necessary, we simply restore the old value.
		}		
		return attributeValue;
	}

	public void setRange(BigInteger min, BigInteger max) {
		this.min = min;
		this.max = max;
	}

}