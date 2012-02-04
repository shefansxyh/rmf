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
package org.eclipse.rmf.pror.reqif10.editor.actions;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.rmf.pror.reqif10.configuration.ProrToolExtension;
import org.eclipse.rmf.pror.reqif10.editor.presentation.Reqif10Editor;
import org.eclipse.rmf.pror.reqif10.editor.presentation.SpecificationEditor;
import org.eclipse.rmf.pror.reqif10.util.ConfigurationUtil;
import org.eclipse.rmf.reqif10.ReqIf;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class GeneralConfigurationActionDelegate implements
		IEditorActionDelegate {

	private Reqif10Editor editor;

	/**
	 * Retrieves the {@link EditingDomain} from the Editor if present.
	 */
	@Override
	public void setActiveEditor(IAction action, IEditorPart editor) {
		if (editor instanceof Reqif10Editor) {
			this.editor = (Reqif10Editor) editor;
		} else if (editor instanceof SpecificationEditor) {
			this.editor = ((SpecificationEditor) editor).getReqifEditor();
		} else {
			this.editor = null;
		}
	}

	/**
	 * Opens the {@link ReqIFToolExtension} for the current
	 * {@link EditingDomain}.
	 */
	@Override
	public void run(IAction action) {
		if (editor == null)
			return;
		ReqIf reqif = (ReqIf) editor.getEditingDomain().getResourceSet()
				.getResources().get(0).getContents().get(0);
		ProrToolExtension uiToolExtension = ConfigurationUtil
				.getProrToolExtension(reqif, editor.getEditingDomain());

		SubtreeDialog dialog = new SubtreeDialog(editor,
				uiToolExtension.getGeneralConfiguration(),
				"General Configuration", "org.eclipse.rmf.pror.reqif10.editor.generalConfiguration");
		dialog.open();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// No action required.
	}

}