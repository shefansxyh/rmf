/*******************************************************************************
 * Copyright (c) 2011 Formal Mind GmbH and University of Dusseldorf.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Lukas Ladenberger - initial API and implementation
 ******************************************************************************/
package org.eclipse.rmf.pror.reqif10.editor.agilegrid;

import org.agilemore.agilegrid.AgileGrid;
import org.agilemore.agilegrid.editors.TextCellEditor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rmf.pror.reqif10.editor.preferences.PreferenceConstants;
import org.eclipse.rmf.pror.reqif10.editor.presentation.Reqif10EditorPlugin;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueXHTML;
import org.eclipse.rmf.reqif10.ReqIF10Factory;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.XhtmlContent;
import org.eclipse.rmf.reqif10.impl.AttributeValueXHTMLImpl;
import org.eclipse.rmf.reqif10.xhtml.XhtmlDivType;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

/**
 * @author Lukas Ladenberger
 */
public class ProrXhtmlSimplifiedCellEditor extends TextCellEditor {
	
	private final EditingDomain editingDomain;
	private AttributeValueXHTML attributeValue;

	public ProrXhtmlSimplifiedCellEditor(AgileGrid agileGrid,
			EditingDomain editingDomain, Object affectedObject) {
		super(agileGrid, SWT.WRAP);
		this.editingDomain = editingDomain;
	}

	@Override
	protected Object doGetValue() {

		XhtmlDivType div = ProrXhtmlSimplifiedHelper
				.stringToSimplifiedXhtml(text.getText());
		XhtmlContent origTheValue = attributeValue.getTheValue();

		CompoundCommand compoundCommand = new CompoundCommand();

		if (!attributeValue.isSimplified()) {

			XhtmlContent xhtmlContentCopy = EcoreUtil.copy(origTheValue);

			// Comand for setting original value
			Command setTheOriginalValueCmd = SetCommand
					.create(editingDomain,
							attributeValue,
							ReqIF10Package.Literals.ATTRIBUTE_VALUE_XHTML__THE_ORIGINAL_VALUE,
							xhtmlContentCopy);

			// Comand for setting simplified flag
			Command setSimplifiedCmd = SetCommand.create(editingDomain,
					attributeValue,
					ReqIF10Package.Literals.ATTRIBUTE_VALUE_XHTML__SIMPLIFIED,
					true);

			compoundCommand.append(setTheOriginalValueCmd);
			compoundCommand.append(setSimplifiedCmd);

			// Notify user about potential information loss
			if (!Reqif10EditorPlugin
					.getPlugin()
					.getPreferenceStore()
					.getBoolean(
							PreferenceConstants.P_STOP_IS_SIMPLIFIED_WARNING)) {
				MessageDialog
						.openInformation(
								Display.getDefault().getActiveShell(),
								"Information",
								Reqif10EditorPlugin.INSTANCE
										.getString("_UI_Reqif10XhtmlIsSimplifiedWarning"));
			}

		}

		// Command for setting new simplified version
		Command setTheValueCmd = SetCommand.create(editingDomain,
				origTheValue,
				ReqIF10Package.Literals.XHTML_CONTENT__DIV, div);
		Command removePCmd = SetCommand.create(editingDomain,
				origTheValue, ReqIF10Package.Literals.XHTML_CONTENT__P, null);
		compoundCommand.append(setTheValueCmd);
		compoundCommand.append(removePCmd);

		editingDomain.getCommandStack().execute(compoundCommand);

		return attributeValue;

	}

	@Override
	protected void doSetValue(Object value) {
		this.attributeValue = null;
		if (value instanceof AttributeValue) {
			attributeValue = (AttributeValueXHTML) value;
			AttributeValueXHTMLImpl attributeValueXHTMLImpl = (AttributeValueXHTMLImpl) value;
			XhtmlContent xhtmlContent = attributeValueXHTMLImpl.getTheValue();
			if (xhtmlContent == null) {
				xhtmlContent = ReqIF10Factory.eINSTANCE.createXhtmlContent();
				Command setTheOriginalValueCmd = SetCommand
						.create(editingDomain,
								attributeValue,
								ReqIF10Package.Literals.ATTRIBUTE_VALUE_XHTML__THE_VALUE,
								xhtmlContent);
				editingDomain.getCommandStack().execute(setTheOriginalValueCmd);
			}
			value = ProrXhtmlSimplifiedHelper
					.xhtmlToSimplifiedString(xhtmlContent);
		}
		super.doSetValue(value);
	}

}
