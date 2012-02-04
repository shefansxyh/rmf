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
package org.eclipse.rmf.reqif10.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.rmf.reqif10.AttributeDefinition;
import org.eclipse.rmf.reqif10.AttributeValue;
import org.eclipse.rmf.reqif10.AttributeValueBoolean;
import org.eclipse.rmf.reqif10.AttributeValueDate;
import org.eclipse.rmf.reqif10.AttributeValueEnumeration;
import org.eclipse.rmf.reqif10.AttributeValueInteger;
import org.eclipse.rmf.reqif10.AttributeValueReal;
import org.eclipse.rmf.reqif10.AttributeValueSimple;
import org.eclipse.rmf.reqif10.AttributeValueString;
import org.eclipse.rmf.reqif10.AttributeValueXhtml;
import org.eclipse.rmf.reqif10.DatatypeDefinition;
import org.eclipse.rmf.reqif10.ReqIf;
import org.eclipse.rmf.reqif10.Reqif10Package;
import org.eclipse.rmf.reqif10.SpecElementWithAttributes;
import org.eclipse.rmf.reqif10.SpecType;

/**
 * This class contains various static helper methods for working with ReqIf data
 * objects. Amongst others, we solve a number of issues that would be better
 * served proper OOP (e.g. {@link #getTheValue(AttributeValue)}. However, we
 * decided not to touch the generated code. We decided to use reflection over
 * long if-then-else blocks to
 * <p>
 * 
 * This class is not intended to be instantiated.
 * 
 * @author jastram
 */
public class Reqif10Util {

	/**
	 * This class is not designed to be instantiated.
	 */
	private Reqif10Util() {
		throw new InstantiationError("This class is not designed to be instantiated.");
	}

	/**
	 * Returns the root ReqIF object for the corresponding EObject or null if
	 * none exists. This method simply traverses the object tree to the root -
	 * there may be more efficient ways for finding the root ReqIF.
	 * 
	 * @return the root {@link ReqIF} object or null if none found.
	 */
	public static ReqIf getReqIf(Object obj) {
		if (!(obj instanceof EObject))
			return null;
		while (((EObject) obj).eContainer() != null)
			obj = ((EObject) obj).eContainer();
		if (obj instanceof ReqIf)
			return (ReqIf) obj;
		return null;
	}

	/**
	 * Retrieves the Value from the given AttributeValue. We would prefer to
	 * have an abstract getTheValue() method on AttributeValue, but EMF doesn't
	 * support this. Thus, each subclass of AttributeValue has its own
	 * getTheValue() method. This convenience method returns the value.
	 */
	public static Object getTheValue(AttributeValue attributeValue) {
		if (attributeValue instanceof AttributeValueSimple
				|| attributeValue instanceof AttributeValueXhtml) {
			return reflectiveGet(attributeValue, "getTheValue");
		} else if (attributeValue instanceof AttributeValueEnumeration) {
			return reflectiveGet(attributeValue, "getValues");
		} else {
			throw new IllegalArgumentException("Can't get value from "
					+ attributeValue);
		}
	}

	/**
	 * Retrieves the value for the given {@link AttributeValue} from the
	 * {@link SpecElementWithAttributes}.
	 */
	public static AttributeValue getAttributeValue(
			SpecElementWithAttributes specElement,
			AttributeDefinition attributeDefinition) {
		for (AttributeValue value : specElement.getValues()) {
			AttributeDefinition definition = (AttributeDefinition) reflectiveGet(
					value, "getDefinition");
			if (attributeDefinition.equals(definition)) {
				return value;
			}
		}
		return null;
	}

	/**
	 * Finds the {@link AttributeValue} for the given
	 * {@link SpecElementWithUserDefinedAttributes}. May return null.
	 */
	public static AttributeValue getAttributeValueForLabel(
			SpecElementWithAttributes element, String label) {
		if (label == null)
			return null;
		for (AttributeValue value : element.getValues()) {
			if (value == null)
				continue;
			AttributeDefinition ad = getAttributeDefinition(value);
			if (ad != null && label.equals(ad.getLongName())) {
				return value;
			}
		}
		return null;
	}

	/**
	 * Returns the AttributeDefinition for a given value (Would be so much
	 * easier with inheritance).
	 */
	public static AttributeDefinition getAttributeDefinition(
			AttributeValue value) {
		return (AttributeDefinition) reflectiveGet(value, "getDefinition");
	}

	/**
	 * Returns the {@link DatatypeDefinition} for the given
	 * {@link AttributeDefinition} (Would be so much easier with inheritance).
	 */
	public static DatatypeDefinition getDatatypeDefinition(
			AttributeDefinition attributeDefinition) {
		return (DatatypeDefinition) reflectiveGet(attributeDefinition,
				"getType");
	}

	/**
	 * Returns the {@link DatatypeDefinition} for the given
	 * {@link AttributeValue}.
	 * 
	 * @return the corresponding {@link DatatypeDefinition} or null if it cannot
	 *         be determined.
	 */
	public static DatatypeDefinition getDatatypeDefinition(AttributeValue value) {
		if (value == null) {
			return null;
		}
		AttributeDefinition ad = getAttributeDefinition(value);
		if (ad == null) {
			return null;
		}
		return getDatatypeDefinition(ad);
	}

	public static SpecType getSpecType(SpecElementWithAttributes specElement) {
		return (SpecType) reflectiveGet(specElement, "getType");
	}

	/**
	 * Helper method that reflectively executes methods. The annoying thing with
	 * ReqIF is, that many classes share a method (e.g. getType()) that returns
	 * the same supertype, but due to the model generation, there isn't a shared
	 * method in the superclass.
	 * 
	 * If there is a problem, the resulting {@link Exception} is wrapped into a
	 * {@link RuntimeException}.
	 * 
	 * @param object
	 * @param methodName
	 * @return the result of the method call
	 * @throws RuntimeException
	 */
	public static Object reflectiveGet(Object object, String methodName) {
		try {
			Method method = object.getClass().getMethod(methodName,
					(Class<?>[]) null);
			return method.invoke(object, (Object[]) null);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the "the value" feature for the given attributeValue. For
	 * instance, for an {@link AttributeValueString} it returns
	 * {@link Reqif10Package.Literals#ATTRIBUTE_VALUE_STRING__THE_VALUE}. The
	 * one exception is {@link AttributeValueEnumeration}, where the feature
	 * name is "values", rather than "the value".
	 * 
	 * @throws IllegalArgumentException for unknown {@link AttributeValue}s.
	 */
	public static EStructuralFeature getTheValueFeature(AttributeValue attributeValue) {
		if (attributeValue instanceof AttributeValueBoolean) {
			return Reqif10Package.Literals.ATTRIBUTE_VALUE_BOOLEAN__THE_VALUE;
		} else if (attributeValue instanceof AttributeValueDate) {
			return  Reqif10Package.Literals.ATTRIBUTE_VALUE_DATE__THE_VALUE;
		} else if (attributeValue instanceof AttributeValueInteger) {
			return  Reqif10Package.Literals.ATTRIBUTE_VALUE_INTEGER__THE_VALUE;
		} else if (attributeValue instanceof AttributeValueReal) {
			return  Reqif10Package.Literals.ATTRIBUTE_VALUE_REAL__THE_VALUE;
		} else if (attributeValue instanceof AttributeValueString) {
			return  Reqif10Package.Literals.ATTRIBUTE_VALUE_STRING__THE_VALUE;
		} else if (attributeValue instanceof AttributeValueXhtml) {
			return  Reqif10Package.Literals.ATTRIBUTE_VALUE_XHTML__THE_VALUE;
		} else if (attributeValue instanceof AttributeValueEnumeration) {
			return  Reqif10Package.Literals.ATTRIBUTE_VALUE_ENUMERATION__VALUES;		
		} else {
			throw new IllegalArgumentException("Unknown AttributeValue: "
					+ attributeValue);
		}
	}

}