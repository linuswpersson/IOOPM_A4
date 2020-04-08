# IOOPM_A4
Repo for assignment 4 of the 2019 IOOPM course.


Köra Programmet:

För att kompelera programmet och des teset:

$make

för att köra programmet:

$make run

för att köra alla tester (kräver Junit-4.12.jar och hamcrest-core-1.3.jar i repo mappen):

$make run_test



Design Beslut -

Angående designbeslut så tror jag att de mesta av implementationerna på de olika tickets är ganska "standard" i den mening att jag följde de varierande design-tips utförligt och därmed nog uppnått ett program som är nära den pedagogiska "visionen". För lagring av "funktions-operationer", agrument och annat använde jag mig av LinkedLists då det känndes som ett smidigt och lätt-användligt val för mig att lagra sorterad data.

Den kanske stora avvikningen när det kommer till designen var att jag när jag parsar Sequence data (alltså functionskroppen) på en funktionsdeklaration försökte fånga så många syntax, samt icke-korrekt deklarationer redan i main-funktionen. Jag hade tanken att det skulle vara snyggt om jag kunde garantera användaren av programmet att alla funktionsdeklarationer var korrekta innan evaluation då detta innebär att funktioner som kalla på funktioner(andra än sig själva) då kunde vara garanterade att innangjorda deklarationer inte var felaktiga. Tanken var bra, men koden blev lite väl oskött, och om jag skrivit om programmet hade jag nog skrotat min orginal idé och skrivit en visitor som utvärderar dåliga funktionsdeklarationer vid evaluation som instruktionerna rekommenderade.