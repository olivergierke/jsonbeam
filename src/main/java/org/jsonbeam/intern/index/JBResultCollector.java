/**
 *    Copyright 2015 Sven Ewald
 *
 *    This file is part of JSONBeam.
 *
 *    JSONBeam is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, any
 *    later version.
 *
 *    JSONBeam is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with JSONBeam.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jsonbeam.intern.index;

import java.util.function.Supplier;

import org.jsonbeam.intern.index.keys.ElementKey;
import org.jsonbeam.intern.index.model.ObjectReference;
import org.jsonbeam.intern.index.model.Reference;

public interface JBResultCollector {

	String currentPathAsString();

	JBQueries foundObjectPath(Supplier<ObjectReference> item);

	//FIXME: split result collecting into object,array and value paths. Maybe literal paths.

	/**
	 * Notifies the Collector that a path was found for the given item.
	 *
	 * @param pathReferenceStack
	 * @param item
	 * @return A list of SubQueries to match on that path.
	 */
	void foundValuePath(Reference item);
	
	boolean currentKeyMightBeInterresting(ElementKey reference);

	boolean isPathEmpty();

	ElementKey popPath();

	void pushPath(ElementKey currentKey);

}
