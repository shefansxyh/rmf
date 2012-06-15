/*******************************************************************************
 * Copyright (c) 2011 Formal Mind GmbH and University of Dusseldorf.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Lukas Ladenberger - initial API and implementation
 ******************************************************************************/
package org.eclipse.rmf.pror.reqif10.genhtml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.rmf.pror.presentation.headline.ui.HeadlinePresentationService;
import org.eclipse.rmf.pror.presentation.headline.util.HeadlineAdapterFactory;
import org.eclipse.rmf.pror.presentation.linewrap.util.LinewrapAdapterFactory;
import org.eclipse.rmf.pror.presentation.ui.LinewrapPresentationService;
import org.eclipse.rmf.pror.reqif10.configuration.util.ConfigurationAdapterFactory;
import org.eclipse.rmf.pror.reqif10.editor.presentation.service.PresentationService;
import org.eclipse.rmf.pror.reqif10.editor.util.ProrEditorUtil;
import org.eclipse.rmf.pror.reqif10.presentation.id.util.IdAdapterFactory;
import org.eclipse.rmf.pror.reqif10.presentation.ui.IDPresentationService;
import org.eclipse.rmf.pror.reqif10.provider.ReqIF10ItemProviderAdapterFactory;
import org.eclipse.rmf.pror.reqif10.xhtml.provider.XhtmlItemProviderAdapterFactory;
import org.eclipse.rmf.reqif10.ReqIF;
import org.eclipse.rmf.reqif10.ReqIF10Package;
import org.eclipse.rmf.reqif10.Specification;
import org.eclipse.rmf.serialization.ReqIFResourceFactoryImpl;
import org.eclipse.rmf.serialization.ReqIFResourceImpl;
import org.eclipse.rmf.serialization.ReqIFResourceSetImpl;

public class GenerateHtml {

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new ConfigurationAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReqIF10ItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new XhtmlItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		adapterFactory.addAdapterFactory(new HeadlineAdapterFactory());
		adapterFactory.addAdapterFactory(new LinewrapAdapterFactory());
		adapterFactory.addAdapterFactory(new IdAdapterFactory());
		
		BasicCommandStack commandStack = new BasicCommandStack();
		AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new ReqIFResourceSetImpl());
		
		// iterate reqif dump folder
		File f = new File("dump/reqif");

		System.out.println("===> ReqIF Dump folder exists? ===> "
				+ f.exists());
		
		if (f.exists()) {

			File[] fileArray = f.listFiles();

			for (File file : fileArray) {

				if (file.getName().endsWith(".reqif")) {

					System.out.println("===> Loading ReqIF file " + file.getName());
					
					ReqIF reqif = loadData(file);

					if (reqif != null) {

						for (Specification spec : reqif.getCoreContent()
								.getSpecifications()) {

							String fileName = file.getName();
							int mid = fileName.lastIndexOf(".");
							String fname = fileName.substring(0, mid);

							List<PresentationService> presentations = new ArrayList<PresentationService>();
							presentations
									.add(new LinewrapPresentationService());
							presentations
									.add(new HeadlinePresentationService());
							presentations.add(new IDPresentationService());

							// String ext = fileName.substring(mid + 1,
							// fileName.length());
							String createHtmlHeader = ProrEditorUtil
									.createHtmlContent(spec, editingDomain,
											presentations);
							System.out
									.println("===> Generate HTML file for Loading ReqIF file "
											+ file.getName());

							String htmlFileName = fname + "_"
									+ spec.getIdentifier() + ".html";

							File htmlFile = new File("dump/html/"
									+ htmlFileName);
							Writer output = new BufferedWriter(new FileWriter(
									htmlFile));
							output.write(createHtmlHeader);
							output.close();

						}

					}

				}

			}

		}

	}
	
	public static ReqIF loadData(File file) throws FileNotFoundException,
			IOException {
		
		ReqIFResourceSetImpl resourceSet = new ReqIFResourceSetImpl();

		Map<String, Object> extensionToFactoryMap = resourceSet
				.getResourceFactoryRegistry().getExtensionToFactoryMap();

		extensionToFactoryMap.put("reqif", new ReqIFResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(ReqIF10Package.eNS_URI,
				ReqIF10Package.eINSTANCE);
		resourceSet.getPackageRegistry().put(
				XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.FALSE);

		URI fileURI = URI.createFileURI(file.getPath());

		ReqIFResourceImpl resource = (ReqIFResourceImpl) resourceSet
				.createResource(fileURI);
		
		resource.load(extensionToFactoryMap);

		return (ReqIF) resource.getContents().get(0);
		
	}

}
