Feature: Ladestatus verfolgen
  Als Kunde möchte ich den Ladestatus meines Fahrzeugs während eines Ladevorgangs verfolgen können, um über den Fortschritt und die verbleibende Zeit informiert zu sein.

  Background:
    Given der Kunde hat einen Ladevorgang an einer Ladestation gestartet
    And der Ladevorgang läuft

  Scenario: Ladestatus in Echtzeit verfolgen
    When der Kunde die mobile App öffnet
    And die Ansicht „Ladevorgang“ auswählt
    Then sollte der aktuelle Ladestatus in Echtzeit angezeigt werden
    And der Fortschritt des Ladevorgangs sollte in Prozent und kWh sichtbar sein
    And die verbleibende Ladezeit sollte angezeigt werden

  Scenario: Benachrichtigung bei Ladeschluss erhalten
    Given der Ladevorgang läuft
    When der Ladevorgang abgeschlossen ist
    Then sollte der Kunde eine Benachrichtigung „Ladevorgang abgeschlossen“ in der mobilen App erhalten
    And der Endstand in kWh und die Gesamtkosten sollten angezeigt werden

  Scenario: Ladestatus bei Stromunterbrechung anzeigen
    Given der Ladevorgang läuft
    When eine Stromunterbrechung auftritt
    Then sollte eine Warnmeldung „Ladevorgang unterbrochen – bitte überprüfen Sie die Stromversorgung“ angezeigt werden
    And der Kunde sollte die Möglichkeit haben, eine Benachrichtigung zu erhalten, wenn der Strom wieder verfügbar ist