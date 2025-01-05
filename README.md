# Mark V. Shaney

Kotlin implementation of the classic [Mark V. Shaney](https://en.wikipedia.org/wiki/Mark_V._Shaney).
The model learns, based on pairs of words (prefix), which words usually follows the pair (suffix).

For example the sentence "Mark V. Shaney wrote on the Usenet." results in

| Prefix       | Suffix  |
|--------------|---------|
| Mark V.      | Shaney  |
| V. Shaney    | wrote   |
| Shaney wrote | on      |
| wrote on     | the     |
| on the       | Usenet. |

To generate text, a random word is chosen and then, suffixes learned are appended.
When the text is long enough, there are several suffixes for every prefix, so that there is diversity when constructing a sentence.

The table and sentence construction is similar to a _Markov Chain_ (hence the name 🙃).

The program is an example of an early and extremely simple language model, yet similar to [Yoshua Bengio et al.'s](https://jmlr.org/papers/volume3/bengio03a/bengio03a.pdf) Neural model and current transformer LLMs such as GPT.

## Running

1. Install the [Kotlin command-line compiler](https://kotlinlang.org/docs/command-line.html#sdkman)
2. Compile `kotlinc shaney.kt -include-runtime -d shaney.jar`
3. Run `java -jar shaney.jar 100 chaos.txt`

_Note_: Replace `100` with another length for the generated text and `chaos.txt` with another file to learn Markov chains.

## Example

> science was heading for a crisis of increasing specialization,” a Navy official in charge of research money for experiments, has often been called a strange attractor.

## Credits

The text from `chaos.txt` is from James Gleick's excellent [Chaos: Making a New Science](https://en.wikipedia.org/wiki/Chaos%3A_Making_a_New_Science)