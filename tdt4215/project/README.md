webint
======

web intelligence project - search system



Develop and design a search system.

use patient record notes as search queries

based on a sentence, find relevant information in the handbook.
based on the sentences link therapy, drug, icd-10 codes, ATC classifications, 

index 
* the handbook 

Autocode
* ICD-10codes - list of decieses and symptoms. 

Tasks
-----
* rank and link ICD-10 codes to Sentences. 
* link drugs to sentences.
* link therapy to sentences.
* ATC ranking and linking towards Sentences. 

* calculate similarities between all ClinicalNotes and TherapyChapters in the handbook.
 * need a term by document matrix consisting of all documents in ClinicalNotes and TherpyChapters
 
* calculate similarities between all ClinicalNotes i combined and TherapyChapters in the handbook.
 * need a term by document matrix consisting of all TherpyChapters as documents and the combined ClinicalNotes as one document. 


Object dependecies
-----
* PatientCase
 * ClinicalNote

* ClinicalNote 
  * Sentences

* Sentence
 * ATC
 * ICD-10 codes 
 * DrugsChapters
 * TherapyChapters

Objects
-----
* PatientCase
* Sentence
* TherapyChapter
* DrugChapter
* ATC
* ICD-10
* ClinicalNote

