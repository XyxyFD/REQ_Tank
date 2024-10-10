Feature: Betrag auswählen
  Als Kunde möchte ich einen Betrag auswählen können, um mein Guthaben aufzuladen und zukünftige Dienstleistungen zu nutzen.

  Background:
    Given ein registrierter Kunde ist eingeloggt
    And der Kunde befindet sich auf der Seite „Guthaben aufladen“

  Scenario: Standard-Betrag auswählen
    When der Kunde einen vordefinierten Betrag (z.B. 10 €, 20 €, 50 €) auswählt
    And auf die Schaltfläche „Weiter“ klickt
    Then sollte der ausgewählte Betrag im nächsten Schritt zur Bestätigung angezeigt werden
    And die Schaltfläche „Bestätigen“ sollte aktiviert sein

  Scenario: Benutzerdefinierten Betrag eingeben
    When der Kunde im Feld „Betrag“ einen benutzerdefinierten Betrag eingibt (z.B. 35 €)
    And auf die Schaltfläche „Weiter“ klickt
    Then sollte der eingegebene Betrag im nächsten Schritt zur Bestätigung angezeigt werden
    And die Schaltfläche „Bestätigen“ sollte aktiviert sein

  Scenario: Betrag bestätigen und aufladen
    Given der Kunde hat einen gültigen Betrag ausgewählt
    When der Kunde auf die Schaltfläche „Bestätigen“ klickt
    Then sollte eine Bestätigungsmeldung „Ihr Guthaben wurde erfolgreich aufgeladen“ angezeigt werden
    And der Betrag sollte dem Kundenkonto gutgeschrieben werden