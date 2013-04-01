package net.thucydides.showcase.fest;


import org.fest.assertions.Condition;
import java.util.Iterator;
import static org.fest.assertions.Assertions.assertThat;

public class ContainsTermCondition extends Condition<Iterator<?>> {

    private final String term;

    private ContainsTermCondition(String term) {
        this.term = term;
    }



    @Override
    public boolean matches(Iterator<?> definitions) {
        boolean matchingDefinitionFound = false;
        while(definitions.hasNext()) {
            String definition = definitions.next().toString();
            if (definition.contains(term)) {
                matchingDefinitionFound = true;
            }
        }
        assertThat(matchingDefinitionFound).overridingErrorMessage("Definition should contain '" + term + '"').isTrue();
        return matchingDefinitionFound;
    }


    public static ContainsTermCondition containsTerm(final String term) {
        return (ContainsTermCondition) new ContainsTermCondition(term).as("Definition should contain '" + term + "'");
    }
}