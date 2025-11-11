# 🎓 Studentenverwaltungssystem (Java Konsolenanwendung)

Ein einfaches **Java-Konsolenprogramm** zur Verwaltung von Studentendaten.  
Das System unterstützt das Hinzufügen, Löschen, Bearbeiten und Anzeigen von Studenteninformationen und speichert alle Daten in einer Textdatei zur dauerhaften Speicherung.

---

## 📘 1. Projektbeschreibung
- Dieses Projekt wurde entwickelt, um die Grundlagen der objektorientierten Programmierung in Java zu üben.
  Es bietet jetzt auch ein **einfaches Login-/Registrierungssystem** und eine **verbesserte Konsolenanzeige**.

  **Enthaltene Themen:**

  - Klassen und Objekte
  - Collections (`ArrayList`)
  - Dateioperationen (Lesen & Schreiben)
  - Konsoleneingabe und -ausgabe (Scanner)
  - Benutzerverwaltung (`Login / Registrierung`)

---

## 🧩 2. Systemfunktionen

### Hauptmenü

```bash
=========== Willkommen im Studentenverwaltungssystem ===========
1. Benutzer registrieren
2. Anmeldung
3. Student hinzufügen
4. Student löschen
5. Student bearbeiten
6. Studenten anzeigen
7. Beenden
===============================================================
Bitte wählen Sie eine Option:

```

### Benutzerverwaltung

- **Registrierung:** Eingabe eines Benutzernamens und Passworts, Speicherung in `users.txt`
- **Anmeldung:** Nur registrierte Benutzer können auf das System zugreifen
- **Mehrbenutzerfähig:** Jeder Benutzer kann seine eigenen Studentendaten verwalten

### Studentendaten
| Attribut | Beschreibung                     |
| -------- | -------------------------------- |
| id       | Eindeutige Identifikationsnummer |
| name     | Name des Studenten               |
| age      | Alter                            |
| address  | Wohnadresse                      |

- ### Funktionsbeschreibung

  - **Hinzufügen:** Neuen Studenten anlegen (ID muss eindeutig sein)
  - **Löschen:** Studenten anhand der ID entfernen
  - **Bearbeiten:** Name, Alter oder Adresse ändern
  - **Anzeigen:** Alle gespeicherten Studenteninformationen anzeigen
  - **Beenden:** Änderungen automatisch in `students.txt` speichern

## 🎨 3. Konsolenoberfläche

✅ Verbesserte Menüstruktur mit klaren Linien und Abständen
✅ Freundlichere Eingabeaufforderungen
✅ Farbige oder symbolische Ausgaben (je nach Terminalunterstützung)

Beispiel:

```bash
✨ Student erfolgreich hinzugefügt!
📁 Daten wurden in students.txt gespeichert.
```



---

## 📂 3. Projektstruktur
```bash
StudentManagementSystem/
│
├── students.txt                # Datei zur Speicherung der Studentendaten
├── users.txt                   # Datei zur Speicherung der Benutzerdaten (Login/Registrierung)
├── README.md                   # Hauptdokumentation (Chinesisch/Englisch)
├── README_DE.md                # Deutsche Dokumentation
└── src/
    ├── Student.java            # Datenklasse für Studenten
    ├── StudentService.java     # Logik (CRUD + Dateioperationen)
    ├── UserService.java        # Benutzerverwaltung (Login / Registrierung)
    ├── StudentManagementApp.java  # Haupteinstiegspunkt (main-Methode)
    └── UIHelper.java           # Konsolen-UI-Verbesserungen (optional)

```



---

## ▶️ 4. Ausführung
1. Repository klonen:

   ~~~bash
   git clone https://github.com/yourname/StudentManagementSystem.git
   cd StudentManagementSystem
   ~~~

2. In IntelliJ IDEA oder einer anderen Java-IDE öffnen

3. Sicherstellen, dass sich `students.txt` und `users.txt` im Hauptverzeichnis befinden

4. `StudentManagementApp.java` ausführen

5. Den Anweisungen in der Konsole folgen

##🧠 5. Technische Punkte

- Java SE
- Collections (ArrayList)
- Dateioperationen (BufferedReader / BufferedWriter)
- Konsoleninteraktion (Scanner)
- Objektorientierte Programmierung
- Benutzerverwaltung (Login & Registrierung)

##🌱 6. Zukünftige Verbesserungen

- ✅ Konsolen-UI überarbeitet
- ✅ Login-/Registrierungssystem implementiert
- ⏳ Eingabevalidierung verbessern
- 🚀 Grafische Benutzeroberfläche (JavaFX / Swing) planen

##👨‍💻 Autor

**Autor**: Shawn Huang

**Erstellt am**:November2025

**Technologien**: Java SE, Collections, I/O, CLI



💬 *Dieses Projekt dient ausschließlich zu Lernzwecken. Forks und Vorschläge sind willkommen!*

