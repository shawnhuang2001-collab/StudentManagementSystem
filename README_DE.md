# 🎓 Studentenverwaltungssystem (Java Konsolenanwendung)

Ein einfaches **Java-Konsolenprogramm** zur Verwaltung von Studentendaten.  
Das System unterstützt das Hinzufügen, Löschen, Bearbeiten und Anzeigen von Studenteninformationen und speichert alle Daten in einer Textdatei zur dauerhaften Speicherung.

---

## 📘 1. Projektbeschreibung
Dieses Projekt wurde entwickelt, um die Grundlagen der objektorientierten Programmierung in Java zu üben.  
Es zeigt den Umgang mit:
- Klassen und Objekten  
- Collections (`ArrayList`)  
- Dateioperationen (Lesen und Schreiben)  
- Konsoleneingabe und -ausgabe (`Scanner`)

---

## 🧩 2. Systemfunktionen

### Hauptmenü
-------------Willkommen im Studentenverwaltungssystem-------------
1: Student hinzufügen
2: Student löschen
3: Student bearbeiten
4: Studenten anzeigen
5: Beenden
Bitte wählen Sie eine Option:

### Studentendaten
| Attribut | Beschreibung                     |
| -------- | -------------------------------- |
| id       | Eindeutige Identifikationsnummer |
| name     | Name des Studenten               |
| age      | Alter                            |
| address  | Wohnadresse                      |

### Funktionsbeschreibung
- **Hinzufügen** – Eingabe von Studentendaten, ID muss eindeutig sein  
- **Löschen** – Entfernt einen Studenten anhand der ID  
- **Bearbeiten** – Ändert Name, Alter oder Adresse eines bestehenden Studenten  
- **Anzeigen** – Zeigt alle gespeicherten Studenteninformationen an  
- **Beenden** – Speichert alle Änderungen in der Datei `students.txt`

---

## 📂 3. Projektstruktur
StudentManagementSystem/
├── students.txt # Datei zur Speicherung der Studentendaten
├── README.md # Dokumentation (Chinesisch/Englisch)
└── src/
├── Student.java # Datenklasse für Studenten
├── StudentService.java # Logik (CRUD + Dateioperationen)
└── StudentManagementApp.java # Haupteinstiegspunkt (main-Methode)

---

## ▶️ 4. Ausführung
1. Repository klonen:

   ~~~bash
   git clone https://github.com/yourname/StudentManagementSystem.git
   ~~~

2. Projekt in IntelliJ IDEA oder einer anderen Java-IDE öffnen

3. Sicherstellen, dass sich die Datei students.txt im Hauptverzeichnis befindet

4. StudentManagementApp.java ausführen

5. Im Terminal den Anweisungen folgen

##🧠 5. Technische Punkte

- Java SE
- Collections (ArrayList)
- Dateioperationen (BufferedReader / BufferedWriter)
- Konsoleninteraktion (Scanner)
- Objektorientierte Programmierung

##🌱 6. Zukünftige Verbesserungen

- Optimierung der Dateioperationen
- Eingabevalidierung (z. B. Altersbereich, Adressformat)
- Benutzerverwaltung (Login, Registrierung, Passwort-Reset)
- Erweiterung zu einer grafischen Oberfläche (JavaFX / Swing)

##👨‍💻 Autor

**Autor**: Shawn Huang

**Erstellt am**: Oktober 2025

**Technologien**: Java SE, Collections, I/O, CLI



💬 *Dieses Projekt dient ausschließlich zu Lernzwecken. Forks und Vorschläge sind willkommen!*

