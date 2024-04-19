# Schwarzmarkthändler
[![Maven Build](https://github.com/Wolfpack-Rudel/schwarzmarktheandler/actions/workflows/maven.yml/badge.svg)](https://github.com/Wolfpack-Rudel/schwarzmarktheandler/actions/workflows/maven.yml)
## Übersicht
Das Minecraft-Plugin "Schwarzmarkthandler" bietet eine spannende Ergänzung zum Spiel, indem es den Spielern die Möglichkeit gibt, täglich verschiedene Quests zu erledigen, um Punkte zu sammeln. Diese Punkte können dann gegen saisonale Items oder spezielle Punkte wie "Gold" eingetauscht werden.

Mit einer Vielzahl von Quests, die täglich zur Verfügung stehen, können die Spieler ihre Fähigkeiten und ihr Wissen über Minecraft unter Beweis stellen. Ob es darum geht, seltene Ressourcen zu sammeln, Monster zu bekämpfen, Herausforderungen zu meistern oder spezielle Aufgaben zu erfüllen, es gibt für jeden Spieler etwas Passendes.

Die gesammelten Punkte bieten den Spielern die Möglichkeit, auf exklusive saisonale Items zuzugreifen oder in besonderen Shops einzigartige Gegenstände zu erwerben. Diese Items können das Spielerlebnis erheblich bereichern und den Spielern einen Vorteil verschaffen.

Durch die Integration des Schwarzmarkthandlers wird das Gameplay von Minecraft noch abwechslungsreicher und belohnender, während die Spieler neue Ziele setzen und sich Herausforderungen stellen können. Tauche ein in die Welt des Schwarzmarkthandlers und erlebe spannende Abenteuer, während du deine Punkte sammelst und dich auf die Jagd nach exklusiven Belohnungen begibst!

## Inhaltsangabe
1. [Übersicht](#übersicht)
2. [Inhaltsangabe](#inhaltsangabe)
3. [Plugin Informationen](#plugin-informationen)
4. [Verfügbare QuestTypes](#verfügbare-questtypes)
   1. [BREAK](#break)
   2. [BUILD](#build)
   3. [CRAFT](#craft)
   4. [KILL](#kill)
   5. [USE](#use)
   6. [CONSUME](#consume)
5. [Configuration](#configuration)
   1. [Allgemeines zur Configurations Datei](#allgemeines-zur-configurations-datei)
   2. [Positionen des Handlers](#positionen-des-handlers)
   3. [Quests](#quests)
6. 

## Plugin Informationen
- Name: Schwarzmarkthändler
- Version: 0.0.1
- API-Version: 1.20
- Prefix: SH-WP
- Load: Postworld
- Authors:
  - LouiLetsPlayPro
  - ggf. Zigzig2042
- Description: Schwarzmarkthändler für den Skyblock Server von Wolfpack
- Website: https://wolfpack-rudel.de
- Dependencies:
  - PlaceholderAPI:
    - load: BEFORE
    - **required**

## Verfügbare QuestTypes
### BREAK
Dieser TYPE dient dazu, alle Block Abbau Ereignisse zu verarbeiten und in einer Quest abzuarbeiten. Das Material, welches abzubauen ist, muss ohne ``minecraft:`` angegeben werden und in CAPS, es sind alle Blöcke möglich, welche mittels der Hand oder einem Tool direkt abgebaut werden kann. (Nicht durch Events wie das Fallen von einem Drachenei auf eine Fackel)

### BUILD

> Coming Soon

### CRAFT

> Coming Soon

### KILL

> Coming Soon

### USE

> Coming Soon

### CONSUME
> Coming Soon

## Configuration
### Allgemeines zur Configurations Datei
Die config.yml ist eine zentrale Konfigurationsdatei für Minecraft-Plugins. In dieser Datei werden Einstellungen und Optionen festgelegt, die das Verhalten des Plugins beeinflussen. Von Spielmechaniken bis hin zu Benutzeroberflächen können Entwickler die Parameter in der config.yml anpassen, um das Plugin an die Bedürfnisse ihrer Community anzupassen. Durch die Bearbeitung dieser Datei können Serveradministratoren das Spielerlebnis feinabstimmen und eine maßgeschneiderte Umgebung schaffen. Die config.yml ist somit ein leistungsstarkes Werkzeug, um die Funktionalität und das Erscheinungsbild von Minecraft-Servern zu gestalten.
### Positionen des Handlers
Die Position des Handlers kann vielseitig sein und wird mit jedem Neustart ausgewählt, aus der im Vorhinein festgelegten Liste an Positionen.
Neue Positionen können in der ``config.yml`` hinzugefügt werden oder auch vorhandene bearbeitet. Dabei ist es vollkommen egal, wie viele locations für den Handler angelegt werden, es wird jedoch immer nur eine ausgewählt durch ein Zufallsprinzip.
Der "Name" der Location in der Liste ``locations`` ist dabei egal, da dieser nur angelegt sein muss, um den Zufallsgenerator einen Wert zu übermitteln, womit er arbeiten kann.

> [!NOTE]
> Dies ist nur ein Beispiel und muss für den jeweiligen Server angepasst und ggf. vervollständigt werden.

````yaml
locations:
  loc1:
    world: flat
    x: 0
    y: -60
    z: 0
    yaw: 90 #Rotation
    pitch: 0 #Hoch / Runter
  loc2:
    world: flat
    x: 5
    y: -60
    z: 5
    yaw: 180 #Rotation
    pitch: 0 #Hoch / Runter
  loc3:
    world: flat
    x: -5
    y: -60
    z: -5
    yaw: -90 #Rotation
    pitch: 0 #Hoch / Runter
````

Erweitert / abgeändert kann diese Beispiels liste jeweils mit folgendem:
````yaml
  loc1: #Name der Location (darf keine Lehrzeichen beinhalten) 
    world: flat #Name der Welt, auf welcher der Villager Spawnen soll 
    x: 0 #Koordinate X der Spawnlocation
    y: -60 #Koordinate Y der Spawnlocation
    z: 0 #Koordinate Z der Spawnlocation
    #Nun Folgen die Werte für die Ausrichtung des Villager in eine Blickrichtung
    yaw: 90 #Rotation
    pitch: 0 #Hoch / Runter
````

### Quests
Die Quests sind ebenfalls eine Liste, welche zufällig ausgewählt werden, auch hier muss ein Identifyer angegeben werden, welcher ohne Lehrzeichen auskommt.

> [!NOTE]
> Dies ist nur ein Beispiel und muss für den jeweiligen Server angepasst und ggf. vervollständigt werden.
````yaml
quests:
  # Liste kann unendlich erweitert werden
  # Material für kills ist die Entität!
  q1:
    name: "Bau Quest"
    description: "Baue 10 Stein Blöcke"
    type: "BUILD"
    min: 100
    points: 25
    material: "STONE"
  q2:
    name: "Abbau Quest"
    description: "Baue 10 Kohleblöcke ab"
    type: "BREAK"
    min: 100
    points: 50
    material: "COAL_BLOCK"
````

Auch hier gilt, dass jederzeit eine Erweiterung durch folgenden Abschnitt möglich ist.
````yml
  q1: #Identifyer
    name: "Bau Quest" #Name der Quest im Questmenü des Villagers
    description: "Baue 10 Stein Blöcke" #Beschreibung der Quest, welche der Villager mit angibt
    type: "BUILD" #QuestType -> Wie Oben beschrieben
    min: 100 #Die Anzahl, wie oft eine Aktion einer Quest ausgeführt werden soll.
    points: 25 #Die Punktzahl, welche der Spieler nach beenden der Quest erhällt
    material: "STONE" #Das Material, welcher durch die Quest bearbeitet werden soll
````

## Command übersicht
Alle Commands wurden mittels AIKAR erstellt, welches uns einen kleineren und Effektiveren Code zur verfügung zu stellen, welcher auch einen zuverlässigen Fehler angibt, wenn einer vorhanden ist.

Commandliste:
    

## Permissions Übersicht
Alle Permissions sind an Commands gebunden, wodruch dem Spieler keine Permissions gegeben werden müssen, um den Handler effektiv zu nutzen.
