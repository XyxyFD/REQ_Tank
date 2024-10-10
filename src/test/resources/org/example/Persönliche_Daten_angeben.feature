Feature: Persönliche Daten angeben
  Als Kunde möchte ich meine persönlichen Daten in meinem Profil angeben und aktualisieren, um sicherzustellen, dass meine Kontoinformationen korrekt und aktuell sind.

  Background:
    Given ein registrierter Kunde ist eingeloggt
    And der Kunde befindet sich auf der Profilseite

  Scenario: Persönliche Daten einsehen
    When der Kunde die Profilseite öffnet
    Then sollte der Kunde seine aktuellen persönlichen Daten sehen
    And die Datenfelder sollten den aktuellen Namen, die Adresse, die E-Mail-Adresse und die Telefonnummer anzeigen

  Scenario: Persönliche Daten aktualisieren
    Given der Kunde befindet sich auf der Profilseite
    When der Kunde seinen Namen und seine Adresse ändert
    And auf die Schaltfläche „Speichern“ klickt
    Then sollten die geänderten Daten gespeichert werden
    And eine Bestätigungsmeldung „Daten erfolgreich gespeichert“ sollte angezeigt werden
    And die geänderten Daten sollten auf der Profilseite sichtbar sein

  Scenario: Ungültige E-Mail-Adresse eingeben
    Given der Kunde befindet sich auf der Profilseite
    When der Kunde eine ungültige E-Mail-Adresse eingibt
    And auf die Schaltfläche „Speichern“ klickt
    Then sollte eine Fehlermeldung „Bitte geben Sie eine gültige E-Mail-Adresse ein“ angezeigt werden
    And die Daten sollten nicht gespeichert werden

