/**
 * WS-Attacker - A Modular Web Services Penetration Testing Framework Copyright
 * (C) 2013 Christian Mainka
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package wsattacker.library.signatureWrapping.xpath.analysis;

import org.w3c.dom.Element;
import wsattacker.library.schemaanalyzer.AnyElementProperties;
import wsattacker.library.xmlutilities.dom.DomUtilities;

/**
 * Wrapper class which hold the properties for a payload element.
 */
public class WrapperProperties
{

    private final AnyElementProperties anyElementPorperties;

    private final Element signedElement;

    private final int possiblePositions;

    private final boolean wrapperNeeded;

    /**
     * Constructor.
     * 
     * @param anyElementPorperties
     * @param signedElement
     */
    public WrapperProperties( AnyElementProperties anyElementPorperties, Element signedElement )
    {
        this.anyElementPorperties = anyElementPorperties;
        // TODO: Is this signedElement needed?
        this.signedElement = signedElement;
        this.possiblePositions =
            1 + DomUtilities.getAllChildElements( anyElementPorperties.getDocumentElement() ).size();
        this.wrapperNeeded = anyElementPorperties.needsWrapper( signedElement.getNamespaceURI() );
    }

    public AnyElementProperties getAnyElementPorperties()
    {
        return anyElementPorperties;
    }

    /**
     * @return number of possible positions to place the wrapper element. Depends on the amount of child elements of the
     *         extension point element.
     */
    public int getPossiblePositions()
    {
        return possiblePositions;
    }

    /**
     * @return is a wrapper element needed?
     */
    public boolean isWrapperNeeded()
    {
        return wrapperNeeded;
    }
}
