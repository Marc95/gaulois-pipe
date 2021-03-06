/**
 * This Source Code Form is subject to the terms of 
 * the Mozilla Public License, v. 2.0. If a copy of 
 * the MPL was not distributed with this file, You 
 * can obtain one at https://mozilla.org/MPL/2.0/.
 */
package fr.efl.chaine.xslt.config;

import fr.efl.chaine.xslt.InvalidSyntaxException;
import fr.efl.chaine.xslt.utils.ParameterValue;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author ext-cmarchand
 */
public class EscapingTest {
    
    @Test
    public void escapeParameter() throws InvalidSyntaxException {
        ParameterValue pv = new ParameterValue("workDir", "file:/home/cmarchand/devel/data");
        Collection<ParameterValue> coll = new ArrayList<>();
        coll.add(pv);
        // n'importe lequel, aucune importance
        ConfigUtil cu = new ConfigUtil("./src/test/resources/same-source-file.xml");
        String result = cu.resolveEscapes("$[workDir]/collection.xml", coll);
        assertEquals("file:/home/cmarchand/devel/data/collection.xml", result);
    }
    
}
