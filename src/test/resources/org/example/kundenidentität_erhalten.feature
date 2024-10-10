Feature: Kundenidentität erhalten
  Als Systembetreiber möchte ich die Identität eines Kunden erhalten und speichern, damit der Kunde eindeutig identifiziert werden kann und personalisierte Services erhält.

  Background:
    Given ein neuer Kunde hat sich registriert
    And der Kunde hat die E-Mail-Bestätigung abgeschlossen

  Scenario: Kundenidentität durch Profilangaben speichern
    Given der Kunde befindet sich auf der Seite zur Identitätsangabe
    When der Kunde seinen vollständigen Namen, Geburtsdatum und eine gültige Telefonnummer eingibt
    And auf die Schaltfläche „Speichern“ klickt
    Then sollten die Angaben zur Kundenidentität gespeichert werden
    And eine Bestätigungsmeldung „Identität erfolgreich gespeichert“ sollte angezeigt werden

  Scenario: Fehlende Pflichtangaben beim Speichern
    Given der Kunde befindet sich auf der Seite zur Identitätsangabe
    When der Kunde nur seinen vollständigen Namen eingibt und die anderen Felder leer lässt
    And auf die Schaltfläche „Speichern“ klickt
    Then sollte eine Fehlermeldung „Bitte füllen Sie alle Pflichtfelder aus“ angezeigt werden
    And die Identitätsdaten sollten nicht gespeichert werden

  Scenario: Kundenidentität einsehen
    Given der Kunde ist eingeloggt
    When der Kunde sein Profil öffnet
    Then sollten die Daten zur Kundenidentität angezeigt werden, einschließlich vollständigem Namen, Geburtsdatum und Telefonnummer