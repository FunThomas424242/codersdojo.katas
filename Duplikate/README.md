Historie
========

Dieses Kata wurde von FunThomas424242 erstellt und durch die 
[LGPL v3.0](http://opensource.org/licenses/LGPL-3.0) geschützt.

Motivation
==========

Bei der Arbeit als Entwickler stellte ich häufig fest, dass oft nicht klar war
warum beim Überschreiben der *equals* Methode auch die *hashCode* Methode 
überschrieben werden muss. Außerdem war auch oft nicht klar wie diese eigentlich
zu implementieren ist. Um genau dies zu erlernen habe ich für mich selbst 
dieses Kata ausgedacht.

Aber warum soll ich das Wissen für mich behalten - durch dieses Projekt möchte 
ich anderen Entwicklern die Möglichkeit geben ihre eigenen Erfahrungen zu sammeln.

Lösen des Katas
===============

Story
-----
Ein Schüler soll ein Programm schreiben mit dem Bücher in einer Datenbank 
eingetragen werden können. Immer wenn ein Buch erfasst wurde soll das 
Programm prüfen ob dieses Buch bereits in der Datenbank enthalten ist. 
Für diese Prüfung sollen die Felder Titel, Autor und Veröffentlichungsdatum
herangezogen werden (Dem Lernen zu Liebe wird angenommen sie seien unique
und es gäbe keine ISBN). Zusätzlich zu den genannten Feldern besitzen die 
Bücher noch ein Feld für die Datenbank Id.

Benutzung
---------
Ich habe lange überlegt was wohl den größten Lernerfolg bringt:

* Nur eine Aufgabenstellung
* Eine Aufgabenstellung mit möglichst vollständigen Test 

Letztlich habe ich mich für die Aufgabenstellung mit vollständigen Test entschieden,
weil ich nicht so wortgewandt bin um eine unmissverständliche Aufgabenstellung
nieder zu schreiben und weil die Lernkurve ohne Test evtl. zu steil wäre.

Aufgabe
-------

1. Starte die run-endless.cmd um das Aufzeichnen des Katas zu starten
2. Führe die Klasse BuchTest als JUnit Test aus
3. Implementiere in der Klasse Buch die Methoden hashCode und equals so dass der 
JUnit Test grün wird.
4. Vergleiche Deine Lösungen mit Anderen.
5. Überlege ob das Kata zu erweitern oder fehlerhaft ist, korrigiere oder
erweitere es und sende mir einen Pull Request auf github.com.







