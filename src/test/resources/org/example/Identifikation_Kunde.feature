Feature: Kundenidentifikation per ID beim Start eines Ladevorgangs
  Als Kunde möchte ich mich beim Start eines Ladevorgangs eindeutig identifizieren können, um sicherzustellen, dass der Ladevorgang meinem Konto zugeordnet wird.

  Background:
    Given eine Ladestation ist betriebsbereit
    And der Kunde hat eine gültige Kunden-ID (z. B. RFID-Karte oder Kunden-ID)

  Scenario: Ladevorgang durch Kunden-ID starten
    When der Kunde seine Kunden-ID an die Ladestation hält oder eingibt
    And die Ladestation die Kunden-ID erfolgreich erkennt
    Then sollte der Kunde eine Bestätigung „Kunden-ID erkannt“ erhalten
    And die Ladestation sollte den Ladevorgang bereit zum Start anzeigen

  Scenario: Fehlermeldung bei ungültiger Kunden-ID
    When der Kunde eine ungültige Kunden-ID an die Ladestation hält oder eingibt
    Then sollte eine Fehlermeldung „Ungültige Kunden-ID. Bitte versuchen Sie es erneut.“ angezeigt werden
    And der Ladevorgang sollte nicht gestartet werden

  Scenario: Ladevorgang ohne Identifikation starten verhindern
    Given der Kunde hat keine Kunden-ID eingegeben
    When der Kunde versucht, den Ladevorgang zu starten
    Then sollte eine Meldung „Bitte identifizieren Sie sich, um den Ladevorgang zu starten“ angezeigt werden
    And der Ladevorgang sollte nicht beginnen