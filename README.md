**Goal**

Using an external spelling correction program in conjunction with Solr and to enhance the autocomplete functionality of Solr. Final outcome is a web based search engine used to extract the required queried document which were indexed on solr core.

**Regarding files**

 *index.php* : Main file aggregated with all logic
 *TikaParser.java* : Parser written to extract data from HTML document files which generates big.txt
 *SpellCorrector.php* : Norvig's spell correction algorithm in which the input file is big.txt, generated from our document set
 *simple_html_dom.php* : File used in generating snippites from the description of documents based on keywords.

 **Prerequisites**
 1. You need to have Solr installed in your system.
 2. Create a core in Solr to store your documents
 3. Index your documents in that core
 


