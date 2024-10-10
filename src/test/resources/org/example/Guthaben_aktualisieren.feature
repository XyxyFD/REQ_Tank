Feature: Guthaben aktualisieren
  Als Kunde möchte ich mein Guthaben aufladen können, um weiterhin Ladevorgänge an den Ladestationen durchführen zu können.

  Background:
    Given der Kunde ist in der App eingeloggt
    And der Kunde hat ein bestehendes Guthaben

  Scenario: Guthaben erfolgreich aufladen
    When der Kunde den Betrag von 20 Euro zum Aufladen auswählt
    And die Zahlungsmethode „Kreditkarte“ auswählt
    And der Kunde die Zahlungsinformationen eingibt
    And der Kunde die Schaltfläche „Guthaben aufladen“ klickt
    Then sollte das Guthaben des Kunden um 20 Euro erhöht werden
    And eine Bestätigung „Guthaben erfolgreich aufgeladen“ sollte angezeigt werden
    And der aktuelle Guthabenstand sollte aktualisiert angezeigt werdengit

  Scenario: Fehler bei der Zahlung verarbeiten
    Given der Kunde hat eine ungültige Kreditkarte eingegeben
    When der Kunde versucht, das Guthaben aufzuladen
    Then sollte eine Fehlermeldung „Zahlung konnte nicht verarbeitet werden. Bitte überprüfen Sie Ihre Zahlungsinformationen“ angezeigt werden
    And das Guthaben sollte unverändert bleiben

  Scenario: Guthabenhistorie einsehen
    Given der Kunde hat mehrere Guthabenaufladungen durchgeführt
    When der Kunde die Ansicht „Guthabenhistorie“ auswählt
    Then sollten alle vergangenen Guthabenaufladungen mit Datum, Betrag und Zahlungsmethode angezeigt werden