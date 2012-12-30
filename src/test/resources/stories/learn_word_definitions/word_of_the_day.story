Narrative:
In order to improve my vocabulary
As an online reader
I want to regularly learn the meaning of new words

Scenario: Learn a new word every day
Given today is the <date>
And the word of the day for <date> is <word_of_the_day>
Then the displayed word of the day should be <word_of_the_day>
And definition of the word of the day should contain '<word_of_the_day_definition>'

Examples:
| date              | word_of_the_day           | word_of_the_day_definition
| 01/01/2013        | apple                     | A common, round fruit
| 02/01/2013        | banana                    | An elongated curved fruit
